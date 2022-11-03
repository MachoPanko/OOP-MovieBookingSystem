package model;

public class MovieGoer {
    private String CustomerId;
    private String name;
    private String mobile;
    private String age;
    private String email;

    public MovieGoer(String customerId, String name, String mobile, String age, String email) {
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
