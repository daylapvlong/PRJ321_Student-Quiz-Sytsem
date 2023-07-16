/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.AnswerDAO;
import Dal.CourseDAO;
import Dal.QuestionDAO;
import Model.Answer;
import Model.Question;
import Model.Quiz;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author admin's
 */
@WebServlet(name = "QuizDisplay", urlPatterns = {"/quizdisplay"})
public class QuizDisplay extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String quizId = request.getParameter("quizid");
        int quzId = 0;

        if (quizId != null && !quizId.isEmpty()) {
            quzId = Integer.parseInt(quizId);
        }

        CourseDAO cdao = new CourseDAO();
        QuestionDAO qdao = new QuestionDAO();

        Quiz quiz = cdao.getQuizById(quizId);
        ArrayList<Question> listQuestion = qdao.getListQuestion(quizId);

        Object res = new Object() {
            ArrayList<Question> questions = listQuestion;
        };

        Gson gson = new Gson();
        response.getWriter().write(gson.toJson(listQuestion));
    }
}
