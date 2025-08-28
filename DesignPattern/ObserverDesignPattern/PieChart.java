public class PieChart implements Observer{

    private DataSource dataSource;

    public PieChart() {
    }

    public PieChart(DataSource dataSource) {
        this.dataSource = dataSource;
        dataSource.addObserver(this);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void update() {
        System.out.println("Updating the pie chart : "+dataSource.getN());
    }
}
