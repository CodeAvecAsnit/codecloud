package MementoPattern;

import java.util.Stack;

public class History {

    private final Stack<EditorState> undo;
    private final Stack<EditorState> redo;

    public History(){
        this.undo = new Stack<>();
        this.redo = new Stack<>();
    }

    public void push(EditorState editorState){
        this.undo.push(editorState);
        this.redo.clear();
    }

    public EditorState popFromUndo(){
        this.redo.push(undo.peek());
        this.undo.pop();
        return undo.peek();
    }

    public EditorState popFromRedo(){
        undo.push(redo.peek());
        return this.redo.pop();
    }
}
