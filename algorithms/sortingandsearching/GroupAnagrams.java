import java.util.*;
class GroupAnagrams{
	public List<List<String>> groupAnagrams(String[] strs){
		Map<String,List<String>> map=new HashMap<>();
		int[] count=new int[26];
		for(String s:strs){
			Arrays.fill(count,0);
			String string=encode(s,count);
			if(!map.containsKey(string)) map.put(string,new ArrayList<>());
			map.get(string).add(s);
		}
		return new ArrayList(map.values());
	}

	private String encode(String s,int[] count){
		for(char c:s.toCharArray()) count[c-'a']++;
		StringBuilder sb=new StringBuilder();
		for(int i:count){
			sb.append(i);
			sb.append('#');
		}
		return sb.toString();
	}

	public static void main(String[] args){
		GroupAnagrams ga=new GroupAnagrams();
		System.out.println(ga.groupAnagrams(new String[]{"eat","tea","tan","ate","bat","nat"}));
	}
}
			
			
