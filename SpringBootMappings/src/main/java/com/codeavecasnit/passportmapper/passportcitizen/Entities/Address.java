package com.codeavecasnit.passportmapper.passportcitizen.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address{
    @Id
    private Integer addressId;
    private String StreetName;
    private String District;
    private String Country;
    @OneToOne(mappedBy = "address")
    private Student student;

    public Address(){}

    public Address(Integer addressId, String streetName, String district, String country, Student student) {
        this.addressId = addressId;
        StreetName = streetName;
        District = district;
        Country = country;
        this.student = student;
    }

    public Address(Integer addressId, String streetName, String district, String country) {
        this.addressId = addressId;
        StreetName = streetName;
        District = district;
        Country = country;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String streetName) {
        StreetName = streetName;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
