class RectangleOverlap{
	public boolean isOverlap(int[] rec1,int[] rec2){
		//checking if it is a line
		if(rec1[0]==rec1[2] || rec1[1]==rec1[3] || rec2[0]==rec2[2] || rec2[1]==rec2[3]) return false;
		//checking if all the other posibilities and sending the compliment of that
		return !(rec1[0]>=rec2[3] || rec1[1]>=rec2[3] || rec1[2]<=rec2[0] || rec1[3]<=rec2[1]);
	}
	public static void main(String[] args){
		RectangleOverlap ro=new RectangleOverlap();
		boolean b=ro.isOverlap(new int[]{0,0,2,2},new int[]{1,1,3,3});
		System.out.println(b);
	}
} 
