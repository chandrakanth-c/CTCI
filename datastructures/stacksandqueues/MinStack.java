package datastructures.stacksandqueues;
import java.util.EmptyStackException;

public class MinStack {

    private int[] minstack;
    private int[] state;
    private int top;
    private int min;

    public MinStack(int size){
        minstack=new int[size];
        state=new int[size];
        top=-1;
        min=0;
    }

    public void push(int value) throws Error{
        if(isFull()) throw new StackOverflowError();
        minstack[++top]=value;
        if(minstack[top]<minstack[min]) min=top;
        state[top]=minstack[min];
    }

    public int pop() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        return minstack[top--];
    }

    public int peek() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        return minstack[top];
    }

    public int min(){
        return state[top];
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==(minstack.length-1);
    }

    public static void main(String[] args){
        MinStack minStack=new MinStack(5);
        System.out.println(minStack.isEmpty());
        minStack.push(-100);
        minStack.push(2);
        minStack.push(-1);
        minStack.push(100);
        minStack.push(-20);
        System.out.println(minStack.min());
        System.out.println(minStack.peek());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.min());
    }
}
