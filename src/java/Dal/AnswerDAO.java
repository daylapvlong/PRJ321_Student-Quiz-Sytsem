package Dal;

import Model.Answer;
import DB.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author Thaycacac
 */
public class AnswerDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Answer> getListAnswer(int questionId) {
        ArrayList<Answer> listAnswer = new ArrayList<>();
        String query = "SELECT * FROM Answer WHERE questionID = ? and status = 1";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, questionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String content = rs.getString(2);
                boolean isCorrectAnswer = rs.getBoolean(3);
                Answer ans = new Answer(id, questionId, content, isCorrectAnswer);
                listAnswer.add(ans);
            }
            return listAnswer;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Answer> getCorrectAnswer(int questionId) {
        ArrayList<Answer> listAnswer = new ArrayList<>();
        String query = "SELECT * FROM Answer WHERE questionID = ? and isCorrectAnswer = 1 and status = 1";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, questionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String contet = rs.getString(2);
                boolean isCorrectAnswer = rs.getBoolean(3);
                Answer ans = new Answer(id, questionId, contet, isCorrectAnswer);
                listAnswer.add(ans);
            }
            return listAnswer;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Answer getAnswerById(String questionid) {
        int questionId = Integer.parseInt(questionid);
        String query = "select * from Answer \n"
                + "where answerId = ? and status = 1";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, questionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String content = rs.getString(2);
                boolean isCorrectAnswer = rs.getBoolean(3);
                Answer ans = new Answer(id, questionId, content, isCorrectAnswer);
                return ans;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        AnswerDAO dao = new AnswerDAO();
//        ArrayList<Answer> list = dao.getListAnswer(1);
//        System.out.println(list);

//        ArrayList<Answer> list = dao.getCorrectAnswer(1);
//        System.out.println(list);

//        Answer ans = dao.getAnswerById("1");
//        System.out.println(ans);
//
    }

    public void deleteAllAnswer(String [] id) {
        String query = "UPDATE Answer SET status = 0 WHERE answerId IN (" + String.join(",", id) + ")";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateAnswer(Answer answer) {
        String query = "UPDATE Answer SET contentans = ?, isCorrectAnswer = ? WHERE answerId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, answer.getContent());
            ps.setBoolean(2, answer.isIsCorrectAnswer());
            ps.setInt(3, answer.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addAnswer(Answer answer) {
        String query = "INSERT INTO Answer (questionId, contentans, isCorrectAnswer, status) VALUES (?, ?, ?, 1)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, answer.getQuestionId());
            ps.setString(2, answer.getContent());
            ps.setBoolean(3, answer.isIsCorrectAnswer());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
