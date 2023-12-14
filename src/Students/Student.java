package Students;
import java.util.Vector;
import java.util.List;
import java.util.Objects;
import java.util.Map;

import Staff.Teacher;
import USER.User;
import Staff.Mark;
import Staff.Course;

public class Student extends User implements CanHaveRetake, Comparable<Students.Student>, ExpulsionFromTheUniversity, putAttendance {
    Double GPA;
    Integer absent;
    Integer NumberOfRetakes;
    Integer Scholarship;
    Map<String, Integer> studentMark;
    Vector<Course> studentCourses;


    public Student(){

    }

    public Student(String name, String surname, String id, String login, String password) {
        super(name, surname, id, login, password);
    }

    public Student(Double GPA, Integer absent, Integer NumberOfRetakes, Integer Scholarship){
        this.GPA = GPA;
        this.absent = absent;
        this.NumberOfRetakes = 0;
        this.Scholarship = Scholarship;
    }

    public Student(String name, String surname, Integer age, Double gpa) {
        super();
    }

    public Student(String name, String surname, String id, String login, String password, Double gpa) {
    }

    public Student(String name, String surname, String id, String login, String password, Double gpa, String course, Double mark) {
    }


    public int hashCode() {
        return super.hashCode() + Objects.hash(GPA);
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        Students.Student student1 = (Students.Student) obj;
        return Objects.equals(GPA, student1.GPA);
    }



    @Override
    public String toString() {
        return "Student " + getName() + " is here";
    }



    public Double getGPA() {
        return GPA;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }



    public Integer getNumberOfRetakes(){
        return NumberOfRetakes;
    }

    public void setNumberOfRetakes(Integer numberOfRetakes) {
        NumberOfRetakes = numberOfRetakes;
    }

    public Integer getAbsent() {
        return absent;
    }

    public void setAbsent(Integer absent) {
        this.absent = absent;
    }


    public void takeRetake(Mark mark, List<Teacher> teachers) {

        for(Teacher teacher : teachers){
            int totalScore = mark.calculateFinalScore();

            if (totalScore < 50) {
                System.out.println(getName() + " has failed " + teacher.TeachingCourse + ". Current Total Score: " + totalScore);
                NumberOfRetakes += 1;
            } else {
                System.out.println(getName() + " has passed " + teacher.TeachingCourse + ". Current Total Score: " + totalScore);
            }
        }

    }

    @Override
    public void kickFromUniversity() {
        if(NumberOfRetakes > 3){
            System.out.println("Student " + getName() + " is kicked from the University");
        }
    }

    public int compareTo(Student student) {
        if(GPA > student.GPA) return 1;
        if(GPA < student.GPA) return -1;
        return 0;
    }

    public void incrementRetakes() {
        NumberOfRetakes++;
        System.out.println(getName() + " has been assigned an additional retake. Total retakes: " + NumberOfRetakes);
    }


    public void viewCourses(List<Teacher> teachers){
        for(Teacher teacher : teachers){
            System.out.println(teacher.TeachingCourse + "\n");
        }
    }


    public void viewMark(List<Teacher> teachers) {
        if (studentMark.isEmpty()) {
            System.out.println("No marks available for viewing.");
            return;
        }

        System.out.println("Marks for " + getName() + ":");

        for (Teacher teacher : teachers) {
            String courseName = teacher.TeachingCourse;

            if (studentMark.containsKey(courseName)) {
                int mark = studentMark.get(courseName);
                System.out.println(courseName + ": " + mark);
            } else {
                System.out.println(courseName + ": Mark not available");
            }
        }
    }


    public void rateTeachers(){

    }

    public void registerToCourse(){

    }

    public void PutAttendance(){

    }


}
