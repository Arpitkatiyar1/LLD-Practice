package stackOverFlow;

public class Tag {
    private int id;
    private String name;

    Tag(String name){
        this.id=this.generateId();
        this.name=name;
    }
    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
	}
	public synchronized int getId(){
        return this.id;
    }
    public String getTag(){
        return this.name;
    }
}
