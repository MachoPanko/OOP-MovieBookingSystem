package model;

import java.io.Serializable;

public class Staff implements Serializable {
    private String username;
    private String password;

    public Staff(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(Staff staff){
        return(this.username.equals(staff.getUsername()) && this.password.equals(staff.getPassword()));
    }
}
