package datastructures.treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;

public class SearchTechniques {

    private LinkedList<Integer> adjList[];

    public SearchTechniques(LinkedList<Integer> adj[]){
        this.adjList=adj;
    }
    
    public void DFS(int v){
        boolean[] visited=new boolean[adjList.length];
        DFSUtil(v,visited);
        for(int i=0;i<visited.length;i++) {
            if(!visited[i]) DFSUtil(i, visited);
        }
    }

    private void DFSUtil(int v,boolean[] visited){

        visited[v]=true;
        System.out.println(v+" ");

        for(Integer n:adjList[v]){
            if(!visited[n]) DFSUtil(n,visited);
        }

    }

    public void BFS(int v){
        boolean[] visited=new boolean[adjList.length];
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(v);

        while(!queue.isEmpty()){
            int n=queue.remove();
            System.out.println(n+" ");
            for(Integer i:adjList[n]){
                if(!visited[i]){
                    visited[i]=true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        /**
         * Creating a graph
         */
        Graph graph=new Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(2, 1);

        for(LinkedList i:graph.adjList){
            System.out.println(i);
        }

        SearchTechniques sT=new SearchTechniques(graph.adjList);

        sT.DFS(0);

    }
}
