package model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



public enum DayType {  /// MUST INITIALIZE WITH yyyy-MM-dd format

    WEEKDAY("Weekday"),
    WEEKEND("Weekdend"),
    HOLIDAY("Holiday");

    private String day1;
    private static Date day;
    private static String dayString;
    private static ArrayList<String> holidayDates = new ArrayList<String>(List.of("0101","0102","0202","1504","0205","0305","1605","1107","0908","2410","2612"));

    DayType(String day) {
        this.day1=day;
    }

    public static DayType getType(String date){
        day = parseDate(date);
        dayString =   date.substring(8) + date.substring(5,7);
        Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        c1.setTime(day);
        for ( String holidays : holidayDates){
            if ( dayString.equals(holidays)){
                return HOLIDAY;
            }
        }
        if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ){
            return WEEKEND;
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

}
