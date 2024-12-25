package shop;
import java.util.ArrayList;

public class Customer extends User {
    private static int x =0;
    private  int num_visits;
    private boolean Special;
    public ArrayList<Item> items;

    public Customer() {
    }

    public Customer(String name) {
        super(name);
        super.setID();
        this.num_visits=x++;
        this.Special=false;
         items=new ArrayList<>();
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }

    @Override
    public int getID() {
        return super.ID;
    }

    public void setNum_visits() {
       this.num_visits= x++;
    }
    public int getNum_visits() {
        return this.num_visits;
    }

    

    public boolean isSpecial() {
        if (num_visits > 3){
            this.Special=true;
        }
        return this.Special;
    }
    public String getTypeOfCus(){
        if(isSpecial()){
            return "Special Customer";
        }
        return "New Customer";
    }
    
    public void addItem(Item New_Item){
        items.add(New_Item);
    }
    
    public double getItem(){
        double total=0;
        for (int i =0 ; i<items.size();i++){
            System.out.println(items.get(i).toString());
            total +=items.get(i).getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return getTypeOfCus()+ " : "+getName()+" ( "+getID()+" ) " + "Visits "+ getNum_visits()+ " times . ";
    }
    
}
