package com.example.parkhere;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
public class ParkController {

    @GetMapping("/location")
    public List<ReturnMessage> locationToPlace(@RequestParam double lat, @RequestParam double lng) throws IOException {
        Location location = new Location(lat, lng);
        ApiCall apiCall = new ApiCall(location);
        System.out.println(location.getLatitude() + " " + location.getLongitude());
        return apiCall.getPlaces();
    }

}
