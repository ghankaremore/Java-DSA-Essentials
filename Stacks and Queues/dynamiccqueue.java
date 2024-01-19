public class dynamiccqueue  extends Circularqueue{
    public dynamiccqueue(){
        super();
    }
    public dynamiccqueue(int size){
        super(size);
    }
    @Override
    public void insert(int element){
        if(isFull()){
            int[] temp = new int[data.length*2];
            for(int i=0;i<data.length;i++){
                temp[i] = data[(front+i)%data.length];
            }

            front =0;
            rear = data.length;
            data = temp;


        }
        super.insert(element);
    }
}
