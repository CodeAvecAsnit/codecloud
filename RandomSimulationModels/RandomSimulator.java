package Jv.lng.RandomSimulation;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class RandomSimulator <T extends Number>{

    private final Random random;
    private List<T> numbers;
    private List<DataModel<T>> dataModels;
    private static final int DEFAULT_NO_OF_SIMULATIONS = 10000;


    public RandomSimulator(List<T> numbers){
        this.numbers = numbers;
        this.random = new Random();
    }


    public List<T> getNumbers() {
        return numbers;
    }


    public void setNumbers(List<T> numbers) {
        this.numbers = numbers;
    }


    public float Simulate(int NumberOfSimulations){
        BigDecimal decimal =  new BigDecimal(0);
        int len = numbers.size();
        System.out.println(len);
        for (int i = 0; i < NumberOfSimulations; i++) {
            decimal = decimal.add(BigDecimal.valueOf(numbers.get(random.nextInt(len)).floatValue()));
        }
        return (decimal.floatValue()/NumberOfSimulations);
    }


    public float Simulate() {
        return Simulate(DEFAULT_NO_OF_SIMULATIONS);
    }


    public float Simulate(DataModel<T> dataModel,int NoOfSimulations){
        this.numbers = (List<T>) dataModel.getCases();
        BigDecimal decimal =  new BigDecimal(0);
        int len = numbers.size();
        for (int i = 0; i < NoOfSimulations; i++) {
            decimal = decimal.add(BigDecimal.valueOf(numbers.get(random.nextInt(len)).floatValue()));
        }
        return (decimal.floatValue()/NoOfSimulations);
    }


    public float Simulate(DataModel<T> dataModel){
        return Simulate(dataModel,DEFAULT_NO_OF_SIMULATIONS);
    }


    public float Simulate(List<DataModel<T>> dataModels){
       return Simulate(dataModels,DEFAULT_NO_OF_SIMULATIONS);
    }


    public float Simulate(List<DataModel<T>> dataModels,int NumberOfSimulations){
        BigDecimal decimal = new BigDecimal(0);
        for(int i = 0 ; i < NumberOfSimulations;++i) {
            float sum = 0;
            for (DataModel<T> dataModel : dataModels) {
                List<T> temp = (List<T>) dataModel.getCases();
                sum+= (float)temp.get(random.nextInt(0, dataModel.getCases().size()));
            }
            decimal = decimal.add(BigDecimal.valueOf(sum / dataModels.size()));
        }
        return  (decimal.floatValue()/NumberOfSimulations);
    }


    public float Simulate(List<DataModel<T>> dataModels,DataModel<T> dataModel){
        return Simulate(dataModels,dataModel,DEFAULT_NO_OF_SIMULATIONS);
    }


    public float Simulate(List<DataModel<T>> dataModels,DataModel<T> dataModel,int NumberOfSimulations){
        BigDecimal decimal = new BigDecimal(0);
        this.numbers = (List<T>) dataModel.getCases();
        int len = numbers.size();
        for(int i = 0 ; i < NumberOfSimulations;++i) {
            float sum = 0;
            for (DataModel<T> dataModel1 : dataModels) {
                List<T> temp = (List<T>) dataModel1.getCases();
                sum+= (numbers.get(random.nextInt(len)).floatValue()) + (temp.get(random.nextInt(dataModel1.getCases().size()))).floatValue();
            }
            decimal = decimal.add(BigDecimal.valueOf(sum / dataModels.size()));
        }
        return (decimal.floatValue()/NumberOfSimulations);
    }


    public float Simulate(DataModel<T> dataModel, DataModel model, TreeMap<Float,Float> map,int NumberOfSimulations){
            BigDecimal decimal = new BigDecimal(0);
            this.numbers = (List<T>) dataModel.getCases();
            int len = numbers.size();
            for(int i = 0 ; i < NumberOfSimulations;++i) {
                float k = 0;
                for (DataModel<T> dataModel1 : dataModels) {
                    List<T> temp = (List<T>) dataModel1.getCases();
                    float sum = (numbers.get(random.nextInt(len)).floatValue()) + (temp.get(random.nextInt(dataModel1.getCases().size()))).floatValue();
                    k+= map.get(map.floorKey(sum));
                }
                decimal = decimal.add(BigDecimal.valueOf(k / dataModels.size()));
            }
            return (decimal.floatValue()/NumberOfSimulations);
        }


    public float Simulate(DataModel<T> dataModel, DataModel model, TreeMap<Float,Float> map){
        return Simulate(dataModel,model,map,DEFAULT_NO_OF_SIMULATIONS);
    }


    public float Simulate(List<DataModel<T>> primary,List<DataModel<T>> secondary,int NumberOfSimulations)throws Exception{
        BigDecimal decimal = new BigDecimal(0);
        int primarylen = primary.size();
        int secondarylen = secondary.size();
        if(primarylen != secondarylen){
            throw new Exception("Primary List of DataModel and Secondary List should be equal");
        }
        for(int i = 0 ; i < NumberOfSimulations;++i) {
            float sum = 0;
            for(int j = 0 ; j < primarylen;++j) {
                DataModel<T> primary1 = primary.get(j);
                DataModel<T> secondary1 = secondary.get(j);
                sum += primary1.getCases().get(random.nextInt(primary1.getCases().size()));
                sum += secondary1.getCases().get(random.nextInt(secondary1.getCases().size()));
            }
            decimal = decimal.add(BigDecimal.valueOf(sum / primarylen));
        }
        return (decimal.floatValue()/NumberOfSimulations);
    }


    public float Simulate(List<DataModel<T>> primary,List<DataModel<T>> secondary)throws Exception{
       return Simulate(primary,secondary,DEFAULT_NO_OF_SIMULATIONS);
    }

}




