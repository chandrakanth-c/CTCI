//There is a slight change in the solution where in we have to return the original index and not the modified index by the sort function
package companies.amazon.sde2;
import java.util.*;

class MoviesOnFlight{

	public int[] movieOnFlight(int[] arr,int d){
		Map<Integer,Integer> indexMap=new HashMap<>();
		for(int i=0;i<arr.length;i++) indexMap.put(arr[i],i);
		Map<Integer,int[]> map=new HashMap<>();
		Arrays.sort(arr);
		int l=0,r=arr.length-1;
		int duration=d-30;
		while(l<r){
			int diff=duration-(arr[l]+arr[r]);
			map.put(diff,new int[]{l,r});
			if(diff>0){
				l++;
			}else{
				r--;
			}
		}
		for(int i:map.keySet()){;
			System.out.println("key "+i);
			for(int j:map.get(i)) System.out.println("value "+j);
		}
		int key=Integer.MAX_VALUE;
		for(int i:map.keySet()){
			if(i>=0){
				key=Math.min(i,key);
			}
		}
		int[] ans=new int[2];
		ans[0]=indexMap.get(arr[map.get(key)[0]]);
		ans[1]=indexMap.get(arr[map.get(key)[1]]);
		return ans;
	}

	public static void main(String[] args){
		MoviesOnFlight mF=new MoviesOnFlight();
		int[] ans=mF.movieOnFlight(new int[]{90,85,75,10,120,150,125},250);
		for(int i:ans) System.out.println(i);
	}
}
