package Staff;
import Students.Student;
import USER.User;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.Map;


public class Teacher extends Employee implements CanGiveRetake {
    private TeachersRank Rank;
    public String TeachingCourse;
    Map<String, Integer>StudentsByMark;

    public Teacher() {

    }

    public Teacher(String name, String surname, Double salary, TeachersRank Rank, String TeachingCourse) {
        super(name, surname, salary);
        this.Rank = Rank;
        this.TeachingCourse = TeachingCourse;
    }




    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Teacher teacher = (Teacher) obj;
        return Objects.equals(getName(), teacher.getName()) &&
                Objects.equals(getSurname(), teacher.getSurname()) &&
                Objects.equals(getSalary(), teacher.getSalary()) &&
                Objects.equals(Rank, teacher.Rank) &&
                Objects.equals(TeachingCourse, teacher.TeachingCourse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getSalary(), Rank, TeachingCourse);
    }

    public void sendComplaint(List<Student> students) {
        for (Student student : students) {
            if (student.getAbsent() > 13) {
                System.out.println("Complaint sent to the dean about student: " + student.getName() + ", with urgency level: High");
            } else {
                System.out.println("Everything is OK with student " + student.getName());
            }
        }
    }


    public void CheckAttendance() {

    }

    public void putMark(Student student, Mark mark, Course course, MarkType markType, Map<String, Integer> studentMark) {

        if (mark.canWriteFinal()) {

            mark.setFirstAtt(generateRandomMark());
            mark.setSecondAtt(generateRandomMark());


            int finalScore = convertMarkTypeToScore(markType);
            mark.setFinalScore(finalScore);


            System.out.println("Mark set for student " + student.getName() + ":");
            System.out.println("First Attempt: " + mark.getFirstAtt());
            System.out.println("Second Attempt: " + mark.getSecondAtt());
            System.out.println("Final Score: " + mark.getFinalScore());


            studentMark.put(course.getName(), mark.calculateFinalScore());
            StudentsByMark.put(student.getName(), mark.calculateFinalScore());


        } else {
            System.out.println("Teacher " + getName() + " can't put marks for student " + student.getName() +
                    " because the total score is less than 30.");
        }
    }


    private int generateRandomMark() {
        return (int) (Math.random() * 51);
    }


    private int convertMarkTypeToScore(MarkType markType) {
        switch (markType) {
            case A:
                return 95;
            case A_MINUS:
                return 90;
            case B_PLUS:
                return 85;
            case B:
                return 80;
            case B_MINUS:
                return 75;
            case C_PLUS:
                return 70;
            case C:
                return 65;
            case C_MINUS:
                return 60;
            case D_PLUS:
                return 55;
            case D_MINUS:
                return 50;
            case F:
                return 0;

            default:
                return 0;
        }
    }

    public String viewCourse(Course course) {
        if(Objects.equals(course.getName(), TeachingCourse))
            System.out.println(getName() + "teaches " + course.getName() + " at Kazakh British Technical University");
        return null;
    }


    @Override
    public void GivesRetake(List<Student> students, Vector<Mark> studentMark) {
        for (Student student : students) {
            for (Mark mark : studentMark) {


                if (mark.calculateFinalScore() < 50) {
                    System.out.println(getName() + " is sending student " + student.getName() + " for retake.");


                    student.incrementRetakes();
                } else {
                    System.out.println("Teacher " + getName() + " can't send student " + student.getName() + " for retake.");
                }
            }
        }

    }


    public void ViewStudentsByMark() {
        if (StudentsByMark.isEmpty()) {
            System.out.println("No student marks available for viewing.");
            return;
        }

        System.out.println("Students and their marks for the course " + TeachingCourse + ":");

        for (Map.Entry<String, Integer> entry : StudentsByMark.entrySet()) {
            String studentName = entry.getKey();
            int mark = entry.getValue();

            System.out.println(studentName + ": " + mark);
        }
    }
}
