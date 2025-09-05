package MementoPattern;

public class MementoRunner {
    public static void main(String[] args) {
        var editor = new Editor();
        var undoHistory = new History();

        editor.setContent("Hello");
        undoHistory.push(editor.createState());

        editor.setContent("World");
        undoHistory.push(editor.createState());

        editor.setContent("This");
        undoHistory.push(editor.createState());

        System.out.println(editor.getContent());

        editor.restore(undoHistory.popFromUndo());
        System.out.println(editor.getContent());

        editor.restore(undoHistory.popFromUndo());
        System.out.println(editor.getContent());

        editor.restore(undoHistory.popFromRedo());
        System.out.println(editor.getContent());

        editor.restore(undoHistory.popFromRedo());
        System.out.println(editor.getContent());
    }
}
