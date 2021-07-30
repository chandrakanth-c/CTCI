class RankFromStream{
	class Node{
		int data;
		Node left;
		Node right;
		int leftSize;
		public Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
			this.leftSize=0;
		}
	}

	private Node root;

	public RankFromStream(){
		this.root=null;
	}

	public Node createNode(int data){
		Node node=new Node(data);
		return node;
	}

	public void track(int x){
		root=createBST(root,x);
	}

	private Node createBST(Node root,int x){
		if(root==null) return createNode(x);
		if(x<=root.data){
			root.left=createBST(root.left,x);
			root.leftSize++;
		}else{
			root.right=createBST(root.right,x);
		}
		return root;
	}

	public int getRankOfANo(int x){
		return getRank(root,x);
	}

	private int getRank(Node root,int x){
		if(root==null) return -1;
		if(root.data==x) return root.leftSize;
		int rank=-1;
		if(x<root.data){
			rank=getRank(root.left,x);
		}else{
			if(getRank(root.right,x)==-1) return -1;
			rank=getRank(root.right,x)+root.leftSize+1;
		}
		return rank;
	}

	void print(Node root){
		if(root==null) return;
		print(root.left);
		System.out.println(root.data);
		print(root.right);
	}

	public static void main(String[] args){
		RankFromStream rfs=new RankFromStream();
		int arr[]={10,20,15,3,4,4,1};
		for(int i:arr) rfs.track(i);
		rfs.print(rfs.root);
		System.out.println(rfs.getRankOfANo(25));
	}
}
