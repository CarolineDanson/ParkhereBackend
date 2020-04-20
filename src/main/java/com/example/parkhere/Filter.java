package com.example.parkhere;

public class Filter {
    Boolean isFordon;
    Boolean hasAllowed;

    public Boolean hasRelevantContentMethod(Place place) {
        hasAllowed = false;
        if (place.getParkingAllowed() != null || place.getMaxParkingHours() != null) {
            hasAllowed = true;
        }
        return hasAllowed;
    }
    public Boolean isFordonMethod(Place place) {
        isFordon = false;
        if (place.vehicle.equals("fordon")) {
            isFordon = true;
        }
        return isFordon;
    }


}
