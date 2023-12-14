package Staff;

public interface MarkInterface {
    void setFirstAtt(int mark);
    void setSecondAtt(int mark);
    void setFinalScore(int mark);
    int getFirstAtt();
    int getSecondAtt();
    int getFinalScore();
    int calculateFinalScore();
    int getTotalScore();
    boolean canWriteFinal();
}