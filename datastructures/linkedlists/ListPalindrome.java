class ListPalindrome{

	public boolean isPalindrome(Node node){
		Node reversedNode=reverseAndClone(node);
		return isEqual(node,reversedNode);
	}

	private Node reverseAndClone(Node node){
		Node n=null;
		Node p=node;
		while(p!=null){
			Node newN=new Node(p.val);
			newN.next=n;
			n=newN;
			p=p.next;
		}
		return n;
	}

	private boolean isEqual(Node one,Node two){
		while(one!=null && two!=null){
			if(one.val!=two.val) return false;
			one=one.next;
			two=two.next;
		}
		return true;
	}

	public static void main(String[] args){
		Node node=new Node(1);
		node.next=new Node(2);
		node.next.next=new Node(1);

		System.out.println(new ListPalindrome().isPalindrome(node));
	}
}
