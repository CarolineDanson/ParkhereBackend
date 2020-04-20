package com.example.parkhere;

public class ReturnMessage {
    String returnAddress;
    String district;
    String dateToday;
    String timeToday;
    String maxHours;
    String serviceMessage;
    boolean parkingStatus;

    public ReturnMessage(String returnAddress, String district, String dateToday, String timeToday, String maxHours, String serviceMessage, boolean parkingStatus) {
        this.returnAddress = returnAddress;
        this.district = district;
        this.dateToday = dateToday;
        this.timeToday = timeToday;
        this.maxHours = maxHours;
        this.serviceMessage = serviceMessage;
        this.parkingStatus = parkingStatus;
    }

    public String getReturnAddress() {
        return returnAddress;
    }

    public boolean getParkingStatus() {
        return parkingStatus;
    }

    public String getDistrict() {
        return district;
    }

    public String getDateToday() {
        return dateToday;
    }

    public String getTimeToday() {
        return timeToday;
    }

    public String getMaxHours() {
        return maxHours;
    }

    public String getServiceMessage() {
        return serviceMessage;
    }

}
