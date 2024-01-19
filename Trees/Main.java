import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Binarytree tree = new Binarytree();
//        Scanner sc = new Scanner(System.in);
//
//        tree.populate(sc);
//        tree.display();
////        tree.prettydisplay();
//        BST tree = new BST();
//        tree.insert(8);
//        tree.insert(7);
//        tree.insert(87);
//        tree.insert(23);
//        tree.insert(1);
//        tree.insert(45);
//        tree.display();
//         AVl tree = new AVl();
//         for(int i=0;i<1000;i++){
//             tree.insert(i);
//         }
//        System.out.println(tree.height());
        BST tree = new BST();
        tree.insert(6);
        tree.insert(2);
        tree.insert(9);
        tree.insert(4);
        tree.insert(5);
        tree.bfs();
    }
}
