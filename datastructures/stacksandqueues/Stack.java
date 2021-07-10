package datastructures.stacksandqueues;

import java.util.*;

public class Stack<T>{

    class Node<T>{  
        private T val;
        private Node<T> next;
        public Node(T val){
            this.val=val;
        }
    }

    private Node<T> top;

    public T pop(){
        if(top == null) throw new EmptyStackException();
        T item=top.val;
        top=top.next;
        return item;
    }

    public void push(T item){
        Node<T> newItem=new Node<T>(item);
        newItem.next = top;
        top=newItem;
    }

    public T peek(){
        if(top == null) throw new EmptyStackException();
        T item=top.val;
        return item;
    }

    public boolean isEmpty(){
        return top==null;
    }

    public static void main(String[] args){
        Stack<Integer> stack=new Stack<>();
        //checking wheather the stack is empty
        System.out.println(stack.isEmpty());
        //pushing an element into the stack
        stack.push(8);
        //checking wheather the stack is empty
        System.out.println(stack.isEmpty());
        //peeking an element in the stack
        System.out.println(stack.peek());
        //checking wheather the stack is empty
        System.out.println(stack.isEmpty());
        //popping an element from the stack
        System.out.println(stack.pop());
        //checking wheather the stack is empty
        System.out.println(stack.isEmpty());
    }
}