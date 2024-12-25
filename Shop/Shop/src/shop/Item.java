package shop;

public class    Item {
    private String name;
    private double price;
    static int ID_start=0;
    private int ID;
    private String kind;

    public Item() {
    }

    public Item(String name, double price, String kind) {
        this.name = name;
        this.price = price;
        this.ID = ID_start++;
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void setID(int ID) {
        this.ID = ID_start++;
    }

    public int getID() {
        return ID;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", price=" + price + ", ID=" + ID + ", kind=" + kind + '}';
    }
    
    
    
}
