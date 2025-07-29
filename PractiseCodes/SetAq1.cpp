#include<iostream>
#include<cstring>
using namespace std;

int main(){
  char str[50];
  cout<<"Enter the String : ";
  cin>>str;
  int len = strlen(str);
  int count=0;
  for(int i = 0 ; i < len;++i){
    if(str[i]=='1')
    { 
      ++count;
  }
  }
  if(count%2==1){
    cout<<str<<" is accepted.";
  }else cout<<str<<"is not accepted";
}