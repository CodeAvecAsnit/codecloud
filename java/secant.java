public class iit {
    public double x1;
    public double x_minus_1;

    public double x_plus_1;
    public double error;

    iit() {
        this.error = 1;

    }


    public void get_data() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number that gives positive ");
        x1 = in.nextDouble();

        System.out.println("Enter a number that gives negative");
        x_minus_1 = in.nextDouble();

        in.close();

    }

    public double calc_error(double newer, double old) {
        return Math.abs((newer - old) / newer);
    }


    public double find_power(double a, double b) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;
        } else {
            return a * find_power(a, b - 1);
        }

    }

    public double func(double num) {
        double x;
        x = Math.sin(num) + find_power(num, 2) + 5 * num - 9;
        return x;

    }

    public void get_answer() {
        int iteration=0;
        do {
            ++iteration;


            x_plus_1 = (x1 - (((x1 - x_minus_1) * func(x1)) / (func(x1) - func(x_minus_1))));
            x_minus_1 = x1;
            x1 = x_plus_1;
            error = calc_error(x_plus_1, x_minus_1);
        } while (error >= 0.005);
        System.out.println("The no of iterations is :"+iteration);

        System.out.println("The required answer is : " + x1);
    }
}
public class Main{
    public static void main(String[] args){
        iit in= new iit();
        in.get_data();
        in.get_answer();
    }
}