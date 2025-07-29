#include <iostream>
#include <cstring> 
using namespace std;

class node {
  public:
    bool accept;
    node *anext;
    node *bnext;

    node(){
    }

    node(bool k, node *an, node *bn) {
      this->accept = k;
      this->anext = an;
      this->bnext = bn;
    }

    node* getNextNode(char x) {
      if (x == 'a') return anext;
      else return bnext;
    }
};

int main() {
  cout << "Enter the String : ";
  char data[20];
  cin >> data;
  int len = strlen(data);

  node q1;
  node q0(false,&q1,&q0);

  q1.accept=true;
  q1.anext=&q0;
  q1.bnext=&q1;

  node *current = &q0;
  for (int i = 0; i < len; ++i) {
    cout<<data[i]<<endl;
    current = current->getNextNode(data[i]);
  }

  if (current->accept) 
    cout << data << " is accepted." << endl;
  else 
    cout << data << " is not accepted." << endl;

  return 0;
}