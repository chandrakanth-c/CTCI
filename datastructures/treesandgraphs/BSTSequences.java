package datastructures.treesandgraphs;

import java.util.*;

/**
 * Check the logic once again
 */
public class BSTSequences {

    public List<LinkedList<Integer>> allSeq(TreeNode root){

        List<LinkedList<Integer>> result=new ArrayList<>();

        if(root==null){
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix=new LinkedList<>();
        prefix.add(root.val);

        List<LinkedList<Integer>>  leftSeq=allSeq(root.left);
        List<LinkedList<Integer>>  rightSeq=allSeq(root.right);

        for(LinkedList<Integer> left:leftSeq){
            for(LinkedList<Integer> right:rightSeq){
                List<LinkedList<Integer>> results=new ArrayList<>();
                weave(left,right,prefix,results);
                result.addAll(results);
            }
        }

        return result;
    }

    private void weave(LinkedList<Integer> first,LinkedList<Integer> last,LinkedList<Integer> prefix,List<LinkedList<Integer>> results){

        if(first.size()==0 || last.size() == 0){
            LinkedList<Integer> result=(LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(last);
            results.add(result);
            return;
        }

        int firstHead=first.removeFirst();
        prefix.addLast(firstHead);
        weave(first, last, prefix, results);
        prefix.removeLast();
        first.addFirst(firstHead);

        int secondHead=last.removeFirst();
        prefix.addLast(secondHead);
        weave(first, last, prefix, results);
        prefix.removeLast();
        last.addFirst(secondHead);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(1);
        root.left.right=new TreeNode(2);
        root.right=new TreeNode(4);
        root.right.right=new TreeNode(5);

        BSTSequences bst=new BSTSequences();
        System.out.println(bst.allSeq(root)); 
    }
}
