package algorithms.recursiondp;
class MagicIndex{

	public int magicIndex(int[] arr){
		return getMagicIndex(arr,0,arr.length-1);
	}

	private int getMagicIndex(int[] arr,int lo,int hi){
		int mid=(lo+hi)/2;
		
		if(arr[mid]==mid) return mid;

		//recursively search the left half
		int leftIndex=Math.min(arr[mid],mid-1);
		if(leftIndex>0) return getMagicIndex(arr,lo,leftIndex);

		//recursively search the right half
		int rightIndex=Math.max(arr[mid],mid+1);
		if(rightIndex<arr.length-1) return getMagicIndex(arr,rightIndex,hi);

		return -1;
	}

	public static void main(String[] args){
		MagicIndex mI=new MagicIndex();
		int index=mI.magicIndex(new int[]{-10,-5,2,2,2,3,4,7,9,12,13});
		System.out.println(index);
	}
}
