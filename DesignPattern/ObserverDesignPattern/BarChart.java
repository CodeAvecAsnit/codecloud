public class BarChart implements Observer{


    private DataSource dataSource;

    public BarChart(DataSource dataSource) {
        this.dataSource = dataSource;
        dataSource.addObserver(this);
    }

    public BarChart() {
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void update() {
        System.out.println("Bar chart has been updated"+dataSource.getN());
    }
}
