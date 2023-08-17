package Model;

public class Submission {
    private int resultId;
    private int resultScore;

    public Submission() {}

    public Submission(int resultId, int resultScore) {
        this.resultId = resultId;
        this.resultScore = resultScore;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getResultScore() {
        return resultScore;
    }

    public void setResultScore(int resultScore) {
        this.resultScore = resultScore;
    }

    @Override
    public String toString() {
        return "Submission{" +
                "resultId=" + resultId +
                ", resultScore=" + resultScore +
                '}';
    }
}
