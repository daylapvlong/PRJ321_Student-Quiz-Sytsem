/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import DB.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

/**
 *
 * @author admin's
 */
public class CreateDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void newCourse(String courseName, String description, int categoryId) {
        String query = "INSERT INTO Course (courseName, description, categoryId)\n"
                + "VALUES (?, ?, ?),";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, courseName);
            ps.setString(2, description);
            ps.setInt(3, categoryId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void newQuiz(String quizname, int numOfQuestion, Date dateCreated, Time timeLimit, int courseId) {
        String query = "INSERT INTO quiz (quizname, numOfQuestion, dateCreated, timeLimit, courseId)\n"
                + "VALUES (?, ?, ?, ?, ?),";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, quizname);
            ps.setInt(2, numOfQuestion);
            ps.setDate(3, dateCreated);
            ps.setTime(4, timeLimit);
            ps.setInt(5, courseId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void newQuestion(String content, int quizId) {
        String query = "INSERT INTO Question ([content], quizId)\n"
                + "VALUES (?, ?),";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, content);
            ps.setInt(2, quizId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void newAnswer(String content, int questionId) {
        String query = "INSERT INTO Answer (answerId, [content], isCorrectAnswer, questionId)\n"
                + "VALUES ( ?, 0, ?),";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, content);
            ps.setInt(2, questionId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void newCorrectAnswer(String content, int questionId) {
        String query = "INSERT INTO Answer (answerId, [content], isCorrectAnswer, questionId)\n"
                + "VALUES ( ?, 1, ?),";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, content);
            ps.setInt(2, questionId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
