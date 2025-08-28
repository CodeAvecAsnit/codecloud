import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private int n;
    private List<Observer> observerList;

    public DataSource(){
        observerList = new ArrayList<>();
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
        this.notifyObservers();
    }

    public List<Observer> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<Observer> observerList) {
        this.observerList = observerList;
    }

    public void addObserver(Observer observer){
        observerList.add(observer);
    }

    public void removeObserver(Observer observer){
        observerList.remove(observer);
    }

    private void notifyObservers(){
        for(Observer obs :observerList){
            obs.update();
        }
    }
}
