#include<iostream>
#include<cmath>
using namespace std;

class bisect{
double neg;
double pos;
double mid;
double error;
double temp;
int iteration;

public:
bisect(){
this->error=1;
this->temp=0;
this->iteration=0;
}

void getdata(){
cout<<"Enter the number that gives positive in the function :";
cin>>pos;
cout<<endl<<"Enter the number that gives negative in the function :";
cin>>neg;
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

double function(double num){
double x=sin(num)+findpower(num,2)+5*num-9;
return x;
}

void getanswer(){

do{
++iteration;
mid=(neg+pos)/2;
if(function(mid)>=0){
temp = pos;
pos = mid;
}
else{
temp = neg;
neg = mid;
}
error= calc_error(mid,temp);
}while (error>=0.005);

cout<<"The no of iterations is : "<<iteration<<endl;

cout<<"The root of the function is : "<<mid<<endl;

}

};

int main(){
bisect b;
b.getdata();
b.getanswer();
return 0;

}