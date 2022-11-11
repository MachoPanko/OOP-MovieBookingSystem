package model.classes;

import java.io.Serializable;

public class Staff implements Serializable {
    private final String username;
    private final String password;

    public Staff(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() {
        return password;
    }

    public boolean equals(Staff staff){
        return(this.username.equals(staff.getUsername()) && this.password.equals(staff.getPassword()));
    }
}
