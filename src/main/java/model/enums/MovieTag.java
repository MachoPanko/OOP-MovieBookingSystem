package model.enums;

public enum MovieTag {
    BLOCKBUSTER("BLOCKBUSTER"),
    NORMAL("NORMAL"),
    THREED("3D");

    private String tag;

    MovieTag(String tag){
        this.tag = tag;
    }

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
