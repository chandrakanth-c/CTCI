package datastructures.treesandgraphs;

import java.util.*;

public class BuildOrder {    

    public void buildOrder(String[] nodes,String[][] dependencies){
        GraphObject graph=buildGraph(nodes, dependencies);

        for(Project p:graph.getNodes()){
            System.out.println(p.getName());
            List<String> children=new ArrayList<>();
            for(Project c:p.getChildren()){
                children.add(c.getName());
            }
            System.out.println(children);
        }

        Stack<Project> stack=orderGraph(graph);

        while(!stack.isEmpty()){
            System.out.print(stack.pop().getName()+" ");
        }

        System.out.println();
    }

    public GraphObject buildGraph(String[] nodes,String[][] dependencies){
        GraphObject graph=new GraphObject();

        for(String name:nodes) graph.getOrInsertNode(name);

        System.out.println(graph.getNodes());

        for(String[] dependency:dependencies){
            String start=dependency[0];
            String end=dependency[1];
            Project startProj = graph.getOrInsertNode(start);
            Project endProject = graph.getOrInsertNode(end);
            startProj.addNeighbour(endProject);
        }

        return graph;
    }

    Stack<Project> orderGraph(GraphObject graph){
        Stack<Project> resStack=new Stack<>();

        for(Project node:graph.getNodes()){
            if(node.getState() == State.BLANK){
                if(!dfs(node,resStack)){
                    return null;
                }
            }
        }

        return resStack;
    }

    boolean dfs(Project node,Stack<Project> resStack){
        if(node.getState() == State.PARTIAL) return false;

        if(node.getState() == State.BLANK){
            node.setState(State.PARTIAL);
            for(Project child:node.getChildren()){
                if(!dfs(child,resStack)){
                    return false;
                }
            }
            node.setState(State.COMPLETED);
            resStack.push(node);
        }

        return true;
    }

    public static void main(String[] args) {
        BuildOrder buildOrder = new BuildOrder();

        buildOrder.buildOrder(new String[]{"a","b","c","d","e","f"}, new String[][]{{"a","d"},{"f","b"},{"b","d"},{"f","a"},{"d","c"}});
    }
}

class GraphObject {
    private List<Project> nodes=new ArrayList<>();
    private Map<String,Project> map=new HashMap<>();

    public Project getOrInsertNode(String projectName){
        if(!map.containsKey(projectName)){
            Project node=new Project(projectName);
            nodes.add(node);
            map.put(projectName,node);
        }

        return map.get(projectName);
    }

    public List<Project> getNodes(){
        return this.nodes;
    }
}

class Project{
    private List<Project> children=new ArrayList<>();
    private Map<String,Project> map=new HashMap<>();
    private int dependencies=0;
    private String name;
    private State state;

    public Project(String name){
        this.name=name;
        this.state=State.BLANK;
    }

    public void addNeighbour(Project child){
        this.children.add(child);
        incrementDep();
    }

    public void incrementDep(){this.dependencies++;}
    public void decrementDep(){this.dependencies--;}

    public String getName(){
        return this.name;
    }

    public List<Project> getChildren(){
        return this.children;
    }
    
    public State getState(){
        return this.state;
    }

    public void setState(State state){
        this.state=state;
    }
}

enum State{
    BLANK,PARTIAL,COMPLETED;
}
