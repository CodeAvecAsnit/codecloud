package Iterator;

public class ArrayIterator<T> implements Iterator<T>{

    private BrowseHistory<T> browseHistory;
    private int index=0;

    public ArrayIterator(BrowseHistory<T> browserHistory){
        this.browseHistory = browserHistory;
    }

    @Override
    public boolean hasNext() {
        return index<browseHistory.size;
    }

    @Override
    public T next() {
        return browseHistory.getUrls().getFirst();
    }
}
