package Staff;

public enum MarkType {
    A("A"),
    A_MINUS("A-"),
    B_PLUS("B+"),
    B("B"),
    B_MINUS("B-"),
    C_PLUS("C+"),
    C("C"),
    C_MINUS("C-"),
    D_PLUS("D+"),
    D_MINUS("D-"),
    F("F");

    private final String gradeValue;

    MarkType(String gradeValue) {
        this.gradeValue = gradeValue;
    }

    public String getGradeValue() {
        return gradeValue;
    }
}