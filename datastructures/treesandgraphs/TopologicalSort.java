package datastructures.treesandgraphs;

import java.util.*;

public class TopologicalSort {
    
    private int V;
    private LinkedList<Integer> adjList[];

    public TopologicalSort(Graph graph){
        this.V=graph.adjList.length;
        this.adjList=graph.adjList;
    }

    public void topologicalSort(){
        Stack<Integer> stack=new Stack<>();
        boolean[] visited=new boolean[V];

        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                topologicalUtil(i,visited,stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }

    private void topologicalUtil(int v,boolean[] visited,Stack stack){
        visited[v]=true;

        for(Integer i:adjList[v]){
            if(!visited[i]) {
                topologicalUtil(i,visited,stack);
            }
        }

        stack.push(v);
    }

    public static void main(String[] args) {

        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        TopologicalSort t=new TopologicalSort(g);

        t.topologicalSort();
        
    }
}
