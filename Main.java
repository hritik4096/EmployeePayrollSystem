package AdvanceOOps.EmployeePayrollSystemProject;
import java.util.*;

// conclusion : Here, we are creating a employee payroll system where the company can 
//              keep the employee's data like name, id , payments etc. so, basically here
//              i am using the four pillar of oops concepts to build this system. there will be
//              some classes employee,fullTimeEmployee,PartTimeEmpoyee,and Payroll class which 
//              are extends Employee class and it will be an abstract class now you can see below code......


abstract class Employee{
    private String name;
    private int id;

    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }

     public String getName(){
        return name;
     }

     public int getId(){
        return id;
     }

     public abstract double calculateSalary();



      @Override
     public String toString(){

        return "Employed[name= "+name+", id= "+id+", salary="+calculateSalary()+"]";
        
     }

}


class FullTimeEmployee extends Employee{
    private double monthlySalary;


   public FullTimeEmployee(String name,int id,double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
   }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}



class PartTimeEmpoyee extends Employee{

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmpoyee(String name,int id,int hoursWorked,double hourlyRate){
          super(name,id);
          this.hoursWorked=hoursWorked;
          this.hourlyRate=hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hourlyRate*hoursWorked;
    }


}



class PayrollSystem{

  // here our each employee will be store as an object in arraylist and employee has also three properties name,id ,salary etc.
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

     // addition of employee
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

   // deletion of employee 
    public void removeEmployee(int id){
         
        Employee employeeToRemove=null;

        for(Employee employee:employeeList){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }

        if(employeeToRemove!=null){
            employeeList.remove(employeeToRemove);
        }

    }


   // display the list of employees
    public void displayEmployees(){
        for(Employee employee :employeeList){
            System.out.println(employee);
        }
    }


}










public class Main {

    public static void main(String args[]){
        
        // PayrollSystem payrollSystem = new PayrollSystem();

        // FullTimeEmployee emp1 = new FullTimeEmployee("Hrtik", 1, 70000);
        // PartTimeEmpoyee emp2 = new PartTimeEmpoyee("Sushant", 3, 40, 100);

        //  payrollSystem.addEmployee(emp1);
        //  payrollSystem.addEmployee(emp2);

        //  System.out.println("initial employee details : ");
        //  payrollSystem.displayEmployees();
        //  System.out.println("removing employee : ");
        //  payrollSystem.removeEmployee(3);

        //  System.out.println("remaining employee details");
        //  payrollSystem.displayEmployees();
 
   
        // ****take input ********

         PayrollSystem payrollSystem = new PayrollSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of employees:");
        int numEmployees = scanner.nextInt();

        for (int i = 0; i < numEmployees; i++) {
            System.out.println("Enter details for Employee " + (i + 1));

            System.out.print("Enter employee type (1 for Full-Time, 2 for Part-Time): ");
            int type = scanner.nextInt();

            System.out.print("Enter name: ");
            String name = scanner.next();

            System.out.print("Enter id: ");
            int id = scanner.nextInt();

            if (type == 1) {
                System.out.print("Enter monthly salary: ");
                double monthlySalary = scanner.nextDouble();
                FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(name, id, monthlySalary);
                payrollSystem.addEmployee(fullTimeEmployee);
            } else if (type == 2) {
                System.out.print("Enter hours worked: ");
                int hoursWorked = scanner.nextInt();

                System.out.print("Enter hourly rate: ");
                double hourlyRate = scanner.nextDouble();
                
                PartTimeEmpoyee partTimeEmployee = new PartTimeEmpoyee(name, id, hoursWorked, hourlyRate);
                payrollSystem.addEmployee(partTimeEmployee);
            } else {
                System.out.println("Invalid employee type. Please try again.");
                i--; // retry for the current employee if type is invalid
            }
        }

        System.out.println("Initial employee details:");
        payrollSystem.displayEmployees();

        System.out.print("Enter the ID of the employee to remove: ");
        int idToRemove = scanner.nextInt();
        payrollSystem.removeEmployee(idToRemove);

        System.out.println("Remaining employee details:");
        payrollSystem.displayEmployees();







    }
    
}
