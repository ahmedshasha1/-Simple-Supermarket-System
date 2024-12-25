package shop;

public class User {
    protected String name;
    protected static int ID_Start=100;
    protected int ID;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID() {
        ID = ID_Start++;
    }
    
    public int getID() {
        return this.ID;
    }
    
    
    
}
