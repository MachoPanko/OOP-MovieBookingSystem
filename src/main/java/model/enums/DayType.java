package model.enums;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Enumeration of type of day
 */
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

    /**
     * Constructor for DayType
     * @param day string, invariants unchecked
     */
    DayType(String day) {
        this.day1=day;
    }

    /**
     * Converts string date to DayType
     * @param date string, invariants unchecked
     * @return DayType
     */
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

    /**
     * Parse the string date to Date
     * @param date string, invariants unchecked
     * @return Date
     */
    private static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * Adds a new holiday
     * @param newHoliday New holiday to be added
     */
    public static void addHoliday(String newHoliday){
        holidayDates.add(newHoliday);
    }

    /**
     * Deletes a holiday
     * @param holiday Holiday to be deleted
     */
    public static void deleteHoliday(String holiday){
        holidayDates.remove(holiday);
    }
}
