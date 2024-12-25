package shop;
import java.util.Scanner;

public class ShopManagementSystem{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Shop shop=new Shop("FEE");
        System.out.println("^^^^^^^ Welcome in "+shop.getName()+" ^^^^^^^ ");
        while (true){
                System.out.println("^^^^^^^ Select operation from menu ^^^^^^^");
                System.out.println("1 -> Items Managment");
                System.out.println("2 -> Users Managment");
                System.out.println("3 -> Buy product");
                System.out.println("4 -> Show special products");
                System.out.println("5 -> Exit");
                System.out.print(" ur choice : ");
                int choice=in.nextInt();
                switch(choice){
                    case 1-> {
                        int s1=0;
                                do{
                                    System.out.println("^^^^^^ Items Managment ^^^^^^^");
                                    System.out.println("1 -> Add Item");
                                    System.out.println("2 -> Remove Item");
                                    System.out.println("3 -> View Item");
                                    System.out.println("4 -> Back to main menu");
                                    System.out.print(" ^^^ ur choice ^^^ : ");
                                     s1=in.nextInt();
                                    switch (s1){
                                        case 1-> {
                                            System.out.println("Item name");
                                            String it_name=in.next();
                                            System.out.println("Item price");
                                            double it_price=in.nextDouble();
                                            System.out.println("Item kind");
                                            String it_kind=in.next();
                                            Item new_item=new Item(it_name,it_price,it_kind);
                                            shop.addItem(new_item);
                                        }
                                        case 2 -> {
                                            System.out.println("Enter employee id");
                                            int em_id=in.nextInt();
                                            if(shop.check_manager(em_id)){
                                            System.out.println("Enter item name");
                                            String it_name=in.next();
                                            shop.removeItem(it_name);
                                                System.out.println("Remove done");
                                            }
                                            else {
                                                System.out.println("Employee not a manager can't remove item");
                                            }
                                            break;
                                        }
                                        case 3 ->{
                                            if(shop.items.isEmpty()){
                                                System.out.println("Shop is empty");
                                            }
                                            else {
                                                System.out.println("Items in shop");
                                                shop.print_pro();
                                            }
                                            break;
                                        }
                                    }
                                }while (s1 != 4);
                        break;
                    }
                    case 2-> {
                        int s2=0;
                        do{
                            System.out.println("^^^^^^ User Managment ^^^^^^^");
                                    System.out.println("1 -> Add Customer");
                                    System.out.println("2 -> Add employee");
                                    System.out.println("3 -> Update Employee");
                                    System.out.println("4 -> View User");
                                    System.out.println("5 -> Back to main menu");
                                    System.out.print(" ur choice : ");
                                     s2=in.nextInt();
                                    switch (s2){
                                        case 1 -> {
                                            System.out.println("Customer name");
                                            String cus_name=in.next();
                                            Customer new_cus=new Customer(cus_name);
                                            shop.customers.add(new_cus);
                                        }
                                        case 2->{
                                            System.out.println("Employee name");
                                            String em_name=in.next();
                                            System.out.println("Employee salary ");
                                            double em_sal=in.nextDouble();
                                            System.out.println("Employee Type");
                                            String em_type=in.next();
                                            Employee new_emp=new Employee(em_name,em_type,em_sal);
                                            shop.employees.add(new_emp);
                                            
                                        }
                                        case 3->{
                                            System.out.println("Increase Salary % : ");
                                            double percent =in.nextDouble();
                                            shop.increase_salary(percent);
                                        }
                                        case 4 ->{
                                            if((shop.customers.isEmpty())&& (shop.employees.isEmpty())){
                                                    System.out.println("No users ");
                                                }
                                            else {
                                                    System.out.println("List of Users");
                                                    shop.print_cust();
                                                    shop.print_emp();
                                            
                                                  }
                                        }
                                    }
                        }while (s2 != 5);
                    }
                    case 3-> {
                        System.out.println("^^^^^^^^ Buy product ^^^^^^^^ ");
                        int s3=0;
                        int n =0;
                        System.out.println("Enter customer id : ");
                        int cus_id=in.nextInt();
                        for (int i = 0;i<shop.customers.size();i++){
                            if(cus_id==shop.customers.get(i).getID()){
                                System.out.println(shop.customers.get(i).toString());
                                do{
                                    System.out.println("Enter ID of item");
                                    int it_id=in.nextInt();
                                    for(int j =0 ; j<shop.items.size();j++){
                                        if(it_id==shop.items.get(j).getID()){
                                            System.out.println(shop.items.get(j).toString());
                                            shop.customers.get(i).addItem(shop.items.get(j));
                                            n=i;
                                        break;
                                            }
                                        else if (cus_id !=shop.customers.get(i).getID()) {
                                            System.out.println("Item not exist in shop");
                                            break;
                                            }
                                }
                                System.out.println("Enter 0 to add anther product or 1 to checkout ");
                                s3=in.nextInt();
                            }while(s3 != 1);
                        }
                      }        

                        System.out.println(shop.customers.get(n).getTypeOfCus());
                        System.out.println("bought : ");
                        shop.totalPrice(cus_id);
                        shop.buy(cus_id);
                        shop.customers.get(n).getNum_visits();
                        shop.customers.get(n).items.clear(); //make the cart empty 
                    }
                    case 4-> {
                        System.out.println("^^^^^^^ Show special products ^^^^^^^^ ");
                        shop.print_kind();
                      }
                    case 5-> {
                        System.out.println("Thank you for choosing our shop");
                        return;
                    }
                    default -> System.out.println("Enter a valid number");
                }
        }
    }  
}
