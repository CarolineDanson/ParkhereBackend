package com.example.parkhere;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class ParkService {

    public void makeDateTime(Place place) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalTime nowTime = LocalTime.now();
        LocalDate nowDate = LocalDate.now();
//        System.out.println(dtf.format(now));


        if(place.getServiceStartMonth() != null && nowDate.isAfter(constructStartDateObject(place)) && nowDate.isBefore(constructEndDateObject(place))) {
            System.out.println(place.getFeatureObjectID());
            System.out.println("this is start date: " + constructStartDateObject(place));
            System.out.println("this is end date: " + constructEndDateObject(place));

            if (place.getServiceStartWeekday() != null) {
                DayOfWeek startWeekday;

                switch (place.getServiceStartWeekday()) {
                    case "måndag":
                        startWeekday = DayOfWeek.valueOf("MONDAY");
                        break;
                    case "tisdag":
                        startWeekday = DayOfWeek.valueOf("TUESDAY");
                        break;
                    case "onsdag":
                        startWeekday = DayOfWeek.valueOf("WEDNESDAY");
                        break;
                    case "torsdag":
                        startWeekday = DayOfWeek.valueOf("THURSDAY");
                        break;
                    case "fredag":
                        startWeekday = DayOfWeek.valueOf("FRIDAY");
                        break;
                    case "lördag":
                        startWeekday = DayOfWeek.valueOf("SATURDAY");
                        break;
                    case "söndag":
                        startWeekday = DayOfWeek.valueOf("SUNDAY");
                        break;
                    default:
                        System.out.println("weekday is undefined");
                        startWeekday = null;
                }

                System.out.println(startWeekday);

                if (place.getServiceStartWeekday() != null && nowDateTime.getDayOfWeek() == startWeekday && nowTime.isAfter(constructStartTimeObject(place)) && nowTime.isBefore(constructEndTimeObject(place))) {
                    place.setParkingAllowed(false);
                } else {
                    place.setParkingAllowed(true);
                }

            }
        }

    }

    public LocalTime constructStartTimeObject(Place place) {
        LocalTime startTime;
        if(place.getServiceStartTime() != 0) {
            int startHour = (place.getServiceStartTime().intValue()) / 100;
            startTime = LocalTime.of(startHour, 0);
        } else {
            startTime = LocalTime.of(0, 0);
        }
        System.out.println("this is starttime " + startTime);
        return startTime;
    }

    public LocalTime constructEndTimeObject(Place place) {
        LocalTime endTime;
        if(place.getServiceEndTime() != 0) {
            int endHour = (place.getServiceEndTime().intValue()) / 100;
            endTime = LocalTime.of(endHour, 0);
        } else {
            endTime = LocalTime.of(0, 0);
        }
        System.out.println("this is end time " + endTime);
        return endTime;
    }

    public LocalDate constructStartDateObject(Place place){

        int startYear;
        int startMonth;
        int startDay;
        int endMonth = place.getServiceEndMonth().intValue();

        LocalDate now = LocalDate.now();
        startMonth = place.getServiceStartMonth().intValue();
        startDay = place.getServiceStartDate().intValue();
        if(startMonth > endMonth && startMonth <= now.getMonthValue()){
            startYear = now.getYear();
        } else if (startMonth >= now.getMonthValue() && now.getMonthValue() <= endMonth && endMonth >= startMonth) {
            startYear = now.getYear();
        } else
         {
            startYear = now.getYear()-1;
        }

        LocalDate date = LocalDate.of(startYear, startMonth, startDay);

        return date;
    }

    public LocalDate constructEndDateObject(Place place){

        int endYear;
        int endMonth;
        int endDay;

        endMonth = place.getServiceEndMonth().intValue();
        endDay = place.getServiceEndDate().intValue();
        LocalDate now = LocalDate.now();
        if(place.getServiceStartMonth().intValue() < now.getMonthValue()){
            endYear = now.getYear()+1;
        } else {
            endYear = now.getYear();
        }

        LocalDate date = LocalDate.of(endYear, endMonth, endDay);

        return date;
    }



}
