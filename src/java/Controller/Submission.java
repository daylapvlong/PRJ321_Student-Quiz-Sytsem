package Controller;

import Dal.ChangeDAO;
import java.io.IOException;
import java.io.PrintWriter;

import Dal.SubmissionDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin's
 */
@WebServlet(name = "DeleteQuiz", urlPatterns = {"/deleteQuiz"})
public class Submission extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SubmissionDAO dao = new SubmissionDAO();
    }


}
