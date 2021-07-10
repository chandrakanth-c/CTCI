package datastructures.treesandgraphs;

import java.util.LinkedList;

/**
 * This graph is created using an adjacancy list
 */
public class Graph {

    //Number of vertices
    private int V;
    //adjacacy list
    public LinkedList<Integer> adjList[];

    @SuppressWarnings("checked")public Graph(int v){
        this.V=v;
        this.adjList=new LinkedList[v];
        for(int i=0;i<V;i++) adjList[i]=new LinkedList<>();
    }

    public void addEdge(int v,int w){
        adjList[v].add(w);
    }

    public static void main(String[] args) {
        /**
         * Creating a graph
         */
        Graph graph=new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(3, 2);

        for(int i=0;i<graph.adjList.length;i++) System.out.println(graph.adjList[i]);
    }
}   
