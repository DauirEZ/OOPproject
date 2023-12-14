package Students;
import Researcher.ResearchPaper;
import Researcher.Researcher;
import Staff.Mark;
import Staff.Teacher;

import java.util.List;

public class PHDStudent extends Student implements Researcher{
    Integer ResearchNumber;
    boolean isResearchProject;


    public PHDStudent(){

    }

    public PHDStudent(String name, String surname, String id, String login, String password, Double GPA, String course, Double Mark, Integer ResearchNumber, boolean isResearchProject) {
        super(name, surname, id, login, password, GPA, course, Mark);
        this.ResearchNumber = ResearchNumber;
        this.isResearchProject = isResearchProject;
    }

    public void takeRetake(Mark mark, List<Teacher> teachers) {

        for(Teacher teacher : teachers){
            int totalScore = mark.calculateFinalScore();

            if (totalScore < 50) {
                System.out.println(getName() + "PHD student has failed " + teacher.TeachingCourse + ". Current Total Score: " + totalScore);
                NumberOfRetakes += 1;
            } else {
                System.out.println(getName() + "PHD student has passed " + teacher.TeachingCourse + ". Current Total Score: " + totalScore);
            }
        }

    }

    @Override
    public void haveResearchProject() {
        if(isResearchProject){
            System.out.println("PhD student " + getName() + " " + getSurname() + " has a Research project");
        }
        else{
            System.out.println("PHD student " + getName() + " " + getSurname() + " doesn't have any Research projects");
        }

    }

    public void calculateHindex(){

    }

    public void PrintPapers(){

    }

    @Override
    public int calculateHIndex() {
        return 0;
    }

    public boolean isSupervisor(){

        return false;
    }

    @Override
    public void printPapers(List<ResearchPaper> researchPapers) {

    }


}
