class SortedMerge{
	public void sortedMerge(int[] arr1,int[] arr2,int first,int second){
		int lastidx=first+second-1;
		int i=first-1,j=second-1;
		System.out.println(lastidx+" "+i+" "+j+" ");
		while(lastidx>=0 && i>=0 && j>=0){
			if(arr1[i]>arr2[j]){
				arr1[lastidx]=arr1[i];
				i--;
			}else{
				arr1[lastidx]=arr2[j];
				j--;
			}
			lastidx--;
		}
	}


	public static void main(String[] args){
		SortedMerge sm=new SortedMerge();
		int[] arr1={1,3,7,9,0,0,0,0};
		int[] arr2={2,4,6,8};
		sm.sortedMerge(arr1,arr2,4,4);
		for(int i:arr1) System.out.println(i);
	}
} 
