package com.codeavecasnit.passportmapper.passportcitizen.Entities;

import jakarta.persistence.*;


import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Citizen {
    @Id
    private long citizenshipNo;
    private String firstName;
    private String lastName;
    private Date DOB;
    private String address;
    private String nationality;
    @OneToOne(mappedBy = "citizen")
    private Passport passport;

    public Citizen() {}

    public Citizen(long citizenshipNo, String firstName, String lastName, String DOB, String address, String nationality,Passport passport) {
        this.citizenshipNo = citizenshipNo;
        this.firstName = firstName;
        this.lastName = lastName;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.DOB = dateFormat.parse(DOB);
        }catch (Exception e){
            this.DOB = null;
        }
        this.address = address;
        this.nationality = nationality;
        this.passport = passport;
    }

    public long getcitizenshipNo() {
        return citizenshipNo;
    }

    public void setCitizenshipNo(long citizenshipNo) {
        this.citizenshipNo = citizenshipNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
