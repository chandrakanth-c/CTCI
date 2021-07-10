import java.util.*;
class PowerSet{
	public List<List<Integer>> powerSet(int[] nums){
		List<List<Integer>> result=new ArrayList<>();
		int[] temp=new int[nums.length];
		genSubSeq(nums,temp,result,0);
		return result;
	}

	private void genSubSeq(int[] nums,int[] temp,List<List<Integer>> result,int n){
		List<Integer> tempRes;
		if(n==nums.length){
			tempRes=new ArrayList<>();
			for(int i=0;i<temp.length;i++){
				if(temp[i]==1) tempRes.add(nums[i]);
			}
			result.add(tempRes);
			return;
		}
		for(int i=0;i<2;i++){
			temp[n]=i;
			genSubSeq(nums,temp,result,n+1);
		}
	}		

	public static void main(String[] args){
		PowerSet ps=new PowerSet();
		List<List<Integer>> list=ps.powerSet(new int[]{1,2,3});
		System.out.println(list);
	}
}
