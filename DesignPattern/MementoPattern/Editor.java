package MementoPattern;


public class Editor {
    private String content;

    public Editor(){}
    public Editor(String content) {
        this.content = content;
    }

    public EditorState createState(){
        return new EditorState(this.content);
    }

    public void restore(EditorState editorState){
        content=editorState.content();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
