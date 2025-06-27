package Remove;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaConfig {

    @Bean
    @Scope("prototype")
    public Vehicle vehicle(){
        return new Vehicle(this.tyres());
    }

    @Bean
    @Scope("prototype")
    public StringBuild stringBuild(){
        return new StringBuild();
    }

    @Bean
    public Tyres tyres(){
        return new Tyres("MILF",25,"Plastic");
    }

}
