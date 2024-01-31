#include<iostream>
#include<cmath>
using namespace std;

class newton{
public:
double newdata;
double old;
double error;

public:
newton(){
this->error=1;
this->old=5.0;
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

double function(double num){
double x=sin(num)+findpower(num,2)+5*num-9;
return x;
}

double derievefunc(double num){
double y = cos(num)+(2*num)+5;
return y;
}

void getanswer(){
double temp=0;
do{
newdata = old -(function(old)/derievefunc(old));
error= calc_error(newdata,old);
if(error<=0.005){
temp = newdata;
}
else{
old = newdata;
}
}while (error>=0.005);

cout<<"The root of the function is : "<<temp<<endl;

}

};

int main(){
newton b;
b.getanswer();
return 0;

}
