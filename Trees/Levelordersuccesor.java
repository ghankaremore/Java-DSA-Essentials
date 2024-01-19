import org.w3c.dom.Node;

import java.util.*;

public class Levelordersuccesor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        Binarytree tree = new Binarytree();
        tree.populate(sc);
        System.out.println(levelsuc(tree.root,target).val);
    }
    public static Binarytree.Node levelsuc(Binarytree.Node root, int target){
        if(root==null){
            return null;
        }


        Queue<Binarytree.Node> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelsize = queue.size();
            for(int i=0;i<levelsize;i++){
                Binarytree.Node node = queue.poll();
                if(node.val==target){
                    return queue.poll();
                }

                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }

            }
        }
        return null;

    }
}
