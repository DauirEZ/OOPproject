package Researcher;

import java.util.List;

public interface Researcher {
    String topic = null;
    String ProjectMembers = null;
    Integer HIndex = null;

    int calculateHIndex();

    boolean isSupervisor();

    void printPapers(List<ResearchPaper> researchPapers);

    void haveResearchProject();
}


