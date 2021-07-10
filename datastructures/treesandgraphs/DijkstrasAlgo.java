package datastructures.treesandgraphs;

public class DijkstrasAlgo {

    private int V;
    private int[][] graph;

    public DijkstrasAlgo(int[][] graph){
        this.V=graph[0].length;
        this.graph=graph;
    }

    public void dijkstra(int src){

        int[] dist=new int[V];
        boolean[] visited=new boolean[V];

        /**
         * Initialization of the dist array
         */
        for(int i=0;i<V;i++) dist[i]=Integer.MAX_VALUE;

        dist[src]=0;

        for(int count=0;count<V;count++){
            int u=minDist(dist,visited);

            visited[u]=true;

            for(int v=0;v<V;v++){
                if(!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && graph[u][v]+dist[u]<dist[v]){
                    dist[v]=dist[u]+graph[u][v];
                }
            }
        }

        printSol(dist);

    }

    private int minDist(int[] dist,boolean[] visited){
        int min=Integer.MAX_VALUE,min_index=-1;

        for(int i=0;i<V;i++){
            if(visited[i] == false && dist[i]<=min){
                min=dist[i];
                min_index=i;
            }
        }

        return min_index;
    }

    private void printSol(int[] dist){
        for(int i=0;i<V;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        /**
         * Building a graph using adjacancy matrix
         */
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };


        DijkstrasAlgo dA=new DijkstrasAlgo(graph);

        dA.dijkstra(0);
        
    }
    
}
