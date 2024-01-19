public class Circularlist {
    private Node head;
    private Node tail;
    private int size;
    public Circularlist(){
        this.size =0;
    }
    public void insertfirst(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
        if(head.next==null){
          tail = head;
        }

        tail.next = head;
        size++;
    }
    public void insertlast(int data){
        if(head==null){
            insertfirst(data);
            return;
        }
        Node node = new Node(data);
        tail.next = node;
        node.next = head;
        tail = node;
        size++;

    }
    public void insertatindex(int data, int index){
        if(index==0){
            insertfirst(data);
            return;
        }
        if(index == size){
            insertlast(data);
            return;
        }
        Node temp;
        temp = head;
        Node node = new Node(data);
        for(int i=1;i<index;i++){
            temp = temp.next;
        }
        node.next = temp.next;

        temp.next= node;

        size++;

    }
    public int delete(int val){
        Node node = head;
        if(head==null){
            return -1;
        }
        if(node.data ==val){
            int data = node.data;
            head=head.next;
            tail.next = head;
            return data;
        }
        Node succ = node.next;
        int data = succ.data;
        do {
           node= node.next;
           succ = succ.next;

            if(succ.data==val){
                node.next = succ.next;
                break;
            }
        }while(node!=head);
        return data;

    }

    public void display(){
       Node temp;
        temp = head;
        do{
            System.out.print(temp.data+"->");
            temp = temp.next;
        }while(temp!=head);
        System.out.println("end");

    }
    private class Node{
        int data;
        Node next;


        public Node(int value){
            this.data = value;


        }
        public Node(){

        }
    }
}
