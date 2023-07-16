package Dal;

import Model.Answer;
import Model.Question;
import DB.DBContext;
import Model.Quiz;

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
public class QuestionDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public int getQuestionId(String quizid) {
        String query = "select questionId from Question \n"
                + "where quizid = ? \n" +
                "and status = 1";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, quizid);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("questionId");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public Question getQuestionById(String questionId) {
        String query = "select * from Question \n"
                + "where questionId = ? \n" +
                "and status = 1";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, questionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String content = rs.getString(2);
                AnswerDAO ansDao = new AnswerDAO();
                ArrayList<Answer> listAns = ansDao.getListAnswer(id);
                ArrayList<Answer> isCorrectAnswer = ansDao.getCorrectAnswer(id);
                Question question = new Question(id, content, listAns, isCorrectAnswer);
                return question;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public ArrayList<Question> getListQuestion(String quizId) {
        ArrayList<Question> listQuestion = new ArrayList<>();
        String query = "SELECT qn.questionId, qn.Content FROM Question qn\n"
                + "INNER JOIN QuestionQuiz qz\n"
                + "ON qn.questionId = qz.QuestionID\n"
                + "WHERE qz.QuizID = ?\n"
                + "AND qn.status = 1";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, quizId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String content = rs.getString(2);
                AnswerDAO ansDao = new AnswerDAO();
                ArrayList<Answer> listAns = ansDao.getListAnswer(id);
                ArrayList<Answer> isCorrectAnswer = ansDao.getCorrectAnswer(id);
                Question question = new Question(id, content, listAns, isCorrectAnswer);
                listQuestion.add(question);
            }
            return listQuestion;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Question> getListQuestionNotDone(int quizId, ArrayList<Integer> questionDone) {
        ArrayList<Question> listQuestion = new ArrayList<>();
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT qn.questionId, qn.Content FROM Question qn\n"
                    + "INNER JOIN QuestionQuiz qz\n"
                    + "ON qn.questionId = qz.QuestionID\n"
                    + "WHERE qz.QuizID = " + quizId + "\n" +
                    "AND qn.status = 1";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String content = rs.getString(2);
                boolean check = true;
                for (Integer integer : questionDone) {
                    if (id == integer) {
                        check = false;
                        break;
                    }
                }
                if (check == false) {
                    continue;
                }
                AnswerDAO ansDao = new AnswerDAO();
                ArrayList<Answer> listAns = ansDao.getListAnswer(id);
                ArrayList<Answer> isCorrectAnswer = ansDao.getCorrectAnswer(id);

                Question question = new Question(id, content, listAns, isCorrectAnswer);
                listQuestion.add(question);
            }
            return listQuestion;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        QuestionDAO dao = new QuestionDAO();
//        ArrayList<Integer> questionDone = new ArrayList<>();
//        ArrayList<Question> list = dao.getListQuestion("1");

        Question q = dao.getQuestionById("1");
        System.out.println(q);

//        ArrayList<Question> list = dao.getListQuestionNotDone(1,questionDone);
//        System.out.println(list);
    }

    public void delete(int id) {
        String query = "update Question set status = 0 where questionId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteAll(int[] selectedId) {
        String query = "update Question set status = 0 where questionId in (";
        query += Arrays.stream(selectedId).mapToObj(String::valueOf).collect(Collectors.joining(","));
        query += ")";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateQuestion(Question question) {
        String query = "update Question set content = ? where questionId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, question.getContent());
            ps.setInt(2, question.getQuestionId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int insert(Question question, int quizId) {
        String query = "insert into Question (content, quizId, status) values(?,?,1)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, question.getContent());
            ps.setInt(2, quizId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        int id = -1;
        String query2 = "select MAX(questionId) from Question";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query2);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        String query3 = "INSERT INTO QuestionQuiz ([questionId], [quizId]) VALUES (?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query3);
            ps.setInt(1, id);
            ps.setInt(2, quizId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }
}
