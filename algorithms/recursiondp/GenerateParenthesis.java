package algorithms.recursiondp;
import java.util.*;
class GenerateParenthesis{

	public Set<String> genParen(int rem){
		Set<String> set=new HashSet<>();
		if(rem==0){
			set.add("");
		}else{
			Set<String> prev=genParen(rem-1);
			for(String s:prev){
				for(int i=0;i<s.length();i++){
					if(s.charAt(i)=='('){
						String string= insertParen(s,i);
						set.add(string);
					}
				}
				set.add("()"+s);
			}
		}
		
		return set;
	}


	private String insertParen(String s,int i){
		String first=s.substring(0,i+1);
		String last=s.substring(i+1);
		return first+"()"+last;
	}

	public static void main(String[] args){
		GenerateParenthesis gp=new GenerateParenthesis();
		System.out.println(gp.genParen(3));
	}
}
			
