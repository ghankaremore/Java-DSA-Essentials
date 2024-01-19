public class Circularqueue {
    protected int[] data;
    private static final int default_size =5;
    protected int size =0;
    protected int front =0;
    protected int  rear =0;
    public Circularqueue(int size){
        data = new int[size];
    }
    public Circularqueue(){
        this(default_size);
    }
    public boolean isFull(){
        if(size==data.length){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    public void insert(int element){
        if(isFull()){
        System.out.println("The queue is full !");
        return;
        }
        data[rear] = element;
        rear = (rear+1) % data.length;
        size++;
    }
    public int remove(){
        if(isEmpty()){
            System.out.println("The queue is empty !");
            return -1;
        }
        int removed = data[front];
        front = (front +1) %data.length;
        size--;
        return removed;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("The queue is empty !");
            return;
        }

        int i = front;
        do{
            System.out.print(data[i]+"->");
           i++;
           i = i%data.length;

        }while(i!=rear);
        System.out.println("END");
    }
}
