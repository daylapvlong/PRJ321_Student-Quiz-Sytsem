/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.CourseDAO;
import Model.Course;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin's
 */
@WebServlet(name = "CreateCourse", urlPatterns = {"/createCourse"})
public class CreateCourse extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateCourse</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateCourse at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String name = request.getParameter("courseName");
        String description = request.getParameter("description");
        String semester = request.getParameter("semester");
        
        if (name == null){
            request.setAttribute("namemess", "<div class=\"alert\">\n"
                        + "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> \n"
                        + "Please <strong>enter the course name</strong> \n"
                        + "</div>");
            request.getRequestDispatcher("CreateCourse.jsp").forward(request, response);
        } else if (description == null){
            request.setAttribute("desmess", "<div class=\"alert\">\n"
                        + "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> \n"
                        + "Please <strong>enter the course description</strong> \n"
                        + "</div>");
            request.getRequestDispatcher("CreateCourse.jsp").forward(request, response);
        } else if (semester == null){
            request.setAttribute("radiomess", "<div class=\"alert\">\n"
                        + "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> \n"
                        + "Please <strong>enter the course semester</strong> \n"
                        + "</div>");
            request.getRequestDispatcher("CreateCourse.jsp").forward(request, response);
        } else {
            CourseDAO dao = new CourseDAO();
            Course c = dao.checkCourseExisted(name);
            
            if(c == null){
                dao.createCourse(name, description, semester);
                response.sendRedirect("home");
            } else {
                request.setAttribute("checkmess", "<div class=\"alert\">\n" +
"                                    <span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> \n" +
"                                    <strong>Course existed!</strong> Please try again.\n" +
"                                    </div>");
                request.getRequestDispatcher("CreateCourse.jsp").forward(request,response);
            }
        }
        
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
