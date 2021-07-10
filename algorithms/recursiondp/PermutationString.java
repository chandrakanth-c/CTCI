import java.util.*;
class PermutationString{
	
	public List<String> getPermut(String input){
		List<String> permutations=new ArrayList<>();
		if(input.length()==0){
			permutations.add("");
			return permutations;
		}
		String first=input.substring(0,1);
		String remainder=input.substring(1);
		List<String> words=getPermut(remainder);
		for(String word:words){
			for(int i=0;i<=word.length();i++){
				String s=insertCharAt(word,i,first);
				permutations.add(s);
			}
		}
		return permutations;
	}
	
	private String insertCharAt(String word,int i,String first){
		String start=word.substring(0,i);
		String end=word.substring(i);
		return start+first+end;
	}
	
	public static void main(String[] args){
		PermutationString ps=new PermutationString();
		System.out.println(ps.getPermut("abc"));
	}
}
