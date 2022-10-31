package model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



public enum DayType {

    Weekday("Weekday"),
    Weekend("Weekdend"),
    Holiday("Holiday");

    private Date day;
    DayType(String date) {// in hyphen separated format
        day = parseDate(date);
    }
    public DayType getType(){
        Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        c1.setTime(day);;
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
