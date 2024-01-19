public abstract class Stack {
    protected int[] arr;

    protected int rear = -1;

    private static final int Default_size = 10;
    public Stack(){
        this(Default_size);
    }
    public Stack(int size){
        this.arr = new int[size];


    }
    public void push(int data){

        this.rear++;
        arr[rear]= data;


    }
    public int pop(){
        if(rear==-1){
            System.out.println("The stack is empty !");
            return -1;
        }

        int element = arr[rear];
        rear--;
        return element;

    }
    public int peek(){
        if(rear==-1){
            System.out.println("The stack is empty !");
            return -1;
        }
        int element = arr[0];
        return element;
    }
    public void display(){
        if(rear==-1){
            System.out.println("The stack is empty !");
            return ;
        }

        for(int i=0;i<=rear;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }


}
