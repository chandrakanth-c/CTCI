package datastructures.treesandgraphs;

import java.util.Random;

/**
 * In this question you are asked to build a TreeNode from the scratch
 * Please note : The representation of GetRandomNode is exactly similar to TreeNode
 */
public class GetRandomNode {
    private int data;
    public GetRandomNode left;
    public GetRandomNode right;
    private int size;

    public GetRandomNode(int value){
        this.data=value;
        this.size=1;
    }

    public int getSize(){
        return this.size;
    }

    public int getData(){
        return this.data;
    }

    /**
     * Insert operation
     */
    public void insert(int d){
        if(d<=getData()){
            if(left==null){
                left=new GetRandomNode(d);
            }else{
                left.insert(d);
            }
        }else{
            if(right==null){
                right=new GetRandomNode(d);
            }else{
                right.insert(d);
            }
        }

        this.size++;
    }

    /**
     * Find operation
     */
    public GetRandomNode find(int d){
        if(d<getData()){
            return left!=null ? left.find(d) : null;
        }else if(d>getData()){
            return right!=null ? right.find(d) : null;
        }else{
            return this;
        }
    }

    /**
     * Getting random node
     */
    public GetRandomNode getRandom(){
        int leftSize=left==null?0:left.getSize();
        Random random=new Random();
        int index=random.nextInt(getSize());
        if(index<leftSize){
            return left.getRandom();
        }else if(index==leftSize){
            return this;
        }else{
            return right.getRandom();
        }
    }
}

class Main{
    public static void main(String[] args) {
        GetRandomNode grn=new GetRandomNode(4);
        grn.insert(1);
        grn.insert(2);
        grn.insert(3);
        grn.insert(4);
        grn.insert(5);
        grn.insert(6);
        grn.insert(7);

        System.out.println(grn.find(4).getData());
        System.out.println(grn.find(4).getSize());
        System.out.println(grn.getRandom().getData());        
    }
}
