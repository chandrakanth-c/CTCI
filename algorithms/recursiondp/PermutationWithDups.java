package algorithms.recursiondp;
import java.util.*;

class PermutatioWithDups{

	public List<String> permutationString(String string){
		List<String> result=new ArrayList<>();
	    	Map<Character,Integer> map=new HashMap<>();
		createMap(string,map);
		getPermutation("",string.length(),result,map);
		return result;
	}

	private void createMap(String s,Map<Character,Integer> map){
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(map.containsKey(c)){
				int count=map.get(c);
				map.put(c,count+1);
			}else{
				map.put(c,1);
			}
		}
	}

	private void getPermutation(String prefix,int length,List<String> result,Map<Character,Integer> map){
		if(length==0){
			result.add(prefix);
			return;
		}

		for(Character c:map.keySet()){
			if(map.get(c)>0){
				map.put(c,map.get(c)-1);
				getPermutation(prefix+c,length-1,result,map);
				map.put(c,map.get(c)+1);
			}
		}
	}

	public static void main(String[] args){
		PermutatioWithDups p=new PermutatioWithDups();
		System.out.println(p.permutationString("aab"));
	}
}
					

				
