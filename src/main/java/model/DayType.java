package model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



public enum DayType {  /// MUST INITIALIZE WITH yyyy-MM-dd format

    Weekday("Weekday"),
    Weekend("Weekdend"),
    Holiday("Holiday");

    private Date day;
    private String dayString;
    private ArrayList<String> holidayDates = new ArrayList<String>(List.of("0101","0102","0202","1504","0205","0305","1605","1107","0908","2410","2612"));
    DayType(String date) {// in hyphen separated format yyyy-MM-dd
        day = parseDate(date);
        dayString =   date.substring(8) + date.substring(5,7);
    }
    public DayType getType(){
        Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        c1.setTime(day);
        for ( String holidays : holidayDates){
            if ( dayString.equals(holidays)){
                return Holiday;
            }
        }
        if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ){
            return Weekend;
        }
        else {
            return Weekday;
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
