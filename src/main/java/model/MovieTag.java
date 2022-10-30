package model;

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
        if(choice.equals("BLOCKBUSTER")){
            return BLOCKBUSTER;
        }
        else if(choice.equals("NORMAL")){
            return NORMAL;
        }
        else if (choice.equals("3D")){
            return THREED;
        }
        else return null;
    }
}
