// be really careful about passing by reference of java. TreeNode pointer wont
// pass, however arraylist will do the trick.
import java.util.*;
class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class RecoverBinarySearchTree {
    public static void main (String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.left.left = new TreeNode(3);
      RecoverBinarySearchTree rbst = new RecoverBinarySearchTree();
      rbst.recoverTree(root);
      //System.out.println("final_result:"+root.val+" "+root.left.val+" "+root.left.left.val);
    }
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> swap = new ArrayList<TreeNode>();
        create(root, swap, Integer.MIN_VALUE);
        if (swap.size() == 2) {
          ArrayList<TreeNode> p1 = new ArrayList<TreeNode>(), p2 = new ArrayList<TreeNode>();
          p1.add(new TreeNode(-1));
          p2.add(new TreeNode(-1));
          TreeNode parent1 = getPrevious(root, swap.get(0), p1), 
          parent2 = getPrevious(root, swap.get(1), p2);
          //System.out.println("parents:"+parent1.val+" "+parent2.val);
          int temp = 0;
          temp = swap.get(0).val;
          swap.get(0).val = parent2.val;
          parent2.val = temp;      
          //System.out.println("result:"+root.val+" "+root.left.val+" "+root.left.left.val);
          ArrayList<TreeNode> check = new ArrayList<TreeNode>();
          create(root, check, Integer.MIN_VALUE);
          //System.out.println("check:"+check.size());
          if (check.size() != 0) {
            //System.out.println("swap:"+swap.get(0).val+" "+parent2.val);
            temp = swap.get(0).val;
            swap.get(0).val = parent2.val;
            parent2.val = temp;
            //System.out.println("swap:"+swap.get(1).val+" "+parent1.val);

            temp = swap.get(1).val;
            swap.get(1).val = parent1.val;
            parent1.val = temp;


            //System.out.println("result:"+root.val+" "+root.left.val+" "+root.left.left.val);
          }
        } else if (swap.size() == 1){
            ArrayList<TreeNode> previous = new ArrayList<TreeNode>();
            previous.add(new TreeNode(-1));
            TreeNode parent = getPrevious(root, swap.get(0),previous);
            
            int temp = 0;
            temp = swap.get(0).val;
            swap.get(0).val = parent.val;
            parent.val = temp;
        }
    }
    public int create(TreeNode root, ArrayList<TreeNode> swap, int last) {
        if (root == null) return last;
        //System.out.println("begin:"+root.val);
        if (root.left != null) last = create(root.left, swap, last);
        if (root.val < last) {
            swap.add(root);
            //System.out.println("insert:"+root.val);
        }
        last = root.val;
        if (root.right != null) last=create(root.right, swap, last);
        return last;
    }
    public TreeNode getPrevious(TreeNode root, TreeNode child, ArrayList<TreeNode> previous) {
        if (root == null) return null;
        
        TreeNode left = getPrevious(root.left, child, previous);
        if (left != null) return left;
        if (root == child) return previous.get(0);
        previous.remove(0); previous.add(root);
        TreeNode right = getPrevious(root.right, child, previous);
        return right;
    }
}
