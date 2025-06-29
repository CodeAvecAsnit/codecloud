package com.spring.autowired;

public class Address {
    private String country;
    private String city;

    public Address(){
    }

    public Address(String country, String city) {
        System.out.println("yo you are in the constructor");
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

