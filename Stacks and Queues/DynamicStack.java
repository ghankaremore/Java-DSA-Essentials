public class DynamicStack extends Stack{
    public DynamicStack(){
        super();
    }
    public DynamicStack(int size){
        super(size);
    }
    @Override
    public void push(int data){
        if(this.rear==-1){
            int[] temp = new int[arr.length*2];
            for(int i=0;i<arr.length;i++){
                temp[i] = arr[i];
            }
            arr = temp;
        }
        super.push(data);
    }
}
