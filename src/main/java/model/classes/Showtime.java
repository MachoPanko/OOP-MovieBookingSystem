package model.classes;

import java.io.Serializable;

public class Showtime implements Serializable {
    public final String[] TIME = {
            "0000",
            "0800",
            "0900",
            "1000",
            "1100",
            "1200",
            "1300",
            "1400",
            "1500",
            "1600",
            "1700",
            "1800",
            "1900",
            "2000",
            "2100",
            "2200",
            "2300",
    };

    public int size() {
        return this.TIME.length;
    }
}
