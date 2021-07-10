class DeleteMNode{
	public boolean delMNode(Node n){
		if(n==null || n.next==null) return false;
		Node next=n.next;
		n.val=next.val;
		n.next=n.next.next;
		return true;
	}
	public static void main(String[] args){
		SinglyLinkedList sl=new SinglyLinkedList(1);
		sl.appendTail(2);
		sl.appendTail(3);
		sl.appendTail(3);
		sl.appendTail(3);
		System.out.println("Before");
		sl.printList();

		Node n=sl.getRoot().next;

		DeleteMNode d=new DeleteMNode();
		boolean b=d.delMNode(n);
		System.out.println("After "+b);
		sl.printList();
	}
}
