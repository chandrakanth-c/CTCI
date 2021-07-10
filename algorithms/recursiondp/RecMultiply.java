package algorithms.recursiondp;
import java.util.*;

class RecMultiply{

	public int recMul(int a,int b){
		Map<String,Integer> memo=new HashMap<>();
		int smaller=a<b?a:b;
		int bigger=a>b?a:b;
		return helper(smaller,bigger,memo);
	}

	private int helper(int smaller,int bigger,Map<String,Integer> memo){
		if(smaller==0) return 0;
		if(smaller==1) return bigger;

		if(memo.containsKey(getString(smaller,bigger))) return memo.get(getString(smaller,bigger));

		int s=smaller>>1;
		int side1=recMul(s,bigger);
		
		if(smaller%2==1){
			int result=(side1*2)+bigger;
			memo.put(getString(smaller,bigger),result);
			return result;
		}
		
		int result=side1*2;
		memo.put(getString(smaller,bigger),result);
		return result;
	}

	private String getString(int smaller,int bigger){
		return smaller+"_"+bigger;
	}

	public static void main(String[] args){
		RecMultiply rm=new RecMultiply();
		int res=rm.recMul(7,8);
		System.out.println(res);
	}
}
