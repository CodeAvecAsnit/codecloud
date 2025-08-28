public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        BarChart observer = new BarChart(dataSource);
        PieChart pieChart = new PieChart(dataSource);
        dataSource.setN(5);
        dataSource.setN(10);
        dataSource.removeObserver(pieChart);
        dataSource.setN(90);
        }
}