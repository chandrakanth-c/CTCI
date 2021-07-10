package datastructures.treesandgraphs;

/**
 * This code is not similar to the onin the solutions of CTCI
 */
public class ValidateBST {

    private Integer last_printed=null;

    public boolean validateBST(TreeNode root){
        if(root == null) return true;

        if(!validateBST(root.left)) return false;

        if(last_printed!=null && root.val<=last_printed) return false;
        last_printed=root.val;

        if(!validateBST(root.right)) return false;

        return true;
    }
    
    public static void main(String[] args) {
        MinimalTree m=new MinimalTree();
        TreeNode root= m.createMinimalBST(new int[]{1,2,3,4,5,6,7});

        ValidateBST vB=new ValidateBST();

        boolean b=vB.validateBST(root);

        System.out.println(b);

    }
}
