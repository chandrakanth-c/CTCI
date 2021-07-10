package datastructures.treesandgraphs;

import javax.swing.text.ComponentView;

public class FirstCommonAncestor {

    public TreeNode firstCommonAncestor(TreeNode root,int p,int q){
        if(root.val==p || root.val==q) return root;
        return helper(root,p,q);
    }

    private TreeNode helper(TreeNode root,int p,int q){
        if(root == null) return null;

        boolean pOnLeft=covers(root.left, p);
        boolean qOnLeft=covers(root.left, q);

        if(pOnLeft != qOnLeft) return root;
        else return pOnLeft ? helper(root.left, p, q) : helper(root.right, p, q);
    }

    private boolean covers(TreeNode root,int p){
        if(root==null) return false;
        if(p==root.val) return true;
        return covers(root.left,p) || covers(root.right,p);
    }

    public static void main(String[] args) {
        TreeNode tree=new TreeNode(3);
        tree.left=new TreeNode(5);
        tree.left.left=new TreeNode(6);
        tree.left.right=new TreeNode(2);
        tree.left.right.left=new TreeNode(7);
        tree.left.right.right=new TreeNode(4);
        tree.right=new TreeNode(1);
        tree.right.left=new TreeNode(0);
        tree.right.right=new TreeNode(8);

        FirstCommonAncestor fca=new FirstCommonAncestor();

        System.out.println(fca.firstCommonAncestor(tree, 5, 1).val);
    }
    
}
