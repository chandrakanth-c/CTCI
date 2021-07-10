package datastructures.stacksandqueues;

/**
 * Disclaimer: This solution is not exactly in CTCI book
 */
public class AnimalShelter {

    enum Type{
        DOG,
        CAT
    }

    class ASQueueNode{
        private String name;
        private Type type;
        private ASQueueNode next;

        public ASQueueNode(String name,Type type){
            this.name=name;
            this.type=type;
            this.next=null;
        }
    }

    private ASQueueNode dTop;
    private ASQueueNode last;
    private ASQueueNode cTop;
    private ASQueueNode top;

    public AnimalShelter(){
        this.dTop=null;
        this.cTop=null;
    }

    public void enqueue(String name,Type type){
        ASQueueNode node=new ASQueueNode(name, type);

        if(type==Type.DOG){
            enqueueDog(node);
        }

        if(type==Type.CAT){
            enqueueCat(node);
        }
    }

    public String dequeueAny() throws RuntimeException{
        if(isEmpty()) throw new RuntimeException("There are no animal left in the shelter");
        String name=top.name+" "+top.type;
        if(top==dTop) moveDTop();
        if(top==cTop) moveCTop();
        return name;
    }

    public String dequeueDog() throws RuntimeException{
        if(isDEmpty()) throw new RuntimeException("There are no Dogs left in the shelter");
        String name=dTop.name+" "+dTop.type;
        moveDTop();
        return name;
    }

    public String dequeueCat() throws RuntimeException{
        if(isCEmpty()) throw new RuntimeException("There are no Cats left in the shelter");
        String name=cTop.name+" "+cTop.type;
        moveCTop();
        return name;
    }

    public boolean isEmpty(){
        return top==null;
    }
    
    private void moveDTop(){

        if(top==dTop){
            top=top.next;
        }

        dTop=dTop.next;
        while(dTop != null && dTop.type!=Type.DOG) dTop=dTop.next;
    }

    private void moveCTop(){

        if(top==cTop){
            top=top.next;
        }

        cTop=cTop.next;
        while(cTop != null && cTop.type!=Type.CAT) cTop=dTop.next;
    }

    private boolean isDEmpty(){
        return dTop==null;
    }

    private boolean isCEmpty(){
        return cTop==null;
    }

    private void enqueueDog(ASQueueNode node){
        if(dTop==null) {
            dTop=node;
        }

        if(top==null){
            top=node;
        }

        if(last==null) {
            last=node;
        }else{
            last.next=node;
            last=node;
        }
    }

    private void enqueueCat(ASQueueNode node){
        if(cTop==null) {
            cTop=node;
        }

        if(top==null){
            top=node;
        }
        
        if(last==null) {
            last=node;
        }else{
            last.next=node;
            last=node;
        }
    }

    public static void main(String[] args) {
        AnimalShelter as=new AnimalShelter();
        as.enqueue("a", Type.DOG);
        as.enqueue("b", Type.CAT);
        as.enqueue("c", Type.DOG);
        as.enqueue("d", Type.CAT);
        System.out.println(as.dequeueDog());
        System.out.println(as.dequeueCat());
        System.out.println(as.dequeueDog());
        System.out.println(as.dequeueAny());
        as.enqueue("f", Type.CAT);
        System.out.println(as.dequeueCat());
        System.out.println(as.dequeueCat());
    }
}
