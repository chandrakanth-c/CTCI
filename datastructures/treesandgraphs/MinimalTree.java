package datastructures.treesandgraphs;

public class MinimalTree {

    public TreeNode createMinimalBST(int[] arr){
        return (createMinimalBST(arr,0,arr.length-1));
    }

    private TreeNode createMinimalBST(int[] arr,int lo,int hi){
        if(lo>hi) return null;
        int m=lo+(hi-lo)/2;
        TreeNode n=new TreeNode(arr[m]);
        n.left=createMinimalBST(arr, lo, m-1);
        n.right=createMinimalBST(arr, m+1, hi);
        return n;
    }

    void printInorder(TreeNode root){
        helper(root);
    }

    void helper(TreeNode root){
        if(root == null) return;
        printInorder(root.left);
        System.out.print(root.val+" ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        MinimalTree mT=new MinimalTree();
        TreeNode node=mT.createMinimalBST(new int[]{1,2,3,4,5,6,7});
        mT.printInorder(node);
    }
}
