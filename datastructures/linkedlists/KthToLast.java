/**
 * There are two solutions for this both iterative and recursive (check the commits)
 */
class KthToLast{
	
	public int returnfromLast(Node root,int k){
		if(root==null) return 0;
		Node p=root;
		Node q=p;
		for(int i=0;i<k;i++){
			if(q!=null) q=q.next;
		}

		while(q!=null){
			q=q.next;
			p=p.next;
		}

		return p.val;
	}

	public static void main(String[] args){
		SinglyLinkedList sl=new SinglyLinkedList(1);
		sl.appendTail(2);
		sl.appendTail(3);
		sl.appendTail(3);
		sl.appendTail(3);
		
		KthToLast k=new KthToLast();
		System.out.println(k.returnfromLast(sl.getRoot(), 5));
	}
}
