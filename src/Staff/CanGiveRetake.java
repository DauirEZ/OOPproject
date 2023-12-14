package Staff;

import Students.Student;

import java.util.List;
import java.util.Vector;

public interface CanGiveRetake {
    void GivesRetake(List<Student> students, Vector<Mark> studentMark);
}
