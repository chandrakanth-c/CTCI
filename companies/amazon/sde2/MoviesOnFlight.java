//There is a slight change in the solution where in we have to return the original index and not the modified index by the sort function
/**
 * You are on a flight and wanna watch two movies during this flight.
You are given List<Integer> movieDurations which includes all the movie durations.
You are also given the duration of the flight which is d in minutes.
Now, you need to pick two movies and the total duration of the two movies is less than 
or equal to (d - 30min).

Find the pair of movies with the longest total duration and return they indexes. 
If multiple found, return the pair with the longest movie.

Example 1:

Input: movieDurations = [90, 85, 75, 60, 120, 150, 125], d = 250
Output: [0, 6]
Explanation: movieDurations[0] + movieDurations[6] = 90 + 125 = 215 is the maximum number 
within 220 (250min - 30min)
 */
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
