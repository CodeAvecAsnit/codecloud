package StatePattern;

public class Pen implements Tool{


    @Override
    public void mouseDown() {
        System.out.println("Pen Tool");
    }

    @Override
    public void mouseUp() {
        System.out.println("Draw a line with Pen");

    }
}
