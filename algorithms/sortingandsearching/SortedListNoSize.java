class SortedListNoSize{
	public int search(ArrayReader reader, int target) {
           	int lo=0,hi=1;
       		while(reader.get(hi)<target){
           		hi*=2;
           		lo=hi;
       		 }
       		 return bs(reader,0,hi,target);
   	 }
    
    	private int bs(ArrayReader ar,int lo,int hi,int target){
        	while(lo<=hi){
            		int mid=(lo+hi)/2;
            		if(ar.get(mid)==target){
                		return mid;
            		}else if(ar.get(mid)>target){
                		hi=mid-1;
            		}else{
                		lo=mid+1;
            		}
        	}
        	return -1;
   	 }
}	
