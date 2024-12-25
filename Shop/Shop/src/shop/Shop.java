package shop;
import java.util.ArrayList;

public class Shop extends Item implements Display {
    private String name;
    ArrayList<Item>items;
    ArrayList<Customer>customers;
    ArrayList<Employee>employees;

    public Shop() {
    }

    public Shop(String name) {
        this.name = name;
        items = new ArrayList<Item>();
        customers = new ArrayList<Customer>();
        employees = new ArrayList<Employee>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    // items exist
    public boolean isExist(String pro_name){
        for (int i = 0 ; i<items.size();i++){
            if(pro_name.equals(items.get(i).getName())){
                return true;
            }
        }
        return false;
    }
    //add items
    public void addItem(Item new_item){
        if(items.size()==50)
            System.out.println("The shop is full ! ");
        else 
            items.add(new_item);
    }
    
    //remove items
    public void removeItem(String pro_name){
        if(items.isEmpty()){
            System.out.println("The shop is empty ! ");
            }
        else {
            if(isExist(pro_name)){
                for (int i = 0 ; i<items.size();i++){
                        if(pro_name.equals(items.get(i).getName())){
                        items.remove(i);
                        }
                
                    }
                }
            else 
                System.out.println("The product is not exist ");
                
        }
}
    
//total price 
    
    @Override
    public void totalPrice(int cus_id){
        double total=0;
        double discount=0.0;

        for (int i = 0;i<customers.size();i++){
            if(cus_id==customers.get(i).getID()){
                total = customers.get(i).getItem();
                if(customers.get(i).isSpecial()){
                    discount = items.get(i).getPrice() * (0.25);
                    total =items.get(i).getPrice()  - discount;
                }
                
            }
        }
        System.out.println("Discount : "+discount);
        System.out.println("The total price : "+total);
    }
    
//buy and remove item from shop
    public void buy(int cust_id){
        for (int i =0 ; i<customers.size();i++){
            if(cust_id==customers.get(i).getID()){
                for (int j = 0 ; j < customers.get(i).items.size();j++ ){
                    removeItem(customers.get(i).items.get(j).getName());
                }
            }
        }
    }
    //view 
    
    @Override
    public void print_pro(){
        for (int i = 0 ; i<items.size();i++){
            System.out.println(items.get(i).toString());
        }
    }
    
    @Override
    public void print_cust(){
        for (int i = 0 ; i<customers.size();i++){
            System.out.println(customers.get(i).toString());
        }
    }
   
    @Override
    public void print_emp(){
        for (int i = 0 ; i<employees.size();i++){
            System.out.println(employees.get(i).toString());
        }
    }
    public boolean check_manager(int id){
        boolean x=false;
        for (int i = 0 ; i<employees.size();i++){
            if(id==employees.get(i).getID()){
                if(employees.get(i).isManager()){
                    x=true;
                }
            }
        } 
        return x;
    }
    public void increase_salary(double sal){
        for (int i = 0 ; i<employees.size();i++){
            employees.get(i).SetNewSalary(sal);
        }

    }
    @Override
    public void print_kind(){
        System.out.println("{Books , Laptop , Food , Electonics ");
        for (int i = 0 ; i<items.size();i++){
            if(null != items.get(i).getKind()){
                switch (items.get(i).getKind()) {
                case "Books" -> {
                    System.out.println("In Books ) The list of special products ");
                    System.out.println(items.get(i).toString());
                }
                case "Laptop" -> {
                    System.out.println("In Laptop ) The list of special products ");
                    System.out.println(items.get(i).toString());
                }
                case "Food" -> {
                    System.out.println("In Food ) The list of special products ");
                    System.out.println(items.get(i).toString());
                }
                case "ELectronics" -> {
                    System.out.println("In Electronics) The list of special products ");
                    System.out.println(items.get(i).toString());
                }
                default -> {
                }
            }
        }

    }
}

}