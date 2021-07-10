class SelectionSort{
	public void sort(int[] arr){
		for(int i=0;i<arr.length;i++){
			int min_index=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[min_index]) min_index=j;
			}
			if(min_index!=i){
				int temp=arr[i];
				arr[i]=arr[min_index];
				arr[min_index]=temp;
			}
		}
	}

	public static void main(String[] args){
		SelectionSort ss=new SelectionSort();
		int[] arr=new int[]{4,3,1,2};
		ss.sort(arr);
		for(int i=0;i<arr.length;i++) System.out.println(arr[i]);
	}
}
