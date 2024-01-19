public class Linkedlist {
    private Node head=null;
    private Node tail=null;
    private int size;
    public Linkedlist(){
        this.size =0;
    }
    public void insertfirst(int val){
        Node newNode = new Node(val);
        newNode.next= head;
        head = newNode;
        if(tail==null){
           tail = head;
        }
        size++;
    }
    public void insertlast(int val){
        if(head==null){
            insertfirst(val);
            return;
        }

        Node node = new Node(val);
        node.next = null;
        tail.next = node;
        tail = node;
        size++;

    }
    public int deletefirst(){
        int val = head.data;
        head = head.next;
        if(head==null){
            tail =null;
        }
        size--;
        return val;

    }
    public int deletelast(){
        if(size==1){
           return  deletefirst();

        }
        if(size<1){
            System.out.println("The list is empty");
            return 0;
        }
        int val = tail.data;
        Node temp = get(size-1);
        temp.next = null;
        tail = temp;
        return val;

    }
    public void insertatindex(int index, int val){
        if(index==0){
            insertfirst(val);
            return;
        }
        if(index == size){
            insertlast(val);
            return;
        }
        Node node = new Node(val);
        Node temp = get(index);
        node.next = temp.next;
        temp.next = node;

    }
    public int deleteatindex(int index){
        if(index==0){
           return deletefirst();

        }
        if(index == size){
            return deletelast();
        }
        Node temp = get(index);
        int value = temp.next.data;
        temp.next = temp.next.next;
        return value;

    }

    public Node get(int index){
        Node node = new Node();
        node = head;
        for(int i=1;i<index;i++){
            node = node.next;


        }
       return node;
    }

    public void bubblesort(){
        Bubblesort(size-1,0);

    }
    public void Bubblesort(int row, int col){
        if(row==0){
            return;
        }
        if(row>col){
            Node first = get(col);
            Node second = get(col+1);
            if(first.data>second.data){
                if(first==head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }else if(second == tail){
                    Node prev = get(col-1);


                    first.next = second.next;
                    second.next = first;
                    prev.next = second;
                    tail = first;
                }else{
                    Node prev = get(col-1);
                    first.next = second.next;
                    second.next = first;
                    prev.next = second;

                }
            }
             Bubblesort(row,col+1);


        }else{
            Bubblesort(row-1,0);
        }
    }
    public int find(int val){

        Node temp = head;

        while(temp!=null) {
            if (temp.data == val) {
                return temp.data;

            }
            temp = temp.next;

        }
        return -1;
    }
    public void insertrecur(int data, int index){
        head = insertrecur(data,index,head);
    }
   private Node insertrecur(int data, int index,Node node){
     if(index==0){
         Node temp = new Node(data,node);
         size++;
         return temp;
     }
     node.next = insertrecur(data,index--,node.next);
     return node;

    }
    public void display( Node head){
        Node temp = new Node();
        temp = head;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("END");


    }

    //Remove duplicates
    public Node removeduplicates(){
        Node temp = head;

        while(temp!=null){
            Node nextnode = temp.next;
            while(nextnode!=null && temp.data==nextnode.data){
                nextnode=nextnode.next;
            }
            temp.next= nextnode;
            temp = nextnode;

        }
        return head;
    }
    //Reversal of linked lists
    public void reverse(){
        Node first = head;
        Node second = head.next;
        while(second!=null){
            first.next = second.next;
            second.next = head;
            head = second;

            second = first.next;
        }
    }

    //Reverse of linked list using recursive approach
public void reverseRecur(){
        Node temp = head;
        reverseecur(temp);
}
    public void reverseecur(Node temp){
        if(temp==tail){
            head = tail;
            return;
        }
        reverseecur(temp.next);
        tail.next = temp;
        tail = temp;
        temp.next=null;
    }
    //Merge two sorted lists
    public void mergetwosortedlist(Linkedlist list1,Linkedlist list2){
        Node temp1 = list1.head;
        Node  temp2 = list2.head;
       // Linkedlist L = new Linkedlist();

        while(temp1!=null && temp2!=null){
            if(temp1.data<temp2.data){
                insertlast(temp1.data);
                temp1 = temp1.next;
            }else{
                insertlast(temp2.data);
                temp2 = temp2.next;
            }
        }
        while(temp1!=null){
            insertlast(temp1.data);
            temp1 = temp1.next;
        }
        while(temp2!=null){
            insertlast(temp2.data);
            temp2 = temp2.next;
        }

    }
    //Pallindrome
    public boolean isPalindrome() {
        if(head==null){
            return true;
        }
        if(head.next==null){
            return true;
        }
        Node temp = head;
        int length = 0;
        while(temp!=null){
            temp = temp.next;
            length ++;
        }
        // for(int i=0;i<length/2;i++){
        //     ListNode temp1 = head;
        //     ListNode temp2 = head;
        //     for(int j=0;j<i;j++){
        //         temp1 = temp1.next;

        //     }
        //     for(int k=0;k<length-i-1;k++){
        //         temp2 = temp2.next;
        //     }
        //     if(temp1.val!=temp2.val){
        //         return false;
        //     }
        // }
        // return true;
        int mid =0;
        if(length%2!=0){
            mid = length/2+1;
        }else{
            mid = length/2;
        }
        Node first = head;
        for(int i=0;i<mid;i++){
            first = first.next;
        }
        Node second = first.next;
        Node temphead = first;
        Node node = head;
        for(int i=0;i<mid-1;i++){
            node = node.next;
        }
        node.next = null;
        while(second!=null){
            first.next = second.next;
            second.next = temphead;
            temphead = second;
            second = first.next;
        }
        Node temp1= head;
        Node temp2 = temphead;
        this.display(head);
        this.display(temphead);
        while(temp2!=null){
            if(temp1!=temp2){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;


    }
    private class Node{
        int data;
        Node next;


        public Node(int value){
            this.data = value;


        }
        public Node(){

        }
        public Node(int value, Node next){
            this.data = value;
            this.next = next;
        }
    }
}
