package companies.amazon.sde2;
import java.util.*;

public class DemolitionRobot {
    public int minimumDist(List<List<Integer>> lot){
        return bfs(lot,0,0,0);
    }

    private int bfs(List<List<Integer>> lot,int x,int y,int dist){
        Queue<Cell> q=new LinkedList<>();
        q.add(new Cell(0,0,0));
        Cell res=null;
        int rows=lot.size();
        int cols=lot.get(0).size();
        boolean[][] visited=new boolean[rows][cols];

        while (!q.isEmpty()) {
            Cell cur=q.remove();
	        visited[cur.x][cur.y]=true;

            if(lot.get(cur.x).get(cur.y)==9){
                res=cur;
                break;
            }
	        //explore top
            if(isValid(lot,cur.x-1,cur.y,visited)){
                q.add(new Cell(cur.x-1,cur.y,cur.dist+1));
            }
	        //explore right
            if(isValid(lot,cur.x,cur.y+1,visited)){
                q.add(new Cell(cur.x,cur.y+1,cur.dist+1));
            }
	        //explore bottom
            if(isValid(lot,cur.x+1,cur.y,visited)){
                q.add(new Cell(cur.x+1,cur.y,cur.dist+1));
            }
	        //explore left
            if(isValid(lot,cur.x,cur.y-1,visited)){
                q.add(new Cell(cur.x,cur.y+1,cur.dist+1));
            }
	     
        }

	    return res==null?-1:res.dist;
    }

    private boolean isValid(List<List<Integer>> lot,int x,int y,boolean[][] visited){
	if(x<0 || x>=lot.size() || y<0 || y>=lot.get(0).size() || lot.get(x).get(y)==0 || visited[x][y]) return false;
	else return true;
    }
	

    public static void main(String[] args){
	DemolitionRobot dr=new DemolitionRobot();
	List<List<Integer>> lot=new ArrayList<>();
	lot.add(new ArrayList());
	lot.get(0).add(1);
	lot.get(0).add(0);
	lot.get(0).add(0);
	lot.add(new ArrayList());
	lot.get(1).add(1);
	lot.get(1).add(0);
	lot.get(1).add(1);
	lot.add(new ArrayList());
	lot.get(2).add(1);
	lot.get(2).add(1);
	lot.get(2).add(9);
	int ans=dr.minimumDist(lot);
	System.out.println(ans);
    }
}

class Cell{
    int x;
    int y;
    int dist;
    boolean visited;

    public Cell(int x,int y,int dist){
        this.x=x;
        this.y=y;
        this.dist=dist;
        this.visited=false;
    }
}
