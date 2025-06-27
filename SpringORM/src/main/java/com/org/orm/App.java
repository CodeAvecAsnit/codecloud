package com.org.orm;


import com.org.orm.Dao.ShipperService;
import com.org.orm.entities.Shipper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App
{
    public static void main( String[] args ){


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        ShipperService shipperService = (ShipperService) applicationContext.getBean("shipperService");
        Shipper shipper = new Shipper();
        shipper.setId(6);
        shipper.setShipperName("Mr Beast");
        shipper.setShipperEmailAddress("North Carolina");
        shipperService.DeleteId(6);
    }
}
