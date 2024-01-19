public class Queue {
    protected int[] arr;
    private int front =-1;
    private int rear = -1;
    private static final int default_size = 10;
    public Queue(){
        this(default_size);
    }
    public Queue(int size){
        arr = new int[size];
    }
    public void add(int data){
        rear++;
        arr[rear] = data;
    }
    public int remove(){
        if(rear==-1){
            System.out.println("The queue is empty!");
            return -1;
        }
        front++;
        int element = arr[front];
        return element;
    }
    public void display(){
        if(rear==-1){
            System.out.println("The queue is empty!");
            return ;
        }
        for(int i=0;i<=rear;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
