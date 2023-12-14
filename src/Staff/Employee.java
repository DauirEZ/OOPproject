package Staff;
import USER.User;

public class Employee extends User {
    Double salary;

    public Employee() {

    }

    public Employee(String surname, String name) {
    }

    public Employee(String name, String surname, Double salary) {
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(){
        this.salary = salary;
    }




}
