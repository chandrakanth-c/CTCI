class SumLists{
	public Node backwardSum(Node s1,Node s2){
		Node p1=s1,p2=s2,result=new Node(-1),curr=result;;
		int carry=0;
		while(p1!=null || p2!=null){
			int a=p1!=null?p1.val:0;
			int b=p2!=null?p2.val:0;
			int sum=a+b+carry;
			carry=sum/10;
			sum=sum%10;
			curr.next=new Node(sum);
			curr=curr.next;
			p1=p1.next;
			p2=p2.next;
		}
		
		if(carry!=0) curr.next=new Node(carry);

		return result.next;
	}

	public Node forwardSum(Node s1,Node s2){
		int lens1=getLen(s1);
		int lens2=getLen(s2);
		
		if(lens1<lens2){
			pad(s1,lens2-lens1);
		}else if(lens2<lens1){
			pad(s2,lens1-lens2);
		}

		PartialSum sum=addHelper(s1,s2);

		if(sum.carry!=0){
			addFirst(sum.node,sum.carry);
			return sum.node;
		}else{
			return sum.node;
		}	
	}
	
	public PartialSum addHelper(Node n1,Node n2){
		if(n1==null && n2==null){
			PartialSum ps=new PartialSum();
			ps.carry=0;
			ps.node=null;
			return ps;
		}

		PartialSum sum=addHelper(n1.next,n2.next);

		int digit=n1.val+n2.val+sum.carry;

		sum.carry=digit/10;
		digit=digit%10;
		addFirst(sum.node,digit);

		return sum;
	}


	public void addFirst(Node node,int no){
		Node newNode=new Node(no);
		if(node!=null) newNode.next=node;
		node=newNode;
	}	

	public void pad(Node node,int no){
		for(int i=0;i<no;i++){
			addFirst(node,0);
		}
	}

	public int getLen(Node node){
		int count=0;
		Node p=node;
		while(p!=null){
			p=p.next;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		Node s1=new Node(3);
		s1.next=new Node(2);
		s1.next.next=new Node(1);


		Node s2=new Node(7);
		s2.next=new Node(5);
		s2.next.next=new Node(4);

		Node res=new SumLists().forwardSum(s1,s2);
		
		while(res!=null){
			System.out.println(res.val);
			res=res.next;
		}

		
	}
}

class PartialSum{
	public Node node;
	public int carry;
}	
