class SearchRotatedArray{
	public int search(int[] nums,int target){
		int lo=0,hi=nums.length-1;
		while(lo<=hi){
			int mid=(lo+hi)/2;
			if(nums[mid]==target) return mid;
			
			if(nums[lo]<=nums[mid]){
				if(target>=nums[lo] && target<=nums[mid]){
					hi=mid-1;
				}else{
					lo=mid+1;
				}
			}else{
				if(target>=nums[mid] && target<=nums[hi]){
					lo=mid+1;
				}else{
					hi=mid-1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args){
		SearchRotatedArray sr=new SearchRotatedArray();
		System.out.println(sr.search(new int[]{3,4,5,1,2},2));
	}
}	
