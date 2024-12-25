package shop;

public class Employee extends User {
    private double salary;
    private String type_of_employee;

    public Employee() {
    }

    public Employee( String name,String type_of_employee,double salary) {
        super(name);
        this.salary = salary;
        this.type_of_employee = type_of_employee;
        super.setID();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getType_of_employee() {
        return type_of_employee;
    }

    public void setType_of_employee(String type_of_employee) {
        this.type_of_employee = type_of_employee;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getID() {
        return super.ID;
    }

    
    public void SetNewSalary(double ps){
        double is=salary*ps; //increase salary = salary * percentage
        this.salary +=is;
    }
    public boolean isManager(){
        boolean type=false;
        if((type_of_employee.equals("Manager"))||  (type_of_employee.equals("manager"))){
            type=true;
        }
        return type;
    }

    @Override
    public String toString() {
        return "Employee { "+" ( "+getType_of_employee() +" ( "+getName()+" )"+" ( "+getID()+" ) "+ " salary= " + salary  + '}';
    }
    
    
    
}
