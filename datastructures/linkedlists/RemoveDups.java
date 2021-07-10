class RemoveDups {
	
    /**
     * Better solution is using a HashSet (refer CTCI)
     * @param root
     */
	public void removeDups(Node root){
		if(root==null) return;
		Node present=root;
		
		while(present!=null){
			Node runner=present;
			while(runner!=null && runner.next!=null){
				if(runner.next.val==present.val) runner.next=runner.next.next;
				else runner=runner.next;
			}
			present=present.next;
		} 
	}	
		
   	 public static void main(String[] args) {
        	SinglyLinkedList sl=new SinglyLinkedList(1);
        	sl.appendTail(2);
        	sl.appendTail(3);
            sl.appendTail(3);
            sl.appendTail(3);
            System.out.println("before");
        	sl.printList();

            RemoveDups rd=new RemoveDups();
            rd.removeDups(sl.getRoot());
            System.out.println("after");
            sl.printList();
   	 }
}
	
