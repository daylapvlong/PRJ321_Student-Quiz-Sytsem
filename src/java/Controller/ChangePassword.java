/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.ChangeDAO;
import Dal.LoginDAO;
import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author admin's
 */
@WebServlet(name = "changePassword", urlPatterns = {"/change"})
public class ChangePassword extends HttpServlet {

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
        try {
                String mail = request.getParameter("email");
                String pass = request.getParameter("password");
                
                ChangeDAO dao = new ChangeDAO();
                Account a = dao.checkEmail(mail);
            
                if(a==null){
                    request.setAttribute("passmess", "<div class=\"alert\">\n" +
"                                                           <span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> \n" +
"                                                           <strong>Password dont match!</strong> Please try again.\n" +
"                                                       </div>");
                    request.getRequestDispatcher("ForgotLogin.jsp").forward(request,response);
                } else {
                    // do your change password here
                    try {
                        String newPassword = request.getParameter("repassword");
                        boolean acc = dao.changePassword(mail, newPassword);
                        
                        if (!pass.equals(newPassword)) {
                            //check pass va repass cp trung nhau k?
                            request.setAttribute("passmess", "<div class=\"alert\">\n"
                                    + "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> \n"
                                    + "<strong>Password dont match!</strong> Please try again.\n"
                                    + "</div>");
                            request.getRequestDispatcher("ForgotLogin.jsp").forward(request, response);
                        } else {
                            if (acc) {
                                // Password changed successfully
                                request.getRequestDispatcher("Login.jsp").forward(request,response);
                            } else {
                                // Password change failed
                                request.setAttribute("loginMess", "<div class=\"alert\">\n" +
    "                                                           <span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> \n" +
    "                                                           <strong>Something went wrong!</strong> Please try again.\n" +
    "                                                       </div>");
                                request.getRequestDispatcher("ForgotLogin.jsp").forward(request,response);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }              
                
            } catch(ServletException | IOException e){
                System.out.println(e);
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
