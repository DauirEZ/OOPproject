package Staff;

public class Mark implements MarkInterface{
    private int firstAtt;
    private int secondAtt;
    private int finalScore;

    public Mark() {
        this.firstAtt = 0;
        this.secondAtt = 0;
        this.finalScore = 0;
    }

    public void setFirstAtt(int mark) {
        this.firstAtt = mark;
    }

    public void setSecondAtt(int mark) {
        this.secondAtt = mark;
    }
    public void setFinalScore(int mark) {
        if(canWriteFinal()) {
            this.finalScore = mark;
        }
        else {
            System.out.println("go to the Retake bench");
        }
    }

    public int getFirstAtt() {
        return this.firstAtt;
    }

    public int getSecondAtt() {
        return this.secondAtt;
    }

    public int getFinalScore() {
        return this.finalScore;
    }

    public int calculateFinalScore() {
        return this.firstAtt + this.secondAtt + this.finalScore;
    }

    public int getTotalScore() {
        return this.firstAtt + this.secondAtt;
    }
    public boolean canWriteFinal() {
        if (getTotalScore() >= 30){
            return true;
        }
        return false;
    }

}
