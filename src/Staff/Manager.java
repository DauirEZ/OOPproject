package Staff;

import java.util.Collections;
import java.util.List;
import Students.Student;

public class Manager extends Employee implements StudentOrganization{

    public Manager(){
        super();

    }

    public Manager(String name, String surname, Double salary){
        super(name, surname, salary);

    }

    public void printStudentsSortedByGPA(List<Student> students) {
        Collections.sort(students);
        System.out.println("Students sorted by GPA:");
        for (Student student : students) {
            System.out.println(student.getName() + "'s GPA is "+ student.getGPA());
        }
    }


    @Override
    public void createStudentOrganization() {

    }

    @Override
    public void kickMember() {

    }

    @Override
    public void acceptMember() {

    }

    @Override
    public void OrganizeEvent() {

    }
}
