package model.enums;

/**
 * Enumerations of status of movie
 */
public enum MovieStatus {

    COMING_SOON("COMING_SOON"),
    PREVIEW("PREVIEW"),
    NOW_SHOWING("NOW_SHOWING"),
    END_OF_SHOWING("END_OF_SHOWING");

    private String status;

    /**
     * Constructor for MovieStatus
     * @param status string, invariants unchecked
     */
    MovieStatus(String status){
        this.status = status;
    }

    /**
     * Converts string movie status to MovieStatus enum
     * @param choice string, invariants unchecked
     * @return MovieStatus
     */
    public static MovieStatus getMovieStatus(String choice) {
        return switch (choice.toUpperCase()) {
            case "COMING_SOON" -> COMING_SOON;
            case "PREVIEW" -> PREVIEW;
            case "NOW_SHOWING" -> NOW_SHOWING;
            case "END_OF_SHOWING" -> END_OF_SHOWING;
            default -> null;
        };
    }
}
