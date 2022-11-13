package model.enums;

/**
 * What kind of Movie this is
 */
public enum MovieTag {
    BLOCKBUSTER("BLOCKBUSTER"),
    NORMAL("NORMAL"),
    THREED("3D");

    private String tag;

    /**
     * Constructor for MovieTag
     * @param tag string, invariants unchecked
     */
    MovieTag(String tag){
        this.tag = tag;
    }

    /**
     * Converts string to MovieTag
     * @param choice string, invariants unchecked
     * @return MovieTag
     */
    public static MovieTag getMovieTag(String choice) {
        choice = choice.toUpperCase();
        return switch (choice) {
            case "BLOCKBUSTER" -> BLOCKBUSTER;
            case "NORMAL" -> NORMAL;
            case "3D" -> THREED;
            default -> null;
        };
    }
}
