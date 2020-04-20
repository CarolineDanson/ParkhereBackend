package com.example.parkhere;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReturnBuilder {
    public ReturnMessage returnMessage(Place place) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

        String address;
        String district= place.getCityDistrict();
        String dateToday= LocalDate.now().toString();
        String timeToday= dtf.format(LocalDateTime.now());
        String maxHours;
        String serviceMessage;
        String parkingStatus;

        if(place.getMaxParkingHours() != null) {
            maxHours = "Maximalt antal timmar: " + place.getMaxParkingHours().toString();
        } else {
            maxHours = "";
        }

        if (place.getServiceStartWeekday() != null) {
            serviceMessage = place.getOtherInfo();
        }else {
            serviceMessage = "";
        }

        if(!place.address.equals("<Adress saknas>")) {
            address = place.getAddress();
        } else {
            address = place.getStreetName();
        }

//        if(place.getParkingAllowed()) {
//            parkingStatus = "Aktuella föreskrifter tyder på att parkering är tillåten på denna plats just nu.";
//        } else {
//            parkingStatus = "Aktuella föreskrifter tyder på att parkering inte är tillåten på denna plats just nu.";
//        }

        ReturnMessage returnMessage = new ReturnMessage(address, district, dateToday, timeToday, maxHours, serviceMessage, place.getParkingAllowed());

        return returnMessage;
    }
}
