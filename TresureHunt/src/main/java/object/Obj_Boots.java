package object;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Obj_Boots extends SuperObject {
    public Obj_Boots() {
        name = "Boots";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/boots.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
