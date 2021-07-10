package datastructures.treesandgraphs;

import java.util.*;

public class ListsOfDepths {

    public List<LinkedList<Integer>> listsOfDepts(TreeNode root){

        System.out.println("entering the lists of depts function");

        List<LinkedList<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();

        queue.add(root);
        int level=0;

        while(!queue.isEmpty() && queue.peek() != null){
            int level_length=queue.size();
            res.add(new LinkedList<>());

            for(int i=0;i<level_length;i++){
                TreeNode node=queue.remove();
                res.get(level).add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.left!=null) queue.add(node.right);
            }

            level++;
        }

        return res;
    }

    public static void main(String[] args) {
        MinimalTree mT=new MinimalTree();
        TreeNode root=mT.createMinimalBST(new int[]{1,2,3,4,5,6,7});

        ListsOfDepths lD=new ListsOfDepths();
        List<LinkedList<Integer>> list=lD.listsOfDepts(root);

        System.out.println(list);
    }
}
