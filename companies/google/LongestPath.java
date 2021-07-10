import java.util.*;

public class LongestPath{

	public Node root;
	public Node prevNode;
	public String res="";
	
	class Node{
		List<Node> children;
		String name;
		public Node(String name){
			this.name=name;
			this.children=new ArrayList<>();
		}
	}
	
	public int longestPath(String s,String fileName){
		if(s.length()==0) return 0;
		String[] stringArr=s.split("\n\t");
		this.root=new Node(stringArr[0]);
		constructNArrTree(stringArr);
		String result="";
		dfs(root,fileName,result);
		return this.res.length()-1;
	}
	
	private void constructNArrTree(String[] stringArr){
		for(int i=1;i<stringArr.length;i++){
			Node node=null;
			if(stringArr[i].charAt(0)=='\t'){
				int j=0;
				while(stringArr[i].charAt(j)=='\t') j++;
				node=new Node(stringArr[i].substring(j));
				this.prevNode.children.add(node);
				this.prevNode=node;
			}else{
				node =new Node(stringArr[i]);
				this.root.children.add(node);
				this.prevNode=node;
			}
		}
	}
	
	private void dfs(Node root,String name,String result){
		if(root==null) return;
		result+=root.name+"/";
		if(root.name.equals(name)){
			this.res=result;
		}
		for(Node n:root.children) dfs(n,name,result);
	}

	private void displayTree(Node root){
		if(root==null) return;
		for(Node s:root.children) {
			displayTree(s);
		}
	}

	public Node getRoot(){
		return this.root;
	}

	public static void main(String[] args){
		LongestPath lP=new LongestPath();
		lP.displayTree(lP.getRoot());
		int res=lP.longestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext","file2.ext");
		System.out.println(res);
	}
}			
	
		 
