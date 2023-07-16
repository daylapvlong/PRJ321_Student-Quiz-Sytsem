/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.SignUpDAO;
import Model.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author admin's
 */
public class SignUp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String name = request.getParameter("name");
            String mail = request.getParameter("email");
            String pass = request.getParameter("password");
            String re_pass = request.getParameter("re_pass");
            String radio = request.getParameter("radiogroup");
            String checkbox = request.getParameter("agree-term");

            if (checkbox == null) {
                //tick terms of agreement
                request.setAttribute("checkmess", "<div class=\"alert\">\n"
                        + "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> \n"
                        + "Please <strong>agree</strong> with our terms\n"
                        + "</div>");
                request.getRequestDispatcher("SignUp.jsp").forward(request, response);
            } else if (radio == null) {
                //tick terms of agreement
                request.setAttribute("radiomess", "<div class=\"alert\">\n"
                        + "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> \n"
                        + "Please <strong>Select</strong> your position\n"
                        + "</div>");
                request.getRequestDispatcher("SignUp.jsp").forward(request, response);
            } else if (!pass.equals(re_pass)) {
                //check pass va repass cp trung nhau k?
                request.setAttribute("passmess", "<div class=\"alert\">\n"
                        + "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> \n"
                        + "<strong>Password dont match!</strong> Please try again.\n"
                        + "</div>");
                request.getRequestDispatcher("SignUp.jsp").forward(request, response);
            } else {
                SignUpDAO signup = new SignUpDAO();
                Account a = signup.checkAccountExist(mail);
                if (a == null) {
                    //dc signup
                    if (radio.equals("0")) {
                        // User selected "student"
                        // Perform student registration logic here
                        // Redirect or forward to student registration page
                        signup.signup(name, mail, pass, radio);
                        response.sendRedirect("Login.jsp");
                    } else {
                        // User selected "teacher"
                        // Perform teacher registration logic here
                        // Redirect or forward to teacher registration page
                        signup.signup(name, mail, pass, radio);
                        response.sendRedirect("LoginTeacher.jsp");
                    }
                } else {
                    //quay lai signup
                    request.setAttribute("existedmess", "<div class=\"alert\">\n"
                                        + "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> \n"
                                        + "<strong>Email existed!</strong> Please try again.\n"
                                        + "</div>");
                    request.getRequestDispatcher("SignUp.jsp").forward(request, response);
                }
            }
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
