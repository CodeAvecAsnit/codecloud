#include<iostream>
#include<cstring>
#include<stack>
using namespace std;

class Pda{

  public:
  stack<char> st;

  void transition(char a){
    if(a=='0'){
    if(!st.empty()&&st.top()=='1'){
      st.pop();
    }else st.push('0');
  }
  else{
    if(!st.empty()&&st.top()=='0'){
      st.pop();
    }else st.push('1');
  }
  }

  bool isAccepting(){
    return st.empty();
  }
};

int main(){
  cout<<"Enter the String : ";
  char str[50];
  cin>>str;
  int len = strlen(str);

  Pda pad;

  for(int i = 0;i<len;++i ){
    pad.transition(str[i]);
  }

  if(pad.isAccepting()){
    cout<<str<<" has been accepted.";
  }else{
    cout<<str<<" has been rejected";
  }
  return 0;

}