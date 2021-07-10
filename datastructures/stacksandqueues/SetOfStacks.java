package datastructures.stacksandqueues;

import java.util.*;
import java.util.EmptyStackException;

public class SetOfStacks {

    private List<IStack> stacks=new ArrayList<>();
    private int threshold;

    public SetOfStacks(int threshold){
        this.threshold=threshold;
    }

    public void push(int val){
        IStack last=getLastStack();
        if(last==null || last.getSize()==threshold){
            IStack stack=new IStack();
            stack.push(val);
            stacks.add(stack);
        }else{
            last.push(val);
        }
    }

    public int pop() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        IStack last=getLastStack();
        int item = last.pop();
        if(last.getSize()==0) stacks.remove(stacks.size()-1);
        return item;
    }
    
    public int peek() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        return getLastStack().peek();
    }

    public int popAt(int index){
        return leftShift(index, true);
    }

    private int leftShift(int index,boolean isTopIndex){
        IStack node=stacks.get(index);
        int ret_element;
        if(isTopIndex) ret_element=node.pop();
        else{
            ret_element=node.removeBottom();
        }

        if(stacks.size()-1>index){
            int item=leftShift(index+1, false);
            node.push(item);
        }

        return ret_element;
    }

    public boolean isEmpty(){
        IStack last=getLastStack();
        return last==null || last.isEmpty();
    }

    public IStack getLastStack(){
        return stacks.size() == 0 ? null : stacks.get(stacks.size()-1);
    }

    public static void main(String[] args){
        SetOfStacks stacks=new SetOfStacks(3);
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.push(5);
        stacks.push(6);
        System.out.println(stacks.peek());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.popAt(0));
        System.out.println(stacks.isEmpty());
        stacks.push(7);
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
    }
}

/*
*Individual Stack Implementation
*/
class IStack{

    //Individual Stack Node
    class IStackNode{
        private int val;
        private IStackNode next;
        private IStackNode prev;

        public IStackNode(int val){
            this.val=val;
            this.next=null;
            this.prev=null;
        }
    }

    private IStackNode top;
    private IStackNode bottom;
    private int size;

    public IStack(){
        this.top=null;
        this.bottom=null;
        this.size=0;
    }

    public void push(int val){
        IStackNode node=new IStackNode(val);

        if(top==null){
            bottom=node;
            top=bottom;
            size++;
            return;
        }

        node.next=top;
        top.prev=node;
        top=node;
        size++;
    }

    public int pop() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        int item=top.val;
        top=top.next;
        if(top!=null) top.prev=null;
        size--;
        return item;
    }

    public int peek() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        return top.val;
    }

    public int removeBottom() throws EmptyStackException{
        if(bottom == null) throw new EmptyStackException();
        int item=bottom.val;
        bottom=bottom.prev;
        if(bottom!=null) bottom.next=null;
        size--;
        return item;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int getSize(){
        return size;
    }
}
