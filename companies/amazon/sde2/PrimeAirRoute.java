package companies.amazon.sde2;
import java.util.*;
import java.util.stream.Collectors;

public class PrimeAirRoute {
    public List<Integer> primeRoute(int max,List<List<Integer>> flist,List<List<Integer>> blist){
        Map<Integer,Integer> map1=new HashMap<>();
        Map<Integer,Integer> map2=new HashMap<>();

        for(int i=0;i<flist.size();i++) map1.put(flist.get(i).get(1),flist.get(i).get(0));
        for(int i=0;i<blist.size();i++) map2.put(blist.get(i).get(1),blist.get(i).get(0));

        List<Integer> list1=new ArrayList<>();
        for(List<Integer> l:flist){
            list1.add(l.get(1));
        }
        
        List<Integer> list2=new ArrayList<>();
        for(List<Integer> l:blist){
            list2.add(l.get(1));
        }

        int i=0,j=0;
        Collections.sort(list1);
        Collections.sort(list2);

        int ans=0;
        List<Integer> res=new ArrayList<>();

        while(i<list1.size() && j<list2.size()){
            int first=list1.get(i);
            int second=list2.get(j);
            int temp=first+second;
            if(temp<=max){
                if(temp>ans){
                    ans=temp;
                    res.clear();
                    res.add(map1.get(first));
                    res.add(map2.get(second));
                }
                if(first<=second){
                    i++;
                }else{
                    j++;
                }
            }else{
                break;
            }
        }

        return res;
    }

    public static List<List<Integer>> getIdPairsForOptimal(List<List<Integer>> forwardList,
			List<List<Integer>> backwardList, int maxDistance) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		forwardList = forwardList.stream().sorted((x1, x2) -> Integer.compare(x2.get(1), x1.get(1)))
				.collect(Collectors.toList());
		backwardList = backwardList.stream().sorted((x1, x2) -> Integer.compare(x1.get(1), x2.get(1)))
				.collect(Collectors.toList());
		int maxDist = maxDistance;
		while (true) {
			for (List<Integer> l : forwardList) {
				for (List<Integer> b : backwardList) {
					int forward = l.get(1);
					int backward = b.get(1);
					int tot = (forward + backward);
					if (tot > maxDist) {
						break;
					}
					if (tot == maxDist) {
						// print the pair of Id and optimum distance
						result.add(Arrays.asList(l.get(0), b.get(0), maxDist));
						break;
					}

				}
			}
			if (result.size() > 0) {
				break;
			}
			maxDist--;
		}
		return result;
	}

    public static void main(String[] args) {
        PrimeAirRoute pr=new PrimeAirRoute();
        List<List<Integer>> flist=new ArrayList<>();
        flist.add(new ArrayList<>());
        flist.get(0).add(1);
        flist.get(0).add(3000);
        flist.add(new ArrayList<>());
        flist.get(1).add(2);
        flist.get(1).add(5000);
        flist.add(new ArrayList<>());
        flist.get(2).add(3);
        flist.get(2).add(4000);
        flist.add(new ArrayList<>());
        flist.get(3).add(4);
        flist.get(3).add(10000);

        List<List<Integer>> blist=new ArrayList<>();
        blist.add(new ArrayList<>());
        blist.get(0).add(1);
        blist.get(0).add(2000);
        blist.add(new ArrayList<>());
        blist.get(1).add(2);
        blist.get(1).add(3000);
        blist.add(new ArrayList<>());
        blist.get(2).add(3);
        blist.get(2).add(4000);

        System.out.println(pr.getIdPairsForOptimal(flist, blist,11000));
    }
}
