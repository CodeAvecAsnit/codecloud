
class ListNode<T>{
  public T val;
  public ListNode<T> next;

  public ListNode(){}
  
  public ListNode(T data){
    this.val = data;
    this.next = null;
  }
}


public class LinkedList<T>{

  private ListNode<T> head;
  public int count;

  public LinkedList(){
    this.head = null;
    this.count = 0;
  }

  public void InsertTop(T value){
    ListNode<T> Node = new ListNode<T>(value);
    if(head != null){
      Node.next = head;
    }
    head = Node;
    ++count;
  }

  public void InsertEnd(T value){
    ListNode<T> Node = new ListNode<T>(value);
    if (head == null){
      head = Node;
      return;
    }
  ListNode<T> temp = head;
  while(temp.next!=null){
    temp = temp.next;
  }
  temp.next = Node;
  ++count;
  }

  public void Insert(T value,int index){
    index = index%count;

  }


  public T deleteTop() throws Exception{
    if(head==null){
      throw new NullPointerException();
    }
    ListNode<T> temp = head;
    head = head.next;
    --count;
    return temp.val;
  }

  public T deleteEnd() throws Exception{
    if(head == null){
      throw new NullPointerException();
    }
    if(head.next==null){
      T x = head.val;
      head=head.next;
      return x;
    }
    ListNode<T> temp = head;
    while(temp.next.next!=null){
      temp=temp.next;
    }
    T retval = temp.next.val;
    temp.next=null;
    --count;
    return retval;
  }

  public Boolean Search(T object){
    ListNode<T> temp = head;
    while(temp!=null){
      if(temp.val==object){
        return true;
      }
      temp = temp.next;
    }
    return false;
  }
}

