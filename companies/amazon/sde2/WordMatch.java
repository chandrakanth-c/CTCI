/**
 * Given word and dictionary of words, search the word in dictionary such that, more than one occurances can be skipped while matching.

Examples below :

example 1 :

word = "lleeetttcooodddee"
dictionary = ["letcode", "leettccf", "lleetcode", "leetcod"]

output : true
example 2 :

word = "lleeetttcooodddee"
dictionary = ["leettccf", "lleetcode", "leetcod"]

output : true
example 3 :

word = "lleeetttcooodddee"
dictionary = ["leettccf", "leetcod"]

output : false

Note:This is not the optimal solution for this problem

 */
package companies.amazon.sde2;
import java.util.*;

public class WordMatch {
    
    public String wordInDictionary(String word,List<String> dict){
        for(String s:dict){
            if(word.charAt(0)!=s.charAt(0)) continue;
            int j=1;
            boolean equal=true;
            for(int i=1;i<word.length();i++){
                if(word.charAt(i)!=s.charAt(j)){
                    if(word.charAt(i)!=word.charAt(i-1)) break;
                }
                if(word.charAt(i)==s.charAt(j)){
                    j++;
                }
                if(j==s.length()){
                    for(int z=i+1;z<word.length();z++){
                        if(word.charAt(z)!=word.charAt(z-1)){
                            equal=false;
                            break;
                        }
                    }
                    break;
                }
            }
            if(j==s.length() && equal) return s;
        }
        return "";
    }

    public static void main(String[] args){
        WordMatch wm=new WordMatch();
        List<String> list=new ArrayList<>();
        list.add("letcode");
        list.add("leettccf");
        list.add("lleetcode");
        list.add("leetcod");
        String s=wm.wordInDictionary("lleeetttcooodddee", list);
        System.out.println(s);
    }
}
