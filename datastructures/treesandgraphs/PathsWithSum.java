package datastructures.treesandgraphs;

import java.util.HashMap;
import java.util.*;

public class PathsWithSum {

    public int pathsWithSum(TreeNode root,int sum){
        Map<Integer,Integer> map=new HashMap<>();
        return helper(root,sum,0,map);
    }

    private int helper(TreeNode root,int sum,int currentSum,Map<Integer,Integer> map){

        if(root==null) return 0;

        currentSum+=root.val;

        int totalSumY=currentSum-sum;
        int totalPaths=map.getOrDefault(totalSumY, 0);

        if(currentSum==sum) totalPaths++;

        insertElement(currentSum, map, 1);
        totalPaths+=helper(root.left, sum, currentSum,map);
        totalPaths+=helper(root.right, sum, currentSum,map);
        insertElement(currentSum, map, -1);

        return totalPaths;
    }

    private void insertElement(int curSum,Map<Integer,Integer> map,int delta){
        int value=map.getOrDefault(curSum, 0)+delta;
        if(value==0){
            map.remove(curSum);
        }else{
            map.put(curSum, value);
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);

        PathsWithSum pws=new PathsWithSum();
        System.out.println(pws.pathsWithSum(root, 3)); 
    }
}
