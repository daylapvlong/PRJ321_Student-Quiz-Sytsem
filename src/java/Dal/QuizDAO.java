package Dal;

import DB.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
