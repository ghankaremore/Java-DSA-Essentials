import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private Node root;
    class Node{
        int val;
        int height;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }

        public int getVal(){
            return val;
        }
    }
    public BST(){

    }
    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    public boolean isempty(Node node){
        return  node==null;
    }
    public void insert(int data){
        root = insert(root,data);
    }
    public Node insert(Node node, int data){
        if(node ==null){
            Node newnode = new Node(data);
            return newnode;
        }
        if(data<node.val){
            node.left = insert(node.left,data);
        }
        if(data>node.val){
            node.right = insert(node.right,data);
        }
        node.height = Math.max(height(node.left),height(node.right))+1;
        return node;

    }
    public boolean balanced(){
        return Balanced(root);
    }
    private boolean Balanced(Node node){
        if(node ==null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right))<=1 && Balanced(node.left) && Balanced(node.right);
    }

    public void display(){
        Display(root,"Root node : ");
    }
    private void Display(Node node, String Details){
        if(node==null){
            return;
        }
        System.out.println(Details + node.val);
        Display(node.left,"Left of Node " + node.val + " ");
        Display(node.right,"Right of Node " + node.val+ " ");

    }


    public void bfs(){

        Queue<Node> queue = new LinkedList<>();
        System.out.print(root.val + " ");
        queue.add(root);





        BFS(queue);
    }
    public void BFS( Queue q){
        if(q.isEmpty()){
            return;
        }
        Node node = (Node) q.remove();


        if(node.left!=null) {
            q.add(node.left);
            System.out.print(node.left.val + " ");
        }

        if(node.right!=null) {
            q.add(node.right);
            System.out.print(node.right.val + " ");
        }
        BFS(q);

    }


}
