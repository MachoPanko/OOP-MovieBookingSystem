package model.enums;

/**
 * Enumerations of type of cinema
 */
public enum CinemaType {
    //can just change the name of cinema classes/experiences
    Platinum("Platinum"),
    IMAX("IMAX"),
    Economy("Economy");

    private String type;

    /**
     * CinemaType constructor
     * @param type string, invaraints unchecked
     */
    CinemaType(String type) { this.type = type;}

    /**
     * Converts string choice to CinemaType
     * @param choice string, invaraints unchecked
     * @return CinemaType
     */

    public static CinemaType getType(String choice) {
        if(choice.equals("Platinum")){
            return Platinum;
        }
        else if(choice.equals("Economy")){
            return Economy;
        }
        else if (choice.equals("IMAX")){
            return IMAX;
        }
        else return null;
    }
}
