package com.spring.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class emp {
    @Autowired
    @Qualifier("address0")
    private Address address;

    public emp(){
    }

    public emp(Address address) {
        System.out.println("Inside emp constructor");
        this.address = address;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        System.out.println("Setting address");
        this.address = address;
    }

    @Override
    public String toString() {
        return "emp{" +
                "address=" + address.toString() +
                '}';
    }
}
