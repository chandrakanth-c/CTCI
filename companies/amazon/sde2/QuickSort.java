package companies.amazon.sde2;
class QuickSort{

	private int swapCount=0;

	public void sort(int[] arr,int l,int h){
		if(l<h){
			int pi=partition(arr,l,h);
			sort(arr,l,pi-1);
			sort(arr,pi+1,h);
		}
	}

	public int partition(int[] arr,int l,int h){
		int pivot=arr[h];
		int i=l-1;
		for(int j=l;j<=h-1;j++){
			if(arr[j]<pivot){
				i++;
				swap(arr,i,j);
				swapCount++;
			}
		}
		swap(arr,i+1,h);
		swapCount++;
		return i+1;
	}

	private void swap(int[] arr,int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	public static void main(String[] args){
		QuickSort qs=new QuickSort();
		int[] arr=new int[]{5,1,4,2};
		qs.sort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++) System.out.println(arr[i]);
		System.out.println("Swap count");
		System.out.println(qs.swapCount);
	}
}
