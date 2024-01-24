class newton_rapson{
    double new_num;
    double error;
    double old_num;

    newton_rapson(double x){
        this.old_num=x;
        this.error=1;
    }

    public double findpower(double a,double b){
        if(b==0){
            return 1;
        }
        else if(b==1){
            return a;
        }else{
            return a*findpower(a,b-1);
        }

    }
    public double func(double num){
        double x;
        x = Math.sin(num)+findpower(num,2)+5*num-9;
        return x;

    }
    public double derived_func(double num){
        double x;
        x = Math.cos(num)+(2*num)+5;
        return x;

    }
    public double calc_error(double newer,double old){
        double y=(newer-old)/newer;
        if(y<0) return -1*y;
        else return y;
    }
    public void find_answer(){
        double answer=0;
        do{
            new_num = old_num-(func(old_num)/derived_func(old_num));
            error=calc_error(new_num,old_num);
            if(error<0.005) {
                answer = new_num;
            }
            else old_num = new_num;
        }  while(error>=0.0005);
        System.out.printf("The required number is : %f%n",answer);
    }


    }
import java.util.Scanner;


public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number");
        int a = in.nextInt();
        double b =(double) a;
        newton_rapson n1=new newton_rapson(b);
        n1.find_answer();
        in.close();

    }

}