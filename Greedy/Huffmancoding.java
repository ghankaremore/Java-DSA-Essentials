import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }
    public Node(){

    }
}
class mycomparator1 implements Comparator<Node>{


    @Override
    public int compare(Node n1, Node n2) {
        if(n1.data>n2.data){
            return -1;
        }else if(n1.data<n2.data){
            return 1;
        }
        return 0;

    }
}

public class Huffmancoding {




    public static ArrayList<String> traverse(String temp, ArrayList<String> ans, Node root){
        if(root.left==null && root.right==null){
            ans.add(temp);
            return ans;
        }
        traverse(temp+0, ans, root.left);
        traverse(temp+1, ans, root.right);
        return ans;
    }
    public static  ArrayList<String> huffman(int[] feq , int N){
        PriorityQueue<Node> q
                = new PriorityQueue<Node>(
                N, new mycomparator1());

        for(int i=0;i<N;i++){
            Node node = new Node(feq[i]);
            q.add(node);
        }

        while(q.size()>1){
            Node left = q.peek();
            q.poll();
            Node right = q.peek();
            q.poll();

            Node newnode = new Node(left.data+ right.data);
            newnode.left = left;
            newnode.right = right;
            q.add(newnode);
        }
        Node root = q.poll();
        ArrayList<String> ans  = new ArrayList<>();
        String temp = "";
        return traverse(temp,ans,root);

    }




        public static void main(String[] args) {
            char[] inp= {'a','e','i','o','u'};
            int[] freq = {3,5,7,1,9};

            System.out.println(huffman(freq,5));
        }
}
