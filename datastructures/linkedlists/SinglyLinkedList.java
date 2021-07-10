class SinglyLinkedList{
	private Node root;

	public SinglyLinkedList(int d){
		Node node=new Node(d);
		this.root=node;
	}
	
	public SinglyLinkedList(){
		this.root=null;
	}	

	public void appendTail(int d){
		if(root==null){
			root=new Node(d);
			return;
		}
		Node p=root;
		while(p.next!=null){
			p=p.next;
		}
		p.next=new Node(d);
	}
	
	public Node delAtNode(int d){
		Node p=root;
		
		while(p.next!=null){
			if(p.next.val==d){
				p.next=p.next.next;
			}
		}
		return root;
	}

	public void printList(){
		Node p=root;
		while(p!=null){
			System.out.println(p.val);
			p=p.next;
		}
	}

	public Node getRoot(){
		return this.root;
	}
	
}

class Node{
	int val;
	Node next;
	public Node(int val){
		this.val=val;
		this.next=null;
	}
}

