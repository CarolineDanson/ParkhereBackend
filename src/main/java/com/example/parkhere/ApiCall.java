package com.example.parkhere;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ApiCall {

    public PlaceBuilder pb = new PlaceBuilder();
    private Place place = null;
    public List<ReturnMessage> returnList = new ArrayList<>();
    public Filter filter = new Filter();
    public ReturnBuilder returnBuilder = new ReturnBuilder();
    ParkService parkService = new ParkService();


    @SuppressWarnings("unchecked")
    public ApiCall(Location location, ApiKey apiKey) throws IOException {

        String apiCallJSONOutput = "";

        URL url = new URL("https://openparking.stockholm.se/LTF-Tolken/v1/ptillaten/within?radius=200&lat=" + location.latitude + "&lng=" + location.longitude + "&outputFormat=json&apiKey=" + apiKey.currentKey);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.connect();
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("HTTP response code:" + responseCode);
        } else {
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                apiCallJSONOutput += scanner.nextLine();
            }
            scanner.close();
        }

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(apiCallJSONOutput);

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray features = (JSONArray) jsonObject.get("features");

            Iterator<JSONObject> iterator = features.iterator();
            while (iterator.hasNext()) {
                JSONObject object = iterator.next();
                JSONObject object1 = (JSONObject) object.get("properties");
                place = pb.placeBuilder(object1);
                if (filter.isFordonMethod(place)) {
                    parkService.makeDateTime(place);
                    if (filter.hasRelevantContentMethod(place)) {
                        returnList.add(returnBuilder.returnMessage(place));
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        for(ReturnMessage r : returnList) {
            System.out.println(r.getDistrict());
        }
    }


    public List<ReturnMessage> getPlaces() {
        return returnList;
    }
}

