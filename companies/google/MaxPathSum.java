package companies.google;
import companies.google.TreeNode;
/**
*Refer to the leetCode problem Maximum path binary tree
*/
class MaxPathSum{
	private int maxSum=Integer.MAX_VALUE;

	public int maxSum(TreeNode root){
		maxPathSum(root);
		return this.maxSum;
	}

	public int maxPathSum(TreeNode root){
		if(root==null) return 0;
		int leftPath=Math.max(maxPathSum(root.left),0);
		int rightPath=Math.max(maxPathSum(root.right),0);
		int curPathSum=leftPath+rightPath+root.val;
		this.maxSum=Math.max(curPathSum,maxSum);
		return root.val+Math.max(leftPath,rightPath);
	}

	public static void main(String[] args){
		MaxPathSum max=new MaxPathSum();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		int res=max.maxSum(root);
		System.out.println(res);
	}
}

