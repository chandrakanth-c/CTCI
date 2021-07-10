package companies.amazon.sde2;
import java.util.*;
class StorageOptimization{

	public static int storageOptimzation(int n, int m, int[] hRemove, int[] vRemove) {
    		Set<Integer> hRemoved = new HashSet<>();
    		Set<Integer> vRemoved = new HashSet<>();
    		for (int r : hRemove)
      			hRemoved.add(r);
    		for (int r : vRemove)
      			vRemoved.add(r);
    
   		 int prevH = 0;
   		 int maxHDiff = 0;
	         for (int h = 1; h <= n + 1; h++) {
      		 maxHDiff = Math.max(h - prevH, maxHDiff);
     		 if (!hRemoved.contains(h))
       			 prevH = h;
   		 }
   
		 int prevV = 0;
   		 int maxVDiff = 0;
   		 for (int v = 1; v <= m + 1; v++) {
     			 maxVDiff = Math.max(v - prevV, maxVDiff);
     			 if (!vRemoved.contains(v))
       			 prevV = v;
   		 }

   		 return maxHDiff * maxVDiff;
 	 }

 	 public static void main(String[] args) {
   		 System.out.println("Run0: opening(1,4 x 2,4), expected: 6, result: " + storageOptimzation(5, 5, new int[]{2,3}, new int[]{3}));
   		 System.out.println("Run1: opening(3,10 x 0,7), expected: 49, result: " + storageOptimzation(10, 10, new int[]{4,5,6,7,8,9}, new int[]{1,2,3,4,5,6,8,9,10}));
   		 System.out.println("Run2: opening(6,8 x 0,11), expected: 22, result: " + storageOptimzation(10, 10, new int[]{7}, new int[]{1,2,3,4,5,6,7,8,9,10}));
   		 System.out.println("Run3: opening(0,1 x 0,1), expected: 1, result: " + storageOptimzation(10, 10, new int[]{}, new int[]{}));
   		 System.out.println("Run4: opening(0,11 x 0,11), expected: 121, result: " + storageOptimzation(10, 10, new int[]{1,2,3,4,5,6,7,8,9,10}, new int[]{1,2,3,4,5,6,7,8,9,10}));
 	 }
}
