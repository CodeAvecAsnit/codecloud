#include<iostream>
#include<cstring>
using namespace std;
#define max 10;

class datain{
  public :
  int count;
  int sount;
  char input[20];
  char scan[20];
  char opcode[20];
  
  datain(){
    this->count=-1;
    this->sount=-1;
  }

  void push(){
    ++count;
    scan[count]=opcode[sount];
    --sount;

  }

  void getinput(){
    cout<<"Enter the given operation below : ";
    cin>>input;
  }

  void getdifferentdata(){
    for(int i=0;i<strlen(input);++i){
      int scaner = (int)input[i];
      if(scaner>=97&&scaner<=122){
        ++count;
        scan[count]=input[i];
      }
      else{
        ++sount;
        opcode[sount]=input[i];
        if(opcode[sount]==')'){
          sount--;
          while(opcode[sount]!='('){
            push();
          }
          --sount;
  
        }
      }
    }
   while(sount!=-1){
      push();
      }
      
    
  }
  void seeopcode(){
    cout<<"The opcodes are :"<<endl;
    for(int i=0;i<=sount;++i){
      cout<<opcode[i]<<endl;
    }
  }
  void seescaned(){
    cout<<"The Scanned characters are :"<<endl;
    for(int i=0;i<=count;++i){
      cout<<scan[i];
    }
    cout<<endl;
  }

};

int main(){
  datain d1;
  d1.getinput();
  d1.getdifferentdata();
  d1.seescaned();
  return 0;

}