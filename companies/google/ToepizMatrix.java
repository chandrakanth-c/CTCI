public class ToepizMatrix {

    private int[][] input;
    private int previousValue;

    public boolean isToepizMatrix(int[][] input){
        if(input.length==0) return false;
        this.input=input;
        boolean result=true;
        int rows=input.length;
        int cols=input[0].length;
        for(int i=0;i<rows-1;i++) {
            previousValue=input[i][0];
            result=result && dfs(i,0);
        }
        for(int i=0;i<cols-1;i++) {
            previousValue=input[0][i];
            result=result && dfs(0,i);
        }
        return result;
    }

    private boolean dfs(int r,int c){
        while(r<input.length && c<input[0].length){
            if(input[r][c]!=previousValue) return false;
            r++;
            c++;
            dfs(r, c);
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] input=new int[][]{{1,2,3,4,8},{5,2,2,3,4},{4,5,1,2,3},{7,4,5,1,2}};
        ToepizMatrix tM=new ToepizMatrix();
        boolean b=tM.isToepizMatrix(input);
        System.out.println(b);
    }
}
