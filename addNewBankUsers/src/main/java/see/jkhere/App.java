package see.jkhere;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Products iphone = new Products();
        iphone.setProduct_name("iPhone");
        iphone.setProduct_category("Mobile");

        Orders orders1 = new Orders();
        orders1.setUnit(10);
        orders1.setProducts(iphone);

        Orders orders2 = new Orders();
        orders2.setUnit(4);
        orders2.setProducts(iphone);

        Orders orders3 = new Orders();
        orders3.setUnit(15);
        orders3.setProducts(iphone);

        List<Orders> orderList = new ArrayList<>();
        orderList.add(orders1);
        orderList.add(orders2);
        orderList.add(orders3);

        iphone.setOrdersList(orderList);

        session.save(iphone);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
