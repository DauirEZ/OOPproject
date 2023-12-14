package Staff;

public interface LessonInterface {
    String getName();
    void setName(String name);

    LessonType getLessonType();
    void setLessonType(LessonType lessonType);

    int getAbsence();
    void setAbsence(int absence);

    String toString();
}
