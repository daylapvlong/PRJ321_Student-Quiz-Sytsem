package Model;

import java.util.ArrayList;

/**
 *
 * @author Thaycacac
 */
public class Question {

    private int questionId;
    private String content;
    ArrayList<Answer> listAnswer;
    ArrayList<Answer> isCorrectAnswer;

    public Question() {
    }

    public Question(int questionId, String content, ArrayList<Answer> listAnswer, ArrayList<Answer> isCorrectAnswer) {
        this.questionId = questionId;
        this.content = content;
        this.listAnswer = listAnswer;
        this.isCorrectAnswer = isCorrectAnswer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Answer> getListAnswer() {
        return listAnswer;
    }

    public void setListAnswer(ArrayList<Answer> listAnswer) {
        this.listAnswer = listAnswer;
    }

    public ArrayList<Answer> isIsCorrectAnswer() {
        return isCorrectAnswer;
    }

    public void setIsCorrectAnswer(ArrayList<Answer> isCorrectAnswer) {
        this.isCorrectAnswer = isCorrectAnswer;
    }

    @Override
    public String toString() {
        return "Question{" + "questionId=" + questionId + ", content=" + content + ", listAnswer=" + listAnswer + ", corectAnswer=" + isCorrectAnswer + '}';
    }

}
