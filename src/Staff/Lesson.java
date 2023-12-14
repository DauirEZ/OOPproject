package Staff;
import java.io.Serializable;

public class Lesson implements Serializable {
    String name;
    LessonType lessonType;
    int absence;

    public Lesson(String name, LessonType lessonType, int absence) {
        this.name = name;
        this.lessonType = lessonType;
        this.absence = absence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LessonType getLessonType() {
        return lessonType;
    }

    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }

    public int getAbsence() {
        return absence;
    }

    public void setAbsence(int absence) {
        this.absence = absence;
    }

    @Override
    public String toString() {
        return "Lesson [name=" + name + ", lessonType=" + lessonType + ", absence=" + absence + "]";
    }
}

