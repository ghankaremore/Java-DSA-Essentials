public class ifbinarytreeaheap {




        boolean isHeap(Node tree) {
            int count = countnodes(tree);
            return iscbt(tree,0,count) && isheap(tree);

        }

        int countnodes(Node tree){
            if(tree==null){
                return 0;

            }

            int ans = 1 + countnodes(tree.left) + countnodes(tree.right);
            return ans;
        }

        boolean iscbt(Node tree, int curr, int count){
            if(tree==null){
                return true;
            }
            if(curr>=count){
                return false;

            }
            boolean left = iscbt(tree.left,2*curr+1,count);
            boolean right = iscbt(tree.right,2*curr+2,count);
            return left&&right;



        }

        boolean isheap(Node tree){
            if(tree==null){
                return true;
            }

            if((tree.left!=null && tree.data<tree.left.data) || (tree.right!=null &&tree.data <tree.right.data)){
                return false;
            }

            return isheap(tree.left) && isheap(tree.right);
        }
    }

