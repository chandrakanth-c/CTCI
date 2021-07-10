package datastructures.stacksandqueues;

import java.util.EmptyStackException;

/*
*Note: Stack Overflow case (if the stacks had a fixed size) is not considered here
*/

public class QueueViaStacks {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueViaStacks(){
        this.stack1=new Stack<>();
        this.stack2=new Stack<>();
    }

    public void add(int item){
        stack1.push(item);
    }

    public int remove() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean isEmpty(){
        return (stack1.isEmpty() && stack2.isEmpty());
    }

    public static void main(String[] args){
        QueueViaStacks queue=new QueueViaStacks();
        System.out.println(queue.isEmpty());
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
    }
    
}
