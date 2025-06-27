package Remove;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component
public class StringBuild {
    @Value("#{T(java.lang.Math).sqrt(49)}")
    public double x;

    public StringBuild() {}

    public StringBuild(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }
}
