import java.util.Scanner;
public class Binarytree {
     class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }

    public Node root;

    public void populate(Scanner scanner){
        System.out.println("Enter the value for root node ");
        int value = scanner.nextInt();
         this.root = new Node(value);

         populate1(scanner,root);



    }
    public void populate1(Scanner scanner, Node root){
        System.out.println("Do you want to enter at left of the node " + root.val);
        if(scanner.nextBoolean()){
            System.out.println("Enter the value for the node ");
            Node node = new Node(scanner.nextInt());
            root.left = node;
            populate1(scanner,root.left);
        }

        System.out.println("Do you want to enter at right of the node " + root.val);
        if(scanner.nextBoolean()){
            System.out.println("Enter the value for the node ");
            Node node = new Node(scanner.nextInt());
            root.right = node;
            populate1(scanner,root.right);
        }


    }
    public void display(){
        display(root," ");
    }
    public void display(Node root, String indent){
        if(root==null){
            return ;
        }
        System.out.println(indent + root.val);
        display(root.left,indent+"\t");
        display(root.right, indent+"\t");

    }
    public void prettydisplay(){
        prettydisplay(  root,0);
    }
    public void prettydisplay(Node node, int level){
        if(node==null){
            return;
        }
        prettydisplay(node.right,level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++){
                System.out.print("|\t\t");


            }
            System.out.println("|------------>" + node.val);
        }else {
            System.out.println(node.val);
        }
        prettydisplay(node.left,level +1);
    }

}
