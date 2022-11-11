package model.classes;

import java.io.Serializable;

public class MovieGoer implements Serializable, User {
    private String username;
    private String name;
    private int mobile;
    private int age;
    private String email;

    public MovieGoer(String username, String name, int mobile, int age, String email) {
        this.username = username;
        this.name = name;
        this.mobile = mobile;
        this.age = age;
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getUsername() { return this.username; }
}
