#include<iostream>
#include<cmath>
using namespace std;

class sec{
double x1;
double x_minus;
double x_plus;
double error;
int iteration;


public:
sec(){
this->error=1;
this->iteration=0;
}

void getdata(){
cout<<"Enter the number that gives positive in the function :";
cin>>x1;
cout<<endl<<"Enter the number that gives negative in the function :";
cin>>x_minus;
cout<<endl;
}

double calc_error(double a,double b){
return fabs(a-b)/a;

}

double findpower(double k,double l){
if(l==0){
return 1;
}
else if(l==1){
return k;
}
else{
return k*findpower(k,l-1);
}
}

double func(double num){
double x=sin(num)+findpower(num,2)+5*num-9;
return x;
}

void getanswer(){
        do {
          ++iteration;
            x_plus = (x1 - (((x1 - x_minus) * func(x1)) / (func(x1) - func(x_minus))));
            x_minus = x1;
            x1 = x_plus;
            error = calc_error(x_plus, x_minus);
        } while (error >= 0.005);
        cout<<"The total no of iterations is : "<<iteration<<endl;

        cout<<"The required root of the function is : "<<x1<<endl;
}

};

int main(){
sec b;
b.getdata();
b.getanswer();
return 0;

}