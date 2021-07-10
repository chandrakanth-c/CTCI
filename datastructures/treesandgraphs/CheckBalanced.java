package datastructures.treesandgraphs;

public class CheckBalanced {

    private static int ERR_CODE=Integer.MIN_VALUE;
    
    public boolean checkBalanaced(TreeNode root){
        return checkHeight(root) != ERR_CODE;
    }

    private int checkHeight(TreeNode root){
        if(root==null) return 0;

        int left_height=checkHeight(root.left);
        if(left_height == ERR_CODE) return ERR_CODE;

        int right_height=checkHeight(root.right);
        if(right_height == ERR_CODE) return ERR_CODE;

        int diff=Math.abs(left_height-right_height);

        if(diff>1){
            return ERR_CODE;
        }else{
            return Math.max(left_height,right_height)+1;
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(2);
        root.left.left.left=new TreeNode(2);
        root.right=new TreeNode(3);

        CheckBalanced cB=new CheckBalanced();
        boolean b=cB.checkBalanaced(root);
        System.out.println(b);
    }

}
