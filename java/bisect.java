import java.util.Scanner;

public class bisector {
    public double pos_number;
    public double neg_number;
    public double bisect;
    public double error;
    double temp;

    bisector() {
        this.error=1;

    }


    public void get_data() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number that gives positive ");
        pos_number = in.nextDouble();

        System.out.println("Enter a number that gives negative");
        neg_number = in.nextDouble();

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
     /*   do{
            if (pos_number < -1000 || pos_number > 1000) {
                System.out.println("Error: Unable to find valid range for pos_number");
                break;
            }

            if(func(pos_number)>func(pos_number+1)){
                pos_number--;
            }
            else{
                pos_number++;
            }

        }while (func(pos_number)>=0);

       do {
           if (neg_number < -1000 || neg_number > 1000) {
               System.out.println("Error: Unable to find valid range for pos_number");
               break;
           }

            if (func(neg_number) < func(neg_number + 1)) {
                neg_number--;
            } else {
                neg_number++;
            }
        } while(func(neg_number)>=0);
*/
            do{
                bisect=(pos_number+neg_number)/2;
                if(func(bisect)>=0){
                    temp=pos_number;
                    pos_number=bisect;
                }
                else{
                   temp=neg_number;
                    neg_number=bisect;
                }
                error=calc_error(bisect,temp);

        } while (error >= 0.005);
        System.out.println("The required number is :"+bisect);


    }
}
public class Main
{
    public static void main(String[] args){
        bisector b= new bisector();
        b.get_data();
        b.get_answer();
    }
}