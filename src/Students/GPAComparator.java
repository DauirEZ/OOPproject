package Students;
import java.util.Comparator;


public class GPAComparator implements Comparator<Student> {
    public GPAComparator() {}
    @Override
    public int compare(Students.Student o1, Student o2) {
        return o1.getGPA().compareTo(o2.getGPA());
    }


}
