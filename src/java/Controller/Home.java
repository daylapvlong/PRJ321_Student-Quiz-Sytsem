/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.ChangeDAO;
import Dal.HomeDAO;
import Dal.LoginDAO;
import Model.Account;
import Model.Category;
import Model.Course;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;
import utils.NumberToEnum;

/**
 *
 * @author admin's
 */
@WebServlet(name = "Home", urlPatterns = {"/home"})
public class Home extends HttpServlet {

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
        
        String indexPage = request.getParameter("index");
        int index;
        if (indexPage != null && !indexPage.isEmpty()) {
            try {
                index = Integer.parseInt(indexPage);
            } catch (NumberFormatException e) {
                // Handle the case when indexPage is not a valid integer
                // Set a default value or show an error message
                index = 1; // Default value, you can change it as needed
            }
        } else {
            index = 1; // Default value, you can change it as needed
        }

        HomeDAO dao = new HomeDAO();
        ChangeDAO changeDao = new ChangeDAO();
        List<Account> list = changeDao.getAllAccount();
//        List<Course> list = dao.getAllCourse();
        List<Course> listP = dao.pagingCourse(index);
        List<Category> listC = dao.getAllCategory();
        int count = dao.getAllCount();
        int endPage = count / 8;
        if (count % 8 != 0) {
            endPage++;
        }

        request.setAttribute("listAccount", list);
        request.setAttribute("listPaging", listP);
        request.setAttribute("tag", index);
        request.setAttribute("listCategory", listC);
        request.setAttribute("endP", endPage);
        request.getRequestDispatcher("Home.jsp").forward(request, response);

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
