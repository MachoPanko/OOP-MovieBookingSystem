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
        return switch (choice.toUpperCase()) {
            case "COMING_SOON" -> COMING_SOON;
            case "PREVIEW" -> PREVIEW;
            case "NOW_SHOWING" -> NOW_SHOWING;
            default -> null;
        };
    }
}
