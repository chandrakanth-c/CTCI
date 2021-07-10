package datastructures.stacksandqueues;

import java.util.EmptyStackException;

/*
This is the fixed division approach
*/
class ThreeInOne{

    private int numberOdStacks=3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public ThreeInOne(int size){
        this.stackCapacity=size;
        this.values=new int[stackCapacity*numberOdStacks];
        this.sizes=new int[numberOdStacks];
    }
    
    public void push(int stackNumber,int item) throws Error{
        if(isFull(stackNumber)) {
            throw new StackOverflowError();
        }
        sizes[stackNumber]++;
        values[indexOfTop(stackNumber)]=item;
    }
    
    public int pop(int stackNumber) throws EmptyStackException{
        if(isEmpty(stackNumber)) throw new EmptyStackException();
        int item=values[indexOfTop(stackNumber)];
        sizes[stackNumber]--;
        return item;
    }


    public int peek(int stackNumber){
        if(isEmpty(stackNumber)) throw new EmptyStackException();
        return values[indexOfTop(stackNumber)];
    }

    public boolean isEmpty(int stackNumber){
        return sizes[stackNumber]==0;
    }

    public boolean isFull(int stackNumber){
        return sizes[stackNumber] == stackCapacity;
    }

    public int indexOfTop(int stackNumber){
        int offset=stackNumber*stackCapacity;
        int indSize=sizes[stackNumber];
        return offset+indSize-1;
    }
    

    public static void main(String[] args){
        ThreeInOne stack=new ThreeInOne(6);
        System.out.println(stack.isEmpty(0));
        System.out.println(stack.isEmpty(1));
        System.out.println(stack.isEmpty(2));
        stack.push(0,1);
        stack.push(0,2);
        stack.push(1,1);
        stack.push(1,2);
        stack.push(2,1);
        stack.push(2,2);
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(1));
        System.out.println(stack.pop(1));
        System.out.println(stack.pop(2));
        System.out.println(stack.pop(2));
        System.out.println(stack.isEmpty(0));
        System.out.println(stack.isEmpty(1));
        System.out.println(stack.isEmpty(2));
    }

}