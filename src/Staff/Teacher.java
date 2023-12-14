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
            // Assuming the teacher wants to put marks for the first and second attempts
            mark.setFirstAtt(generateRandomMark()); // Replace this with your logic for assigning a mark
            mark.setSecondAtt(generateRandomMark()); // Replace this with your logic for assigning a mark

            // Assuming the teacher wants to put a final score using the MarkType enum
            int finalScore = convertMarkTypeToScore(markType);
            mark.setFinalScore(finalScore);

            // Display the information
            System.out.println("Mark set for student " + student.getName() + ":");
            System.out.println("First Attempt: " + mark.getFirstAtt());
            System.out.println("Second Attempt: " + mark.getSecondAtt());
            System.out.println("Final Score: " + mark.getFinalScore());


            studentMark.put(course.getName(), mark.calculateFinalScore());


        } else {
            System.out.println("Teacher " + getName() + " can't put marks for student " + student.getName() +
                    " because the total score is less than 30.");
        }
    }

    // Example method to generate a random mark (replace it with your logic)
    private int generateRandomMark() {
        return (int) (Math.random() * 51); // Generates a random mark between 0 and 50
    }


    private int convertMarkTypeToScore(MarkType markType) {
        // Add your logic to map MarkType to a numerical score
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
                return 0; // Default to 0 if no match found
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
            for (Mark mark : studentMark) {// Assuming 'mark' is the field storing the Mark object

                // Check if the student's mark is below the passing threshold
                if (mark.calculateFinalScore() < 50) {
                    System.out.println(getName() + " is sending student " + student.getName() + " for retake.");

                    // Assuming you have a method to increment the number of retakes for the student
                    student.incrementRetakes();
                } else {
                    System.out.println("Teacher " + getName() + " can't send student " + student.getName() + " for retake.");
                }
            }
        }

    }
}
