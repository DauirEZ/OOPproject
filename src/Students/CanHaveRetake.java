package Students;
import Staff.Mark;
import Staff.Teacher;

import java.util.List;

public interface CanHaveRetake {
    void takeRetake(Mark mark, List<Teacher> teachers);
}
