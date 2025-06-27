package com.org.orm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Shipper{

    @Id
    private Integer id;
    private String ShipperName;
    private String Address;

    public Shipper(){
    }

    public Shipper(Integer id, String ShipperName, String ShipperEmailAddress){
        this.id = id;
        this.ShipperName = ShipperName;
        this.Address = ShipperEmailAddress;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShipperName() {
        return ShipperName;
    }

    public void setShipperName(String shipperName) {
        ShipperName = shipperName;
    }

    public String getShipperEmailAddress() {
        return Address;
    }

    public void setShipperEmailAddress(String shipperEmailAddress) {
        Address = shipperEmailAddress;
    }

    @Override
    public String toString() {
        return "Shipper{" +
                "id=" + id +
                ", ShipperName='" + ShipperName + '\'' +
                ", ShipperEmailAddress='" + Address + '\'' +
                '}';
    }
}
