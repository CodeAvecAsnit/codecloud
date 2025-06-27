package com.org.orm.Dao;

import com.org.orm.entities.Shipper;
import org.springframework.stereotype.Service;

@Service
public class ShipperService {

    private ShipperDao shipperDao;

    public ShipperDao getShipperDao() {
        return shipperDao;
    }

    public void setShipperDao(ShipperDao shipperDao) {
        this.shipperDao = shipperDao;
    }

    public void show(Shipper shipper){
        shipperDao.Print(shipper);
    }

    public void Save(Shipper shipper){
        shipperDao.Save(shipper);
    }

    public void Update(Shipper shipper){
        shipperDao.Update(shipper);
    }

    public Shipper find(int id){
       return shipperDao.Find(id);
    }

    public void remove(Shipper shipper){
     shipperDao.Delete(shipper);
    }

    public void DeleteId(int id){
        shipperDao.deleteById(id);
    }
}
