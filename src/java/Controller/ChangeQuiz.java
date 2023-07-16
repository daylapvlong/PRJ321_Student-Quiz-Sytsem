/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.AnswerDAO;
import Dal.ChangeDAO;
import Dal.CourseDAO;
import Dal.QuestionDAO;
import Model.Answer;
import Model.Question;
import Model.Quiz;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.*;

/**
 *
 * @author admin's
 */
@WebServlet(name = "ChangeQuiz", urlPatterns = {"/changeQuiz"})
public class ChangeQuiz extends HttpServlet {

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
        String quizid = request.getParameter("quizid");
        int quzid = Integer.parseInt(quizid);
        
        CourseDAO dao = new CourseDAO();
        QuestionDAO qdao = new QuestionDAO();
        AnswerDAO adao = new AnswerDAO();
        
        Quiz quiz = dao.getQuizById(quizid);
        ArrayList<Question> listQuestion = qdao.getListQuestion(quizid);
        Map<Integer, List<Answer>> listAnswer = new HashMap<>();
        for (Question question : listQuestion) {
            listAnswer.put(question.getQuestionId(), adao.getListAnswer(question.getQuestionId()));
        }

        request.setAttribute("displayquiz", listQuestion);
        request.setAttribute("displayanswer", listAnswer);
        request.setAttribute("q_update",quiz);
        request.getRequestDispatcher("QuizUpdate.jsp").forward(request, response);
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
        String quizId = request.getParameter("quizId");
        String deleteId = request.getParameter("delete");
        String deleteAll = request.getParameter("delete-all");
        if (deleteId != null) {
            int id = Integer.parseInt(deleteId);
            QuestionDAO questionDAO = new QuestionDAO();
            questionDAO.delete(id);
        } else if (deleteAll != null) {
            String [] selected = request.getParameterValues("selected-question");
            int [] selectedId = Arrays.stream(selected == null? new String[0] : selected).mapToInt(Integer::parseInt).toArray();
            QuestionDAO questionDAO = new QuestionDAO();
            questionDAO.deleteAll(selectedId);
        }
        response.sendRedirect("changeQuiz?quizid=" + quizId);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
