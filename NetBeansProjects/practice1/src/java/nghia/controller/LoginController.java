    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nghia.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nghia.models.RegistrationDAO;

/**
 *
 * @author mickw
 */
public class LoginController extends HttpServlet {
private static String ERROR = "Error.jsp";
private static String ADMIN= "AdminInterface.jsp";
private static String USER = "UserInterface.jsp";
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
       String url = ERROR;
        try {
            String username = request.getParameter("txtUsername");
            System.out.println(username);
                    
            String password = request.getParameter("txtPassword");
            System.out.println(password);
            RegistrationDAO dao = new RegistrationDAO();
            String role = dao.checkLogin(username, password);
            System.out.println(role);
            if(role.equals("failed")){
                request.setAttribute("Error", "Username or password is wrong");
            } else if(role.equalsIgnoreCase("Admin")) {
                url = ADMIN;
            } else if(role.equalsIgnoreCase("User")){
                url = USER;
            }else {
                request.setAttribute("ERROR", "Your role is not supported");
            }
        } catch (Exception e) {
            log("Error at LoginController "+ e.getMessage());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
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
