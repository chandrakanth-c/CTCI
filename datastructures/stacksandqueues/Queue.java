package datastructures.stacksandqueues;

import java.lang.RuntimeException;

public class Queue<T> {
    
    class Node<T>{
        private T val;
        private Node<T> next;

        public Node(T val){
            this.val=val;
        }
    }

    private Node<T> top;
    private Node<T> last;

    public void add(T item){
        Node<T> firstItem=new Node<T>(item);
        if(last == null){
            last=firstItem;
            top=last;
            return;
        }
        last.next=firstItem;
        last=firstItem;
    }

    public T remove(){
        if(top==null) throw new RuntimeException("Queue is empty");
        T item=top.val;
        top=top.next;
        return item;
    }

    public T peek(){
        if(top==null) throw new RuntimeException("Queue is empty");
        T item=top.val;
        return item;
    }

    public boolean isEmpty(){
        return top==null;
    }
    
    public static void main(String[] args){
        Queue<Integer> queue=new Queue<>();
        //checking whether the queue is empty
        System.out.println(queue.isEmpty());
        //adding items to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);
        //checking whether the queue is empty
        System.out.println(queue.isEmpty());
        //removing items from the queue
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        //peeking into the queue
        System.out.println(queue.peek());
        //removing the last item
        System.out.println(queue.remove());
        //checking whether the queue is empty
        System.out.println(queue.isEmpty());
    }
}
