package com.example.parkhere;

import org.json.simple.JSONObject;

public class Place {
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
    Boolean parkingAllowed;

    public Place(String vehicle, String streetName, String cityDistrict, Long serviceStartTime, Long serviceEndTime, String serviceStartWeekday, Long serviceStartMonth, Long serviceEndMonth, Long serviceStartDate, Long serviceEndDate, Long maxParkingHours, String address, Long featureObjectID, String otherInfo /*Boolean parkingAllowed*/) {
        this.vehicle = vehicle;
        this.streetName = streetName;
        this.cityDistrict = cityDistrict;
        this.serviceStartTime = serviceStartTime;
        this.serviceEndTime = serviceEndTime;
        this.serviceStartWeekday = serviceStartWeekday;
        this.serviceStartMonth = serviceStartMonth;
        this.serviceEndMonth = serviceEndMonth;
        this.serviceStartDate = serviceStartDate;
        this.serviceEndDate = serviceEndDate;
        this.maxParkingHours = maxParkingHours;
        this.address = address;
        this.featureObjectID = featureObjectID;
        this.otherInfo = otherInfo;
//        this.parkingAllowed = parkingAllowed;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCityDistrict() {
        return cityDistrict;
    }

    public Long getServiceStartTime() {
        return serviceStartTime;
    }

    public Long getServiceEndTime() {
        return serviceEndTime;
    }

    public String getServiceStartWeekday() {
        return serviceStartWeekday;
    }

    public Long getServiceStartMonth() {
        return serviceStartMonth;
    }

    public Long getServiceEndMonth() {
        return serviceEndMonth;
    }

    public Long getServiceStartDate() {
        return serviceStartDate;
    }

    public Long getServiceEndDate() {
        return serviceEndDate;
    }

    public Long getMaxParkingHours() {
        return maxParkingHours;
    }

    public String getAddress() {
        return address;
    }

    public Long getFeatureObjectID() {
        return featureObjectID;
    }

    public Boolean getParkingAllowed() {
        return parkingAllowed;
    }

    public void setParkingAllowed(Boolean parkingAllowed) {
        this.parkingAllowed = parkingAllowed;
    }

    public String toString() {
        String allElements = vehicle + " " + streetName + " " + cityDistrict + " " + serviceStartTime + " " + serviceEndTime + " " + serviceStartMonth + " " + serviceEndMonth + " " + serviceStartDate + " " + serviceEndDate + " " + maxParkingHours + " " + address + " " + serviceStartWeekday;
        return allElements;
    }
}
