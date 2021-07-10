package algorithms.recursiondp;
import java.util.*;

class BooleanEvaluation{

	Map<String,Integer> memo=new HashMap<>();

	public int boolEval(String s,boolean result){
		//base case
		if(s.length()==0) return 0;
		if(s.length()==1) return s.equals("0")?0:1;

		if(memo.containsKey(result+s)) return memo.get(result+s);

		//figuring out k loop
		int ways=0;
		for(int k=1;k<s.length();k=k+2){
			String first=s.substring(0,k-1);
			String second=s.substring(k+1,s.length());
			
			//breaking down the problems into subproblems
			int subways=0;
			
			int lF=boolEval(first,false);
			int lT=boolEval(first,true);
			int rF=boolEval(second,false);
			int rT=boolEval(second,true);

			int total=(lF*lT)+(rF*rT);

			char op=s.charAt(k);
			int totalTrue=0;
			if(op=='|'){
				totalTrue=(lT*rF)+(lF*rT)+(lT*rT);
			}else if(op=='*'){
				totalTrue=(lT*rT)+(lF*rF);
			}else{
				totalTrue=(lT*rF)+(lF*rT);
			}

			subways=totalTrue==1?totalTrue:total-totalTrue;

			
			//merging all the subproblems result which leads to the result of the main problem
			ways+=subways;
		}
		
		memo.put(result+s,ways);
		return ways;
	}

	public static void main(String[] args){
		BooleanEvaluation bE=new BooleanEvaluation();
		int a=bE.boolEval("1&0|1^1",true);
		System.out.println(a);
	}
}

	
