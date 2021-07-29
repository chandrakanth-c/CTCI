class FindDuplicates{
	
	class BitSet{
	
		int[] bitset;
	
		public BitSet(int size){
			this.bitset=new int[(size>>5)+1];
		}

		public boolean get(int pos){
			int wordcount=pos>>5;
			int poscount=pos & 0x1F;
			return (bitset[wordcount] & (1<<poscount))!=0;
		}

		public void set(int pos){
			int wordcount=pos>>5;
			int poscount=pos & 0x1F;
			bitset[wordcount] |= (1<<poscount);
		}
	}

	public void find(int[] arr){
		BitSet bs=new BitSet(32000);
		for(int i=0;i<arr.length;i++){
			int num0=arr[i]-1;
			if(bs.get(num0)) System.out.println(num0+1);
			else bs.set(num0);
		}
	}

	public static void main(String[] args){
		FindDuplicates fd=new FindDuplicates();
		int[] arr=new int[32000];
		int i=1;
		while(i<31000){
			arr[i-1]=i;
			i++;
		}
		arr[i]=4;
		fd.find(arr);
	}
}

