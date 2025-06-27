package Remove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    @Value("BMW")
    private String model;
    @Value("Red")
    private String color;
    @Value("2004")
    private String year;
    @Value(("500000"))
    private int cost;

    @Autowired
    public Tyres tyres;




    public Vehicle(){
    }

    public Vehicle(Tyres tyres){
        this.tyres = tyres;
    }

    public Vehicle(String model, String color, String year, int cost) {
        this.model = model;
        this.color = color;
        this.year = year;
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Tyres getTyres() {
        return tyres;
    }

    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year='" + year + '\'' +
                ", cost=" + cost +
                '}';
    }
}
