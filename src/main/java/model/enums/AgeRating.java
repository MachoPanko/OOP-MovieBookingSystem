package model.enums;

public enum AgeRating {
    G("G"),
    PG("PG"),
    PG13("PG13"),
    R("R"),
    NC17("NC17");

    private String rating;

    AgeRating(String rating){
        this.rating = rating;
    }

    public static AgeRating getRating(String choice) {
        choice = choice.toUpperCase();
        return switch (choice) {
            case "G" -> G;
            case "PG" -> PG;
            case "PG13" -> PG13;
            case "NC17" -> NC17;
            default -> null;
        };
    }
}
