package Remove;


public class Tyres {
    private String name;
    private int diameter;
    private String material;

    public Tyres(){
    }

    public Tyres(String name, int diameter, String material) {
        this.name = name;
        this.diameter = diameter;
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Tyres{" +
                "name='" + name + '\'' +
                ", diameter=" + diameter +
                ", material='" + material + '\'' +
                '}';
    }
}
