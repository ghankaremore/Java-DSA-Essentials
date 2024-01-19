import java.util.ArrayList;

class Heap<T extends Comparable<T>>{
    private ArrayList<T> list;
    public Heap(){
        list = new ArrayList<T>();
    }

    public void swap(int first,int second){
        T temp = list.get(first);
        list.set(first,list.get(second));
        list.set(second,temp);
    }

    public int parent(int index){
        return (index-1)/2;
    }

    public int left(int index){
        return 2*index +1;
    }
    public int right(int index){
        return 2*index +2;
    }
    public void insert(T value){
        list.add(value);
        upheap(list.size()-1);
    }
    private void upheap(int index){
        if(index==0){
            return;
        }
        int p = parent(index);
        if(list.get(index).compareTo(list.get(p))<0){
            swap(index,p);
            upheap(p);
        }

    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Removing from empty heap");

        }
        T temp = list.get(0);
        T last = list.remove(list.size()-1);

        if(!list.isEmpty()) {
            list.set(0,last);
            downheap(0);
        }

        return temp;
    }

    private void downheap(int index){
    int min = index;
    int left = left(index);
    int  right = right(index);

    if(left<list.size() && list.get(min).compareTo(list.get(left))>0){
        min = left;
    }

    if(right<list.size() && list.get(min).compareTo(list.get(right))>0){
        min = right;
    }
    if(min!=index){
        swap(index,min);
        downheap(min);
    }
    }

    public ArrayList<T> heapSort(){
        ArrayList<T> newlist = new ArrayList<>();
        while(!list.isEmpty()){
            newlist.add(list.remove(0));
        }
        return newlist;
    }
   public void print(){
       System.out.println(list);
   }


}