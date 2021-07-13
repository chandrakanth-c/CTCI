package companies.amazon.sde2;
import java.util.*;

public class NFeatureRequests{
	class Request{
		String name;
		int count;
		
		public Request(String name,int count){
			this.name=name;
			this.count=count;
		}
	}

	public List<String> frequentReq(int numFeatures,int topFeatures,List<String> possibleFeatures,int numFeatureReq,List<String> req){
		List<Request> res=new ArrayList<>();
		connstructFreqList(res,possibleFeatures);
		for(String r:req){
			for(String f:possibleFeatures){
				if(r.contains(f)){
					Request rq=getRequest(res,f);
					rq.count+=1;
				}
			}
		}

		Comparator<Request> cmp=new Comparator<Request>(){
			@Override
			public int compare(Request r1,Request r2){
				if(r1.count==r2.count){
					return r1.name.compareTo(r2.name);
				}else{
					return r2.count-r1.count;
				}
			}
		};

		Collections.sort(res,cmp);
		List<String> result=new ArrayList<>();
		if(topFeatures<possibleFeatures.size()){
			for(int i=0;i<topFeatures;i++){
				result.add(res.get(i).name);
			}
		}else{
			for(Request r:res){
				result.add(r.name);
			}
		}

		return result;
	}

	private void connstructFreqList(List<Request> res,List<String> possibleFeatures){
		for(String s:possibleFeatures){
			res.add(new Request(s,0));
		}
	}

	private Request getRequest(List<Request> res,String f){
		for(Request req:res){
			if(req.name.equals(f)){
				return req;
			}
		}
		return null;
	}
	
	public static void main(String[] args){
		NFeatureRequests n=new NFeatureRequests();
		List<String> possibleFeature=new ArrayList<>();
		possibleFeature.add("storage");
		possibleFeature.add("battery");
		possibleFeature.add("hover");
		possibleFeature.add("alexa");
		possibleFeature.add("waterproof");
		possibleFeature.add("solar");
		List<String> featureReq=new ArrayList<>();
		featureReq.add("I wish my Kindle had more storage");
		featureReq.add("I wish battery life on Kindle lasted 2 years");
		featureReq.add("I read in the bath and would enjoy a waterproof Kindle");
		featureReq.add("Waterproof and increased battery are my top two requests");
		featureReq.add("I want to take my Kindle into the shower. Waterproof please waterproof!");
		featureReq.add("It would be neat if my Kindle would hover on my desk when not in use");
		featureReq.add("How cool would it be if my Kindle charged in the sun via solar power");
		System.out.println(n.frequentReq(6,2,possibleFeature,7,featureReq));
		featureReq.add("I wish my Kindle had more storage");
	}
}


