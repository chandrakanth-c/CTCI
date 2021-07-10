class LoopDetection{
	public boolean loopDetection(Node node){
		if(node==null) return false;
		Node slow=node;
		Node fast=node.next;
		while(slow!=null && fast!=null && fast.next!=null){
			if(slow==fast) return true;
			slow=slow.next;
			fast=fast.next.next;
		}
		return false;
	}

	public static void main(String[] args){
		Node node=new Node(1);
		node.next=new Node(2);
		node.next=node;

		System.out.println(new LoopDetection().loopDetection(node);
	}
}
