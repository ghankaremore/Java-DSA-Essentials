public class Doublylist {
    private int size;
    private Node head;
    private Node tail;
    public Doublylist(){
    this.size  =0;

    }
    public void insertfirst(int data){
        Node node = new Node(data);
         node.next = head;
         if(head!=null) {
             head.prev = node;
         }

        head = node;
        if(head.next==null ){
            tail = head;
        }
        size++;

    }
    public void insertLast(int data){
        if(head==null){
            insertfirst(data);
            return;
        }
       Node node = new Node(data);
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;

    }
    public void insertatindex(int index, int data){
        if(index==0){
            insertfirst(data);
            return;
        }
        if(index==size){
            insertLast(data);
            return;
        }
        Node temp;
        temp = head;
        Node node = new Node(data);
        for(int i=1;i<index;i++){
            temp = temp.next;
        }
        node.next = temp.next;
        node.next.prev = node;
        temp.next= node;
        node.prev = temp;
        size++;
    }
  public int deletefirst(){
        if(head==null){
            System.out.println("The list is empty");
            return -1;
        }
        int data = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return data;

  }
  public int deletelast(){
      if(head==null){
          System.out.println("The list is empty");
          return -1;
      }
      if(head==tail){
         return deletefirst();

      }
      Node temp;
      int data = tail.data;
      temp = tail.prev;
      temp.next= null;
      tail = temp;
      size--;
      return data;

  }

  public int deleteatindex(int index){
        if(index==0){
            return deletefirst();
        }
        if(index==size){
            return deletelast();
        }
        Node temp;
        temp = head;
        for(int i=1;i<index;i++){
            temp = temp.next;
        }
        int data = temp.data;
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;
        return data;

  }

    public void display(){
        Node temp;
        temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("end");

    }
    public void displayrev(){
        Node temp;
        temp = tail;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.prev;
        }
        System.out.println("end");
    }
    public class Node{
       private  int data;
       private Node next;
       private Node prev;
       public Node(){

       }
       public Node(int data){
           this.data = data;
       }

    }
}
