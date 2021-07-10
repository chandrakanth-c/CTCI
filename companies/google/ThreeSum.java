import java.util.*;

class ThreeSum{
	public List<List<Integer>> threeSum(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> res=new ArrayList<>();
		for(int i=0;i<nums.length;i++){
			if(i==0 || nums[i]!=nums[i-1]){
				twoSum(nums,res,i);
			}
		}
		return res;
	}
	
	private void twoSum(int[] nums,List<List<Integer>> res,int start){
		int lo=start+1,hi=nums.length-1;
		while(lo<hi){
			int sum=nums[start]+nums[lo]+nums[hi];
			if(sum<0){
				lo++;
			}else if(sum>0){
				hi--;
			}else{
				res.add(Arrays.asList(nums[start],nums[lo++],nums[hi--]));
				while(lo<hi && nums[lo]==nums[lo-1]) lo++;	
			}
		}
	} 
	public static void main(String[] args){
		ThreeSum ts=new ThreeSum();
		System.out.println(ts.threeSum(new int[]{-1,0,1,2,-1,4}));
	}
}
