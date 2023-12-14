package Staff;
import Researcher.Researcher;
import Researcher.ResearchPaper;

import java.util.List;

public class Professor extends Teacher implements Researcher {
    @Override
    public int calculateHIndex() {
        return 0;
    }

    @Override
    public boolean isSupervisor() {
        return false;
    }

    @Override
    public void haveResearchProject() {

    }

    @Override
    public void printPapers(List<ResearchPaper> researchPapers) {

    }
}
