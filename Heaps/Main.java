import java.lang.reflect.Array;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
       Heap<Integer> heap = new Heap<>();
       heap.insert(5);
       heap.insert(10);
       heap.insert(3);
       heap.insert(1);
        ArrayList list = heap.heapSort();
        System.out.println(list);
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(45);
        list1.add(34);
        list1.add(55);
        list1.add(23);
        list1.add(67);
        converttominheap(list1);
        System.out.println(list1);

    }
    public static void converttominheap(ArrayList<Integer> list ){
        int n = list.size();
        for(int i = n/2;i>=0;i--){
            heapify(list,n,i);
        }
    }

    public static void heapify(ArrayList<Integer> list, int n , int index){
        int smallest = index;
        int left = 2*index+1;
        int right = 2*index+2;

        if(left<n && list.get(left).compareTo(list.get(smallest))<0){
            smallest = left;
        }
        if(right<n && list.get(right).compareTo(list.get(smallest))<0){
            smallest = right;
        }

        if(smallest!=index){
            int temp = list.get(index);
            list.set(index,list.get(smallest));
            list.set(smallest,temp);

            heapify(list,n,smallest);
        }
    }

}