class ListIntersection{
	public Node intersectedNode(Node headA,Node headB){
		int len1=getLen(headA);
		int len2=getLen(headB);
		
		if(len1<len2){
			headA=addFirst(headA,len2-len1);
		}else if(len2<len1){
			headB=addFirst(headB,len1-len2);
		}

		while(headA!=null && headB!=null){
			if(headA==headB) return headA;
			headA=headA.next;
			headB=headB.next;
		}

		return null;
	}

	private Node addFirst(Node node,int no){
		for(int i=0;i<no;i++){
			Node n=new Node(node.val);
			n.next=node;
			node=n;
		}
		return node;
	}

	private int getLen(Node node){
		int count=0;
		while(node!=null){
			node=node.next;
			count++;
		}
		return count;
	}
	
	public static void main(String[] args){
		Node intNode=new Node(5);

		Node headA=new Node(1);
		headA.next=new Node(2);
		headA.next.next=intNode;
		headA.next.next.next=new Node(3);

		Node headB=new Node(1);
		headB.next=intNode;
		headB.next.next=new Node(7);

		Node res=new ListIntersection().intersectedNode(headA,headB);
		
		while(res!=null){
			System.out.println(res.val);
			res=res.next;
		}
	}
}
