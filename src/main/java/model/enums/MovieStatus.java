package model.enums;

public enum MovieStatus {

    COMING_SOON("COMING_SOON"),
    PREVIEW("PREVIEW"),
    NOW_SHOWING("NOW_SHOWING");

    private String status;

    MovieStatus(String status){
        this.status = status;
    }

    public static MovieStatus getMovieStatus(String choice) {
        choice = choice.toUpperCase();
        if(choice.equals("COMING_SOON")){
            return COMING_SOON;
        }
        else if(choice.equals("PREVIEW")){
            return PREVIEW;
        }
        else if (choice.equals("NOW_SHOWING")){
            return NOW_SHOWING;
        }
        else return null;
    }
}
