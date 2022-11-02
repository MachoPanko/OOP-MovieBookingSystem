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
        if(choice.equals("G")){
            return G;
        }
        else if(choice.equals("PG")){
            return PG;
        }
        else if (choice.equals("PG13")){
            return PG13;
        }
        else if(choice.equals("NC17")){
            return NC17;
        }
        else return null;
    }
}
