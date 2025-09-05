package StatePattern;

public class StateMain {
    public static void main(String[] args) {
        var canvas = new Canvas(new Pen());
        canvas.mouseDown();
        canvas.mouseUp();

        canvas.setTool(new SelectionTool());
        canvas.mouseDown();
        canvas.mouseUp();
    }
}
