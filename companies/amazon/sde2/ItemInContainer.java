package companies.amazon.sde2;
import java.util.*;

class ItemsInContainer{
    public List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        int[] mem = new int[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '|') {
                mem[i] = count;
            } else {
                ++count;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < startIndices.size(); ++i) {
            int start = startIndices.get(i) - 1;
            int end = endIndices.get(i) - 1;
            
            while (start < end && s.charAt(start) != '|') ++start;
            while (start < end && s.charAt(end) != '|') --end;
    
            ans.add(mem[end] - mem[start]);
        }
        return ans;
    }
    public static void main(String[] args) {
        ItemsInContainer ic=new ItemsInContainer();
        List<Integer> startIndices=new ArrayList<>();
        startIndices.add(1);
        startIndices.add(1);
        List<Integer> endIndices=new ArrayList<>();
        endIndices.add(5);
        endIndices.add(6);
        System.out.println(ic.numberOfItems("|**|*|*", startIndices, endIndices));
    }
}