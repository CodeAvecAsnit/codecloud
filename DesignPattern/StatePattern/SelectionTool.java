package StatePattern;

public class SelectionTool implements Tool{

    @Override
    public void mouseDown() {
        System.out.println("Selection Tool Icom");
    }

    @Override
    public void mouseUp() {
        System.out.println("Draw as dashed rectangle");

    }
}
