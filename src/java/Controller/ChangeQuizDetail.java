/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.AnswerDAO;
import Dal.CourseDAO;
import Dal.QuestionDAO;
import Dal.QuizDAO;
import Model.Answer;
import Model.Question;
import Model.Quiz;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

/**
 * @author admin's
 */
@WebServlet(name = "ChangeQuizDetail", urlPatterns = {"/changeQuizDetail"})
public class ChangeQuizDetail extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
        request.setAttribute("q_update", quiz);
        request.getRequestDispatcher("QuizUpdateDetail.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String quizId = request.getParameter("quizId");
        String quizName = request.getParameter("quizname");
//        String quizTime = request.getParameter("quiztime"); TODO: change quiztime
        QuizDAO quizDAO = new QuizDAO();
        quizDAO.updateQuiz(quizId, quizName);
        String[] questionId = request.getParameterValues("questionId");
        if (questionId == null) {
            response.sendRedirect("changeQuizDetail?quizid=" + quizId);
            return;
        }
        String[] deleteAnswerIds = request.getParameterValues("delete-answer-id");
        if (deleteAnswerIds != null) {
            AnswerDAO dao = new AnswerDAO();
            dao.deleteAllAnswer(deleteAnswerIds);
        }
        for (String qid : questionId) {
            String questionContent = request.getParameter("question-content-" + qid);
            String[] answerIds = request.getParameterValues("answer-id-" + qid);
            String[] answerContents = request.getParameterValues("answer-content-" + qid);
            String answerCorrect = request.getParameter("radio-" + qid);
            String[] addAnswerIds = request.getParameterValues("added-answer-id-" + qid);
            String[] addAnswerContents = request.getParameterValues("added-answer-content-" + qid);
            addAnswerIds = addAnswerIds == null && answerIds == null ? new String[]{"0"} : addAnswerIds;
            addAnswerIds = addAnswerIds == null ? new String[0] : addAnswerIds;
            answerCorrect = answerCorrect == null ? answerIds == null ? addAnswerIds[0] : answerIds[0] : answerCorrect;
            answerIds = answerIds == null ? new String[0] : answerIds;
            answerCorrect = Arrays.asList(addAnswerIds).contains(answerCorrect) || Arrays.asList(answerIds).contains(answerCorrect)? answerCorrect : addAnswerIds[0];
            // Update question content
            QuestionDAO qdao = new QuestionDAO();
            Question question = qdao.getQuestionById(qid);
            question.setContent(questionContent);
            qdao.updateQuestion(question);
            // Update remaining answers
            for (int i = 0; i < answerIds.length; i++) {
                AnswerDAO dao = new AnswerDAO();
                Answer answer = dao.getAnswerById(answerIds[i]);
                answer.setContent(answerContents[i]);
                answer.setIsCorrectAnswer(answerCorrect.equals(answerIds[i]));
                dao.updateAnswer(answer);
            }

            // Add new answers
            for (int i = 0; i < addAnswerIds.length; i++) {
                AnswerDAO dao = new AnswerDAO();
                Answer answer = new Answer();
                answer.setContent(addAnswerContents == null? "Default answer" : addAnswerContents[i]);
                answer.setIsCorrectAnswer(answerCorrect.equals(addAnswerIds[i]));
                answer.setQuestionId(Integer.parseInt(qid));
                dao.addAnswer(answer);
            }
        }
        String [] addQuestionIds = request.getParameterValues("added-questionId");
        for (String qid : addQuestionIds) {
            String questionContent = request.getParameter("added-question-content-" + qid);
            String answerCorrect = request.getParameter("radio-" + qid);
            String[] addAnswerIds = request.getParameterValues("added-answer-id-" + qid);
            String[] addAnswerContents = request.getParameterValues("added-answer-content-" + qid);
            addAnswerIds = addAnswerIds == null ? new String[] {"0"} : addAnswerIds;
            answerCorrect = answerCorrect == null ?  addAnswerIds[0] :  answerCorrect;
            answerCorrect = Arrays.asList(addAnswerIds).contains(answerCorrect) ? answerCorrect : addAnswerIds[0];
            // Add question content
            Question question = new Question();
            question.setContent(questionContent);
            QuestionDAO qdao = new QuestionDAO();
            int id = qdao.insert(question, Integer.parseInt(quizId));

            // Add new answers
            for (int i = 0; i < addAnswerIds.length; i++) {
                AnswerDAO dao = new AnswerDAO();
                Answer answer = new Answer();
                answer.setContent(addAnswerContents == null? "Default answer" : addAnswerContents[i]);
                answer.setIsCorrectAnswer(answerCorrect.equals(addAnswerIds[i]));
                answer.setQuestionId(id);
                dao.addAnswer(answer);
            }
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
