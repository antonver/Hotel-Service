package org.example.hotel__;

public class Client {
    private String first_name;
    private String last_name;
    private Integer age;
    private String email;

    public Client(String first_name, String last_name, Integer age, String email){
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
