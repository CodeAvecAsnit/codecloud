#include<iostream>
using namespace std;
#define max 10


class queue{
  int data[max];
  int rear;
  int front;

public:
  queue(){
    this->rear=-1;
    this->front=0;
  }
  
  void make_empty(){
    rear=-1;
    front=0;
  }

  int checkempty(){
    if (front>rear)
    return 1;
    else return 0;
    }

    int checkfull(){
      if (rear==(max-1))
      return 1;
      else return 0;
    }

    void enterdata(){
      if(checkfull()){
        cout<<"queue overflow"<<endl;
      }else{
        ++rear;
        cin>>data[rear];
      }
    }

    void deletedata(){
      if(checkempty())
      cout<<"queue underflow"<<endl;
      else ++front;
    }

    void traverse(){
      if(checkempty()){
      cout<<"no data to show "<<endl;
      }
      else{
      cout<<"The data required are : ";
      for(int i=front;i<=rear;++i){
        cout<<data[i]<<" ";
      }
      cout<<endl;
    }
    }
  };

  int main(){
	int n=0;
	queue q;
  cout<<"Menu"<<endl;
	cout<<"Press 1 to make the queue empty"<<endl;
	cout<<"Press 2 to checkthe queue is empty or not"<<endl;
	cout<<"Press 3 to check the queue is full or not"<<endl;
	cout<<"Press 4 to insert the data into the queue"<<endl;
	cout<<"Press 5 to delete the data from the queue"<<endl;
	cout<<"Press 6 to see the queue "<<endl;
	cout<<"Press any other key to exit"<<endl;

	do{
			cin>>n;
		switch(n){
			case 1:
      q.make_empty();
			
				break;
		case 2:
		if(q.checkempty()){
			cout<<"the given data is empty"<<endl;
	}
	else{
		cout<<"no"<<endl;
	}	
	break;
	
	case 3:
				if(q.checkfull()){
			cout<<"the given data is full"<<endl;
	}
	else{
		cout<<"no"<<endl;
	}	
	break;
	
	case 4:
		q.enterdata();
		break;
		
		case 5:
;
			q.deletedata();
			break;
			
			case 6:
				q.traverse();
				break;
				default:
					n=7;
			
		
}
}while(n!=7);
return 0;
}
