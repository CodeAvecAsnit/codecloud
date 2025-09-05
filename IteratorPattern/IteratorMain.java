package Iterator;

public class IteratorMain {
    public static void main(String[] args) {
        BrowseHistory<String> history = new BrowseHistory<String>();
        history.addUrl("google.com");
        history.addUrl("apple.com");
        history.addUrl("facebook.com");
        Iterator<String> iterator = history.createIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
