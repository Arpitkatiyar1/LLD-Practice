package stackOverFlow;

public class Tag {
    private int id;
    private String name;

    Tag(int id, String name){
        this.id=id;
        this.name=name;
    }
    public synchronized int getId(){
        return this.id;
    }
    public synchronized String getName(){
        return this.name;
    }
}
