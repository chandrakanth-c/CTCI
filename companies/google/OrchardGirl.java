import java.util.HashMap;
import java.util.*;

public class OrchardGirl {

    public int logestPortion(int[] arr){
        if(arr.length==0) return 0;
        Map<Integer,Integer> map=new HashMap<>();
        int start=0,end=0,count=0;
        while(end<arr.length){
            if(map.get(arr[end])!=null){
                map.put(arr[end],map.get(arr[end])+1);
            }else{
                map.put(arr[end],1);
            }

            while(map.keySet().size()>2){
                if(count<end-start){
                    count=end-start;
                }
                if(map.get(arr[start])>1){
                    map.put(arr[start],map.get(arr[start])-1);
                }else{
                    map.remove(arr[start]);
                }
                start++;
            }

            end++;
        }
        return count;
    }
    public static void main(String[] args) {
        OrchardGirl og=new OrchardGirl();
        int count=og.logestPortion(new int[]{2,1,2,3,3,1,3,5});
        System.out.println(count);
    }
}
