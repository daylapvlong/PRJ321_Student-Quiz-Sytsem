package Dal;

import DB.DBContext;
import Model.Quiz;
import Model.Submission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubmissionDAO extends DBContext {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Submission> getAllSubmission(String userId) {
        List<Submission> list = new ArrayList<>();
        String query = "select * from Submission \n"
                + "where userId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Submission(rs.getInt(1),
                        rs.getInt(2)
                        ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int addSubmission(String courseId, String quizId, String userId, String completionDateTime, int ResultScore) {
        String query1 = "INSERT INTO Submission (courseId, quizId, userId, completionDateTime, ResultScore)\n" +
                "VALUES \n" +
                "\t(?, ?, ?, ? , ?)";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query1);
            ps.setString(1, courseId);
            ps.setString(2, quizId);
            ps.setString(3, userId);
            ps.setString(4, completionDateTime);
            ps.setInt(5, ResultScore);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        String query2 = "select MAX(ResultId) from Submission";
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
        String courseId = "1";
        String quizId = "2";
        String userId = "3";
        String date = "2008-11-11 13:23:44";
        int score = 10;
        SubmissionDAO dao = new SubmissionDAO();
        List<Submission> list = dao.getAllSubmission(userId);
        System.out.println(list);
//        dao.addSubmission (courseId, quizId, userId, date, score);
    }
}
