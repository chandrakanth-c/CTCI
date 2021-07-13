package companies.amazon.sde2;

public class CloudFront {	
	public int cloudfront(int[][] grid){
		if(!zerosPresent(grid)) return -1;
		int i=0;
		while(true){
			i++;
			if(!zerosPresent(grid)) break;
			for(int r=0;r<grid.length;r++){
				for(int c=0;c<grid[0].length;c++){
					if(grid[r][c]==i){
						//top
						if(isValid(grid,r-1,c) && grid[r-1][c]==0) grid[r-1][c]=i+1;
						//right
						if(isValid(grid,r,c+1) && grid[r][c+1]==0) grid[r][c+1]=i+1;
						//bottom
						if(isValid(grid,r+1,c) && grid[r+1][c]==0) grid[r+1][c]=i+1;
						//left
						if(isValid(grid,r,c-1) && grid[r][c-1]==0) grid[r][c-1]=i+1;
					}
				}
			}
		}
		return i-1;
	}

	private boolean zerosPresent(int[][] grid){
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j]==0) return true;
			}
		}
		return false;
	}

	private boolean isValid(int[][] grid,int r,int c){
		if(r>=0 && r<grid.length && c>=0 && c<grid[0].length) return true;
		return false;
	}

	public static void main(String[] args){
		CloudFront c=new CloudFront();
		System.out.println(c.cloudfront(new int[][]{{0,1,1,0,1},{0,1,0,1,0},{0,0,0,0,1},{0,1,0,0,0}}));
	}
						
}

