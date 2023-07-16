/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.LoginDAO;
import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.NumberToEnum.UserRole;

/**
 *
 * @author admin's
 */
public class Login extends HttpServlet {

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
            try {
                String mail = request.getParameter("email");
                String pass = request.getParameter("password");
                String remember = request.getParameter("remember");
                
                // set cookie for email and password
                Cookie cookie1 = new Cookie("email", mail);
                cookie1.setMaxAge(60 * 60 * 24);
                Cookie cookie2 = new Cookie("password", pass);
                if (remember != null) {
                    cookie2.setMaxAge(60 * 60 * 24);
                } else {
                    cookie2.setMaxAge(0);
                }
                response.addCookie(cookie1);
                response.addCookie(cookie2);
                
                LoginDAO login= new LoginDAO();
                Account a = login.checkLogin(mail,pass);
                if(a==null){
                    request.setAttribute("loginMess", "<div class=\"alert\">\n" +
"                                                       <span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> \n" +
"                                                       <strong>Wrong user login!</strong> Please try again.\n" +
"                                                       </div>");
                    request.getRequestDispatcher("Login.jsp").forward(request,response);
                } else {                    
                    // Store user information in session
                    HttpSession session = request.getSession();
                    if (a.getIsTeacher() == UserRole.ADMIN.getValue()) {                       
                        session.removeAttribute("role");
                        session.setAttribute("role", UserRole.ADMIN.getValue());
                        session.setAttribute("acc", a);
                        session.setAttribute("name", a.getName());
                        response.sendRedirect("home");
                    } else {
                        session.removeAttribute("role");
                        session.setAttribute("role", UserRole.USER.getValue());
                        session.setAttribute("acc", a);
                        session.setAttribute("name", a.getName());
                        response.sendRedirect("home");
                    }                
                    
                }
            } catch(ServletException | IOException e){
                System.out.println(e);
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
//        processRequest(request, response);
        
        Cookie[] cookies = request.getCookies();
        if(cookies!=null)
        {
            for (Cookie cooky : cookies) {
                if(cooky.getName().equals("emailC")){
                    request.setAttribute("email",cooky.getValue());
                }
                
                if(cooky.getName().equals("passC")){
                    request.setAttribute("password",cooky.getValue());
                }
            }
            
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
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
