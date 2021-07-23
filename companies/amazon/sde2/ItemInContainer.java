/**
 * Given a string s consisting of items as "*" and closed compartments 
 * as an open and close "|", an array of starting indices startIndices, and 
 * an array of ending indices endIndices, determine the number of items in closed 
 * compartments within the substring between the two indices, inclusive.

An item is represented as an asterisk *
A compartment is represented as a pair of pipes | that may or may not have items between them.
Example:
s = '|**|*|*'
startIndices = [1,1]
endIndices = [5,6]

The String has a total 2 closed œ, one with 2 items and one with 1 item. 
For the first par of indices, (1,5), the substring is '|**|*'. There are 2 items in a 
compartment.
For the second pair of indices, (1,6), the substring is '|**|*|' and 
there 2+1=3 items in compartments.
Both of the answers are returned in an array. [2,3].
 */
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