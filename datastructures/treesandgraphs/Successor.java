package datastructures.treesandgraphs;

import java.util.*;

public class Successor {

    public int successorInOrder(TreeNode root,int val){
        List<Integer> res=new ArrayList<>();
        helper(root,res);

        for(int i=0;i<res.size();i++){
            if(res.get(i) == val){
                return res.get(i+1);
            }
        }

        return -1;
    }

    void helper(TreeNode root,List<Integer> res){
        if(root==null) return;

        helper(root.left,res);
        res.add(root.val);
        helper(root.right, res);
    }

    public static void main(String[] args) {

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        
        Successor s=new Successor();

        System.out.println(s.successorInOrder(root,2));
        
    }
    
}
