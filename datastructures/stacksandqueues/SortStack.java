package datastructures.stacksandqueues;

public class SortStack {

    public void sortStack(Stack<Integer> s){
        Stack<Integer> r=new Stack<>();
        while(!s.isEmpty()){
            int temp=s.pop();
            while(!r.isEmpty() && (r.peek() > temp)){
                s.push(r.pop());
            }
            r.push(temp);
        }

        while(!r.isEmpty()){
            s.push(r.pop());
        }
    }

    public static void main(String[] args) {
        /*
        *Creation of a regular stack 
        */ 
        Stack<Integer> stack=new Stack<>();
        stack.push(10);
        stack.push(5);
        stack.push(8);
        stack.push(15);
        stack.push(12);

        /**
         * Sorting the regular stack
         */
        SortStack ss=new SortStack();
        ss.sortStack(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
