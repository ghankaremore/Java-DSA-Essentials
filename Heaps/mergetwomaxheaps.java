
import java.util.*;
public class mergetwomaxheaps {
    

        public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
            ArrayList<Integer> list = new ArrayList();
            for(int i=0;i<n;i++){
                list.add(a[i]);
            }
            for(int i=0;i<m;i++){
                list.add(b[i]);
                upheap(list,list.size()-1);

            }
            int[] ans = new int[list.size()];
            for(int i=0;i<ans.length;i++){
                ans[i] = list.get(i);
            }
            return ans;
        }
        public void upheap(ArrayList<Integer>  a, int index){
            if(index<=0){
                return;
            }
            int parent= (index-1)/2;
            if(a.get(index)>a.get(parent)){
                int temp = a.get(index);
                a.set(index,a.get(parent));
                a.set(parent,temp);
            }

            upheap(a,parent);

        }
    }

