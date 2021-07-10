class BubbleSort{
	public void sort(int[] arr){
		int n=arr.length;
		boolean swapped=false;
		for(int i=0;i<n-1;i++){
			for(int j=0;j<n-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapped=true;
				}
			}
			if(swapped==false) break;
		}
	}

	public static void main(String[] args){
		BubbleSort bs=new BubbleSort();
		int arr[]=new int[]{1,2,3,4};
		bs.sort(arr);
		for(int i=0;i<arr.length;i++) System.out.println(arr[i]);
	}
}	
