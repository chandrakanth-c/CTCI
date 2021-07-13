package companies.amazon.sde2;
import java.util.*;

public class UniquePositiveIntegers {
    static Map<Integer, Integer> map = new HashMap<>();

    public static List<List<Integer>> combSum(int [] candidates, int k){
        for (int i = 0; i < candidates.length; i++) {
            map.put(candidates[i], i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(ans, new LinkedList<>(), candidates, k, 0, 0);
        return ans;
    }

    public static void backTrack(List<List<Integer>> ans, LinkedList<Integer> comb,int [] candidates, int k, int sum, int start_index){
        if(sum==k){
            ans.add(new LinkedList<>(comb));
        }
        for (int i = start_index; i < candidates.length; i++) {
            if(comb.isEmpty()) {
                sum+=candidates[i];
                comb.add(candidates[i]);
            } else{
                int prevIndex=map.get(comb.get(comb.size()-1));
                int curIndex = map.get(candidates[i]);
                int diff = Math.abs(curIndex-prevIndex);
                if(diff==1) continue;
                else {
                    comb.add(candidates[i]);
                    sum+=candidates[i];
                }
            }
            backTrack(ans, comb, candidates, k, sum, i+1);
            sum-=comb.getLast();
            comb.removeLast();
            
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1, 9, 8, 3, 6, 7, 5, 11, 12, 4};
        System.out.println(combSum(arr,14));
    }
}
