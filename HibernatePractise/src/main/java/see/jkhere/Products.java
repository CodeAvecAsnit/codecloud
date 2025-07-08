package see.jkhere;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Products{
    @Id
    public int product_id;
    public String product_name;
    public String product_category;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> ordersList = new ArrayList<>();

    public Products(List<Orders> ordersList, String product_category, String product_name, int product_id) {
        this.ordersList = ordersList;
        this.product_category = product_category;
        this.product_name = product_name;
        this.product_id = product_id;
    }

    public Products() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public void addOrder(Orders order) {
        ordersList.add(order);
        order.setProducts(this);
    }

    public void removeOrder(Orders order) {
        ordersList.remove(order);
        order.setProducts(null);
    }
}

