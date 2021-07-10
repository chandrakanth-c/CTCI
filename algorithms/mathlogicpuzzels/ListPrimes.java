import java.util.*;

/**
*This is also known as Sieve of Eratosthenes
*/
class ListPrimes{
	private boolean[] flags;

	public ListPrimes(int max){
		this.flags=new boolean[max+1];
		for(int i=2;i<max+1;i++){
			flags[i]=true;
		}
	}

	public List<Integer> getPrimes(){
		int prime=2;
		int max=flags.length-1;
		while(prime<=max){
			crossNonPrimes(flags,prime);
			prime=nextPrime(flags,prime);
		}
		List<Integer> res=new ArrayList<>();
		for(int i=0;i<flags.length;i++){
			if(flags[i]) res.add(i);
		}
		return res;
	}

	private void crossNonPrimes(boolean[] flags,int prime){
		for(int i=prime*prime;i<=flags.length-1;i+=prime){
			flags[i]=false;
		}
	}
	
	private int nextPrime(boolean[] flags,int prime){
		int next=prime+1;
		while(next<flags.length && !flags[next]) next++;
		return next;
	}

	public static void main(String[] args){
		ListPrimes lP=new ListPrimes(25);
		System.out.println(lP.getPrimes());
	}			
}
