import java.util.*;

class Synonyms{
	private Map<String,Set<String>> map = new HashMap<>();
	
	public boolean[] returnSynonym(List<List<String>> sets,List<List<String>> sentences){
		constructMap(sets);
		boolean[] result=new boolean[sentences.size()];
		for(int i=0;i<result.length;i++) result[i]=true; 
		for(List<String> sentence:sentences){
			String[] s1=sentence.get(0).split(" ");
			String[] s2=sentence.get(1).split(" ");
			if(s1.length!=s2.length) result[sentences.indexOf(sentence)]=false;
			for(int i=0;i<s1.length;i++){
				if(!s1[i].equals(s2[i])){
					Set<String> setFirst=map.getOrDefault(s1[i], new HashSet<>());
					Set<String> setSecond=map.getOrDefault(s2[i], new HashSet<>());
					if(!setFirst.contains(s2[i])){
						if(!setSecond.contains(s1[i])){
							result[sentences.indexOf(sentence)]=false;
						}
					} 
				}
			}
		}
		return result;
	}	
	
	private void constructMap(List<List<String>> sets){
		for(List<String> set:sets){
			String first=set.get(0);
			String second=set.get(1);	
			if(!map.containsKey(first)){
				Set<String> firstSet=new HashSet<>();
				map.put(first, firstSet);
			}
			map.get(first).add(second);
		}
	}
		
	public static void main(String[] args){
		List<List<String>> sets=new ArrayList<>();
		sets.add(new ArrayList<>());
		sets.get(0).add("great");
		sets.get(0).add("good");
		sets.add(new ArrayList<>());
		sets.get(1).add("great");
		sets.get(1).add("excellent");
		sets.add(new ArrayList<>());
		sets.get(2).add("good");
		sets.get(2).add("fine");
		System.out.println(sets);
		List<List<String>> sentences=new ArrayList<>();
		sentences.add(new ArrayList<>());
		sentences.get(0).add("Google is a good company");
		sentences.get(0).add("Google is a great company");
		sentences.add(new ArrayList<>());
		sentences.get(1).add("My performance is bad");
		sentences.get(1).add("My performance is poor");
		System.out.println(sentences);

		Synonyms syn=new Synonyms();
		for(boolean b:syn.returnSynonym(sets, sentences)){
			System.out.println(b);
		}
	}
}
