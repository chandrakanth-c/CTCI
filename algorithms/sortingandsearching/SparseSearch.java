class SparseSearch{
	public int search(String[] arr,String s){
		int lo=0,hi=arr.length-1;
		
		while(lo<=hi){
			int mid=findMid(arr,lo,hi);
			if(arr[mid].equals(s)) return mid;
			else if(arr[mid].compareTo(s)<0) lo=mid+1;
			else hi=mid-1;
		}

		return -1;
	}

	private int findMid(String[] arr,int lo,int hi){
		int mid=(lo+hi)/2;
		if(!arr[mid].equals("")) return mid;
	
		while(true){
			int left=mid-1;
			int right=mid+1;
			
			if(left<lo && right>hi) return -1;
			if(left>=lo && !arr[left].equals("")) return left;
			if(right<=hi && !arr[right].equals("")) return right;
		
			left--;
			right++;
		}
	}

	public static void main(String[] args){
		SparseSearch ss=new SparseSearch();
		String[] arr=new String[]{"at","","","","ball","","","car","","","dar","",""};
		System.out.println(ss.search(arr,"ball"));
	}
}
