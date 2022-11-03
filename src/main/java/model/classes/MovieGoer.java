package model.classes;

public class MovieGoer {
    private String CustomerId;
    private String name;
    private int mobile;
    private int age;
    private String email;

    public MovieGoer(String customerId, String name, int mobile, int age, String email) {
        CustomerId = customerId;
        this.name = name;
        this.mobile = mobile;
        this.age = age;
        this.email = email;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        this.CustomerId = customerId;
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
}
