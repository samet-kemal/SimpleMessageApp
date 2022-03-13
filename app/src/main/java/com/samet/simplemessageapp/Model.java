package com.samet.simplemessageapp;

public class Model {

    private String Name;
    private String PhoneNumber;

    public void setName(String name) {
        Name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getName() {
        return Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public Model(String name, String phoneNumber) {
        Name = name;
        PhoneNumber = phoneNumber;
    }
}
