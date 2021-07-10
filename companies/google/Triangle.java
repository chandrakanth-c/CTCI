/**
 * Logic is flawed come back to this laster
 */
import java.util.*;
class Triangle{
    private List<List<Integer>> triangle;
    private Map<String,Integer> memo;
    
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0) return 0;
        if(triangle.size()==1 && triangle.get(0).size()==1) return triangle.get(0).get(0);
        this.triangle=triangle;
        this.memo=new HashMap<>();
        return calMinPath(0,0,0);
    }
    
    private int calMinPath(int r,int c,int s){
        if(r==triangle.size()) return 0;
        if(r<triangle.size() && c<triangle.get(r).size() && memo.containsKey(getKey(r,c,s))) return memo.get(getKey(r,c,s));
        int min=0;
        if(s==0){
            for(int i=0;i<triangle.get(r).size();i++){
                int result=0;
                result+=triangle.get(r).get(i)+calMinPath(r+1,i,1);
                min=Math.max(result,min);   
            }
        }else{
            for(int i=c;i<Math.min(triangle.get(r).size(),c+2);i++){
                int result=0;
                result+=triangle.get(r).get(i)+calMinPath(r+1,i,1);
                min=Math.max(result,min);
            }
        }
        if(r<triangle.size() && c<triangle.get(r).size()) memo.put(getKey(r,c,s),min);
        return min;
    }
    
    private String getKey(int r,int c,int s){return r+" "+c+" "+s;}

    public static void main(String[] args) {
        Triangle tri=new Triangle();
        List<List<Integer>> input=new ArrayList<>();
        input.add(new ArrayList<>());
        input.get(0).add(1);
        input.add(new ArrayList<>());
        input.get(1).add(2);
        input.get(1).add(3);
        input.add(new ArrayList<>());
        input.get(2).add(1);
        input.get(2).add(5);
        input.get(2).add(1);
        int a=tri.minimumTotal(input);
        System.out.println(a);
    }
}