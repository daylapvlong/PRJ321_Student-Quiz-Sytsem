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
import java.util.ArrayList;

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
        ArrayList<Answer> listAnswer = adao.getListAnswer(quzid);

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
        String quizname = request.getParameter("quizname");
        String Duration = request.getParameter("time");
        String quizid = request.getParameter("quizid");

        ChangeDAO dao = new ChangeDAO();
        dao.updateQuiz(quizid, quizname, Duration);
        response.sendRedirect("home");
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
