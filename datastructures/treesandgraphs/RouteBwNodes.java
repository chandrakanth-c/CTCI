package datastructures.treesandgraphs;

import java.util.LinkedList;

public class RouteBwNodes {
    
    private int V;
    private LinkedList<Integer> adjList[];
    
    public RouteBwNodes(LinkedList<Integer> adjList[]){
        this.V=adjList.length;
        this.adjList=adjList;
    }

    public boolean routeBwNodes(int u,int v){
        boolean[] visited =new boolean[V];
        dfs(u,visited);
        if(visited[u] && visited[v]) return true;
        else return false;
    }

    private void dfs(int u,boolean[] visited){
        visited[u]=true;
        for(Integer i:adjList[u]){
            if(!visited[i]) dfs(i,visited);
        }
    }

    public static void main(String[] args) {
        Graph graph=new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(3, 2);

        RouteBwNodes rbn=new RouteBwNodes(graph.adjList);

        System.out.println(rbn.routeBwNodes(3, 0));  
    }

}
