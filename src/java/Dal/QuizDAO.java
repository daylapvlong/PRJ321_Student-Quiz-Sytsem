package Dal;

import DB.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuizDAO {
    public void updateQuiz(String quizId, String quizName) {
        String query = "update Quiz set quizName = ? where quizId = ?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, quizName);
            ps.setString(2, quizId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int addQuiz(String quizName, int courseId) {
        String query1 = "insert into Quiz(quizName,numOfQuestion,dateCreated,timeLimit, courseId) values (?,0,getdate(),'00:30:00',?)";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query1);
            ps.setString(1, quizName);
            ps.setInt(2, courseId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        String query2 = "select MAX(quizId) from Quiz";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query2);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public static void main(String[] args) {
        QuizDAO dao = new QuizDAO();
        dao.addQuiz("quizName", 1);
    }
}
