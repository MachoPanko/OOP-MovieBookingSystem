package model;

public enum CinemaType {
    //can just change the name of cinema classes/experiences
    Platinum("Platinum Movie Suites"),

    IMAX("IMAX Movie Theatre"),
    Economy("Economy Movie Suites");


    private String type;
    CinemaType(String type) { this.type = type;}

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
