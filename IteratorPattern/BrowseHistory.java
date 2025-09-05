package Iterator;


import java.util.ArrayList;
import java.util.List;

public class BrowseHistory<T>{

    private List<T> urls;
    public int size;



    public BrowseHistory() {
        urls = new ArrayList<>();
    }

    public Iterator<T> createIterator(){
        return new ArrayIterator<T>(this);
    }

    public void addUrl(T url){
        urls.add(url);
        ++size;
    }
    public T removeURL(){
        return urls.remove(--size);
    }

    public List<T> getUrls() {
        return urls;
    }

    public void setUrls(List<T> urls) {
        this.urls = urls;
    }
}
