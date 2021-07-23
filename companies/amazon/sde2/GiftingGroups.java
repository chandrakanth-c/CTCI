/**
 * This algorithm is flawed refer to the one in leetcode discuss
 */
package companies.amazon.sde2;
import java.util.*;

public class GiftingGroups {

    private int count=0;
    
    public int giftingGroups(List<String> list){
        Map<Integer,List<Integer>> graph=new HashMap<>();
        createGraph(list,graph);
        System.out.println(graph);
        int n=list.size();
        return countGroups(graph,n);
    }

    private int countGroups(Map<Integer,List<Integer>> graph,int n){
        boolean[] visited=new boolean[n];
        for(int i:graph.keySet()){
            if(!visited[i]){
                count++;
                dfs(graph,visited,i);
            }
        }
        return count;
    }

    private void dfs(Map<Integer,List<Integer>> graph,boolean[] visited,int node){
        visited[node]=true;
        List<Integer> children=graph.get(node);
        if(children!=null){
            for(int i:children){
                if(!visited[i]){
                    dfs(graph,visited,i);
                }
            }
        }
    }

    private void createGraph(List<String> list,Map<Integer,List<Integer>> graph){
        for(int i=0;i<list.size();i++){
            graph.put(i,new ArrayList<>());
        }

        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).length();j++){
                if(i!=j && list.get(i).charAt(j)=='1'){
                    graph.get(i).add(j);
                }
            }
        }
    }

    public static void main(String[] args) {
        GiftingGroups gg=new GiftingGroups();

        String given1[] = {"110", "110", "011"}; //2
        String given2[] = {"1100", "1101", "0010", "0010", "0001"}; //2
        String given3[] = {"110", "111", "011"}; //1
    
    
        String arr1[] = {"1100", "1110", "0110", "0001"};//2
        String arr2[] = {"10000", "01000", "00100", "00010", "00001"};//5
        String arr3[] = {"1100", "1101", "0010", "0010", "0001"};//2
        String arr4[] = {"1100", "1101", "0010", "0010", "0001"};//2
        String arr5[] = {"11100", "11001", "10100", "00011", "01011"};//1
        String arr6[] = {"11100", "11100", "11100", "00011", "00011"};//2
        String arr7[] = {"10100", "01010", "10100", "01010", "00001"};//3
    
        List<String> arrayList = Arrays.asList(arr7);
        int result = gg.giftingGroups(arrayList);
        System.out.println(result);
    }
}
