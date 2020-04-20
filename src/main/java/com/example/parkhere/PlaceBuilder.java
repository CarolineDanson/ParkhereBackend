package com.example.parkhere;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Date;

public class PlaceBuilder {

    String vehicle;
    String streetName;
    String cityDistrict;
    Long serviceStartTime;
    Long serviceEndTime;
    String serviceStartWeekday;
    Long serviceStartMonth;
    Long serviceEndMonth;
    Long serviceStartDate;
    Long serviceEndDate;
    Long maxParkingHours;
    String address;
    Long featureObjectID;
    String otherInfo;


    public Place placeBuilder (JSONObject object) {
        vehicle = (String) object.get("VEHICLE");
        streetName = (String) object.get("STREET_NAME");
        cityDistrict = (String) object.get("CITY_DISTRICT");
        serviceStartTime = (Long) object.get("END_TIME"); //OBS Stockholmsstads API har detta bakvänt!
        serviceEndTime = (Long) object.get("START_TIME");
        serviceStartWeekday = (String) object.get("START_WEEKDAY");
        serviceStartMonth = (Long) object.get("START_MONTH");
        serviceEndMonth = (Long) object.get("END_MONTH");
        serviceStartDate = (Long) object.get("START_DAY");
        serviceEndDate = (Long) object.get("END_DAY");
        maxParkingHours = (Long) object.get("MAX_HOURS");
        address = (String) object.get("ADDRESS");
        otherInfo = (String) object.get("OTHER_INFO");

        //Detta ID gäller om flera objekt hänvisar till samma parkeringsplats men under olika tider på året. Alltså kan flera JSON objekt ha samma ID.
        featureObjectID =  (Long) object.get("FEATURE_OBJECT_ID");

        Place place = new Place(vehicle, streetName, cityDistrict, serviceStartTime, serviceEndTime, serviceStartWeekday, serviceStartMonth, serviceEndMonth, serviceStartDate, serviceEndDate, maxParkingHours, address, featureObjectID, otherInfo);

//       System.out.println(place.toString());
       return place;
    }

}
