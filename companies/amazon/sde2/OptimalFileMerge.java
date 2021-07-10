package companies.amazon.sde2;
import java.util.*;

public class OptimalFileMerge {

    public int minimumCost(int[] files){
        if(files.length==1) return files[0];
        PriorityQueue<Integer> pq=new PriorityQueue<>();        
        for(int i=0;i<files.length;i++) pq.add(files[i]);
        int ans=0;
        while(!pq.isEmpty() && pq.size()!=1){
            int temp=pq.poll()+pq.poll();
            ans+=temp;
            pq.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        OptimalFileMerge ofm=new OptimalFileMerge();
        int files[] = new int[] { 2, 3, 4, 5, 6, 7 };
        System.out.println("Minimum Computations = "
                           + ofm.minimumCost(files));
    }
    
}
