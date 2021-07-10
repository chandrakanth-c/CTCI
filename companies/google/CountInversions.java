class CountInversions{
	
	public int countInversions(int[] arr){
		return recCountInversions(arr,new int[arr.length],0,arr.length-1);
	}
	
	private int recCountInversions(int[] arr,int[] temp,int lo,int hi){
		if(lo>=hi) return 0;
		int mid=(lo+hi)/2;
		int leftInversions=recCountInversions(arr,temp,lo,mid);
		int rightInversions=recCountInversions(arr,temp,mid+1,hi);
		int iterationInvCount=inversionCount(arr,temp,lo,hi);
		return leftInversions+rightInversions+iterationInvCount;
	}

	private int inversionCount(int[] arr,int[] temp,int leftStart,int rightEnd){
		int inversions=0;
		int leftEnd=(leftStart+rightEnd)/2;
		int lp=leftStart;
		int rp,rightStart;
		rp=rightStart=leftEnd+1;
		for(int i=0;i<=rightEnd-leftStart;i++){
			if(lp>leftEnd){
				temp[leftStart+i]=arr[rp++];
			}else if(rp>rightEnd){
				temp[leftStart+i]=arr[lp++];
			}else{
				if(arr[lp]<arr[rp]){
					temp[leftStart+i]=arr[lp++];
				}else{
					temp[leftStart+i]=arr[rp++];
					inversions+=rightStart-lp;
				}
			}
		}
		System.arraycopy(temp,leftStart,arr,leftStart,rightEnd-leftStart+1);
		return inversions;
	}	
	
	public static void main(String[] args){
		CountInversions cI=new CountInversions();
		int res=cI.countInversions(new int[]{5,4,3,2,1});
		System.out.println(res);
	}
}
