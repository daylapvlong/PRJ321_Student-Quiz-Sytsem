package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Dal.AnswerDAO;
import Dal.ChangeDAO;
import Dal.CourseDAO;
import Dal.QuestionDAO;
import Model.Answer;
import Model.Question;
import Model.Quiz;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin's
 */
@WebServlet(name = "ChangeQuizQuestion", urlPatterns = {"/changeQuizQuestion"})
public class ChangeQuizQuestion extends HttpServlet {

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String questionid = request.getParameter("questionid");
        int quesid = Integer.parseInt(questionid);

        QuestionDAO qdao = new QuestionDAO();
        AnswerDAO adao = new AnswerDAO();

        Question ques = qdao.getQuestionById(questionid);
        ArrayList<Answer> ans = adao.getListAnswer(quesid);

        request.setAttribute("displayquestion", ques);
        request.setAttribute("displayanswer", ans);
        request.getRequestDispatcher("QuizUpdateQuestion.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String questionid = request.getParameter("id");
        int quesid = Integer.parseInt(questionid);
        BufferedReader reader = request.getReader();
        Gson gson = new Gson(); // Or any other JSON library
        List<Answer> listAnswer = gson.fromJson(reader, new TypeToken<List<Answer>>() {}.getType());

        String question = request.getParameter("question");
        String answer = request.getParameter("answer");
        String isCorrectAnswer = request.getParameter("radio");

        ChangeDAO dao = new ChangeDAO();
        dao.updateQuizQuestion(question, quesid, listAnswer);
        
        response.sendRedirect(request.getHeader("referer"));
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
