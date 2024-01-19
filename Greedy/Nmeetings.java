import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class meeting{
    int end;
    int start;

    int pos;
    public meeting(int start, int end, int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
class mycomparator implements Comparator<meeting>{


    @Override
    public int compare(meeting o1,meeting o2) {
        if(o1.end < o2.end){
            return -1;
        }else if(o1.end>o2.end){
            return 1;
        }
        return 0;
    }
}


public class Nmeetings {



    public  static ArrayList<Integer> maxmeeting(ArrayList<meeting> al){
        ArrayList<Integer> ans = new ArrayList<>();
               mycomparator mc = new mycomparator();
        Collections.sort(al,mc);
        ans.add(al.get(0).pos +1);
        int time = al.get(0).end;
        for(int i=1;i<al.size();i++){
           if(al.get(i).start>=time){
               ans.add(al.get(i).pos +1 );
               time = al.get(i).end;
           }

        }
        return ans;

    }
    public static void main(String[] args) {
        int s[] = { 1, 3, 0, 5, 8, 5 };


        int f[] = { 2, 4, 6, 7, 9, 9 };
        ArrayList<meeting> al = new ArrayList<>();
        for(int i=0;i<s.length;i++){
            meeting m = new meeting(s[i],f[i],i);
            al.add(m);
        }

        System.out.println(maxmeeting(al));

    }

}
