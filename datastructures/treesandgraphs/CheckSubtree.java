package datastructures.treesandgraphs;

public class CheckSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        
        return isIdentical(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    
    boolean isIdentical(TreeNode root,TreeNode subRoot){
        if(root==null && subRoot==null) return true;
        if((root==null && subRoot!=null) || (root!=null && subRoot==null)) return false;
        
        return root.val==subRoot.val && isIdentical(root.left,subRoot.left) && isIdentical(root.right,subRoot.right);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(4);
        root.right=new TreeNode(5);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(2);

        TreeNode subRoot=new TreeNode(4);
        subRoot.left=new TreeNode(1);
        subRoot.right=new TreeNode(3);

        CheckSubtree check=new CheckSubtree();
        System.out.println(check.isSubtree(root, subRoot));
    }
}
