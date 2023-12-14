package Staff;

import java.util.Date;

public interface StudentOrganization {
    String Head = null;
    String name = null;
    Date date = null;
    Integer NumberOfMembers = 0;

    void createStudentOrganization();
    void kickMember();
    void acceptMember();
    void OrganizeEvent();
}
