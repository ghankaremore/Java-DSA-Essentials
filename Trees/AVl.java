public class AVl{
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
    public AVl(){

    }
    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    public int height(){
        return height(root);
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
        return rotate(node);

    }

    public Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            if (height(node.left.left) - height(node.left.right) > 0) {
               return   rightrotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
               node.left =  leftrotate(node.left);
               return rightrotate(node);
            }
        }
        if (height(node.left) - height(node.right) <-1) {
            if (height(node.right.left) - height(node.right.right) < 0) {
               return leftrotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                node.right = rightrotate(node.right);
               return leftrotate(node);
            }
        }
        return node;
    }

    public Node leftrotate(Node node){
        Node top = node.right;
        Node temp = top.left;
        top.left = node;

            node.right = temp;

        node.height = Math.max(height(node.left),height(node.right))+1;
        top.height = Math.max(height(top.left),height(top.right))+1;


        return top;
    }

    public Node rightrotate(Node node){
        Node top = node.left;
        Node temp = top.right;
        top.right = node;

            node.left= temp;

        node.height = Math.max(height(node.left),height(node.right))+1;
        top.height = Math.max(height(top.left),height(top.right))+1;

        return top;


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

}
