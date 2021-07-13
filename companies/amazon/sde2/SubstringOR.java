package companies.amazon.sde2;
import java.util.*;

public class SubstringOR {
    public static int process(int[] input , int k){
        //first is value and second is index
        PriorityQueue<int[]> pq = new PriorityQueue<>( ( a, b) -> (a[0] - b[0]) );
        
        for(int i = 0 ; i < input.length ; i++){
            pq.add(new int[]{input[i]  , i});
        }
        
        while(k > 1 &&  !pq.isEmpty()){
            k--;
            int[] min = pq.remove();
            if(min[1] < input.length -1){
                pq.add(new int[]{ min[0] | input[min[1] + 1] , min[1] +1});
            }
        }
        
        if(k > 1 || pq.isEmpty()) return -1;
        return pq.remove()[0];
    }

    public static void main(String[] args) {
        System.out.println(process(new int[]{1, 2, 3} , 6));
    }
}
