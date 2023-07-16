/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import DB.DBContext;
import Model.Account;
import Model.Course;
import Model.Quiz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin's
 */
public class CourseDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public int getQuizId(String cid) {
        String query = "select quizid from quiz \n"
                + "where courseId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("quizid");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public Course getCourseById(String id) {
        String query = "select * from Course\n"
                + "where courseId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Course(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public int getCourseId(String cid) {
        String query = "select courseId from Course \n"
                + "where courseId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("courseId");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Quiz> getAllQuiz(String cid) {
        List<Quiz> list = new ArrayList<>();
        String query = "select * from quiz \n"
                + "where courseId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        rs.getTime(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Quiz> searchQuizByName(String txtSearch, String cid) {
        List<Quiz> list = new ArrayList<>();
        String query = "select * from quiz\n"
                + "where quizName like ? and courseId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setString(2, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        rs.getTime(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Quiz getQuizById(String quizId) {
        String query = "select * from quiz\n"
                + "where quizId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, quizId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        rs.getTime(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String getCourseIdByQuizName(String quizName) {
        String courseId = null;
        String query = "SELECT courseId FROM quiz WHERE quizName = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, quizName);
            rs = ps.executeQuery();

            if (rs.next()) {
                courseId = rs.getString("courseId");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return courseId;
    }
    
    public void createCourse(String courseName, String description, String cateId){
        String query= "insert into Course(courseName, description, categoryId) values(?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, courseName);
            ps.setString(2, description);
            ps.setString(3, cateId);
            ps.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Course checkCourseExisted(String name) {
        try {
            String query = "Select * from Course where courseName = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            
            while(rs.next()){
                return new Course(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getInt(4));
            }
        } catch(Exception e) {
            
        }
        return null;
    }
    
    public static void main(String[] args) {
        CourseDAO dao = new CourseDAO();
//        String name = "MAE101";
//        Course c = dao.checkCourseExisted(name);
//        System.out.println(c);
//        
//        String cid = "1";
//        Course c =dao.getCourseById(cid);
//        System.out.println(c);

//        String cid = "1";
//        List<Quiz> list = dao.getAllQuiz(cid);
//        for (Quiz o : list) {
//            System.out.println(o);
//        }

        String quizId ="3";
        Quiz quiz = dao.getQuizById(quizId);
        System.out.println(quiz);
        
    }
}
