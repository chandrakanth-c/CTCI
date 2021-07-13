package companies.amazon.sde2;

class KthBinary{

	public int kthBinary(String s,int n,int k){
		for(int i=0;i<n-1;i++){
			StringBuilder sb=new StringBuilder();
			for(int j=0;j<s.length();j++){
				if(s.charAt(j)=='1'){
					sb.append("10");
				}else{
					sb.append("01");
				}
			}
			s=sb.toString();
		}
		return Integer.parseInt(String.valueOf(s.charAt(k-1)));
	}

	public static void main(String[] args){
		KthBinary k=new KthBinary();
		System.out.println(k.kthBinary("101",4,7));
	}
}
		 
