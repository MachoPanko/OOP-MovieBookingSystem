package model.enums;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public enum DayType {  /// MUST INITIALIZE WITH yyyy-MM-dd format

    WEEKDAY("Weekday"),
    FRIDAY("Friday"),
    THURSDAY("Thursday"),
    WEEKEND("Weekend"),
    HOLIDAY("Holiday");

    private String day1;
    private static Date day;
    private static String dayString;
    private static ArrayList<String> holidayDates = new ArrayList<String>(List.of("0101","0102","0202","1504","0205","0305","1605","1107","0908","2410","2612"));

    DayType(String day) {
        this.day1=day;
    }

    public static DayType getType(String date) {
        day = parseDate(date);
        dayString =   date.substring(0,2) + date.substring(3,5);
        Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("Singapore"));
        c1.setTime(day);
        for ( String holidays : holidayDates){
            if ( dayString.equals(holidays)){
                return HOLIDAY;
            }
        }
        if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ){
            return WEEKEND;
        }
        else if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY ){
            return FRIDAY;
        }
        else if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
            return THURSDAY;
        }
        else {
            return WEEKDAY;
        }
    }

    private static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static void addHoliday(String newHoliday){
        holidayDates.add(newHoliday);
    }
    public static void deleteHoliday(String holiday){
        holidayDates.remove(holiday);
    }
}
