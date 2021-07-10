package algorithms.recursiondp;
class TOI{

	public static void toi(int n,char src,char dest,char aux){
		if(n==1){
			System.out.println("Moving disc "+n+" from "+src+" to "+dest);
			return;
		}

		toi(n-1,src,aux,dest);
		System.out.println("Moving disc "+n+" from "+src+" to "+dest);
		toi(n-1,aux,dest,src);
	}

	public static void main(String[] args){
		toi(3,'A','B','C');
	}
} 
