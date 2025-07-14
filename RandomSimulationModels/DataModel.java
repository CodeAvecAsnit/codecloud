package Jv.lng.RandomSimulation;

import java.util.ArrayList;
import java.util.List;

public class DataModel<T extends Number> {

    private T worstCase;
    private T bestCase;
    private T averageCase;
    private List<Float> cases;

    public DataModel() {
        this.cases = new ArrayList<>();
    }

    public DataModel(T worstCase, T bestCase, T averageCase) {
        this.worstCase = worstCase;
        this.bestCase = bestCase;
        this.averageCase = averageCase;
        this.cases = new ArrayList<>();
    }

    public T getWorstCase() {
        return worstCase;
    }

    public void setWorstCase(T worstCase) {
        this.worstCase = worstCase;
    }

    public T getBestCase() {
        return bestCase;
    }

    public void setBestCase(T bestCase) {
        this.bestCase = bestCase;
    }

    public T getAverageCase() {
        return averageCase;
    }

    public void setAverageCase(T averageCase) {
        this.averageCase = averageCase;
    }

    public List<Float> getCases() {
        return cases;
    }

    public void setDataModelZero(){
        cases.clear();
        cases.add(worstCase.floatValue());
        cases.add(bestCase.floatValue());
    }

    public void setDataModelOne() {
        cases.clear();
        cases.add(worstCase.floatValue());
        cases.add(averageCase.floatValue());
        cases.add(bestCase.floatValue());
    }

    public void setDataModelTwo() {
        cases.clear();
        cases.add(worstCase.floatValue());
        cases.add(averageCase.floatValue());
        cases.add((averageCase.floatValue() * 2 + bestCase.floatValue() + worstCase.floatValue()) / 4);
        cases.add(bestCase.floatValue());
    }

    public void setDataModelThree() {
        cases.clear();
        cases.add(worstCase.floatValue());
        cases.add((worstCase.floatValue() * 2 + bestCase.floatValue() + averageCase.floatValue()) / 4);
        cases.add(averageCase.floatValue());
        cases.add((averageCase.floatValue() * 2 + bestCase.floatValue() + worstCase.floatValue()) / 4);
        cases.add((bestCase.floatValue() * 2 + worstCase.floatValue() + averageCase.floatValue()) / 4);
        cases.add(bestCase.floatValue());
    }

    public void setDataModelFour() {
        cases.clear();
        cases.add(worstCase.floatValue());
        cases.add((worstCase.floatValue() * 2 + bestCase.floatValue() + averageCase.floatValue()) / 4);
        cases.add((averageCase.floatValue() * 4 + worstCase.floatValue() * 3 + bestCase.floatValue()) / 8);
        cases.add(averageCase.floatValue());
        cases.add((averageCase.floatValue() * 2 + bestCase.floatValue() + worstCase.floatValue()) / 4);
        cases.add((averageCase.floatValue() * 4 + bestCase.floatValue() * 3 + worstCase.floatValue()) / 8);
        cases.add((bestCase.floatValue() * 2 + worstCase.floatValue() + averageCase.floatValue()) / 4);
        cases.add(bestCase.floatValue());
    }

}
