import java.util.*;

class CountWays{

	public int countWays(int n){
		int[] memo=new int[n+1];
		Arrays.fill(memo,-1);
		return calcWays(n,memo);
	}

	private int calcWays(int n,int[] memo){
		if(n<0) return -1;
		if(n==0) return 1;
		
		if(memo[n]==-1) memo[n]=calcWays(n-1)+calcWays(n-2)+calcWays(n-3);

		return memo[n];
	}

	public static void main(String[] args){
		CountWays cw=new CountWays();
		System.out.println(cw.countWays(3));
	}
}
