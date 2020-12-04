/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.RegistrationDTO;
import dto.ErrorObj;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.RegistrationBean;

/**
 *
 * @author Long
 */
public class LoginController extends HttpServlet {

    private static final String ADMIN = "admin/admin.jsp";
    private static final String ACTOR = "actor/actor.jsp";
    private static final String ERROR = "error.jsp";
    private static final String INVALID = "index.jsp";
            
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String id = request.getParameter("txtId");
            String password = request.getParameter("txtPassword");
            boolean valid = true;
            
            ErrorObj errorObj = new ErrorObj();
            if (id.length() == 0) {
                errorObj.setIdError("ID can't be blank!");
                valid = false;
            }
            if (password.length() == 0) {
                errorObj.setPasswordError("Password can't be blank!");
                valid = false;
            }
            
            if (valid) {
                HttpSession session = request.getSession();
                RegistrationBean bean = new RegistrationBean();
                bean.setId(id);
                bean.setPassword(password);
                RegistrationDTO dto = bean.checkLogin();
                if (dto == null) {
                    request.setAttribute("ERROR", "Invalid username or password!");
                } else {
                    if (dto.getRole().equals("admin")) 
                        url = ADMIN;
                    else if (dto.getRole().equals("actor")) {
                        url = ACTOR;
                        session.setAttribute("EDIT", bean.findEdit(id));
                    }
                    else {
                        url = ERROR;
                        request.setAttribute("ERROR", "Invalid role!");
                    }
                    session.setAttribute("ID", dto.getId());
                    session.setAttribute("FULLNAME", dto.getFullname());
                    session.setAttribute("IMAGE", dto.getImage());
                    session.setAttribute("DESCRIPTION", dto.getDescription());
                    session.setAttribute("PHONE", dto.getPhone());
                    session.setAttribute("EMAIL", dto.getEmail());
                    session.setAttribute("ROLE", dto.getRole());
                }
            } else {
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
            }
            
        } catch (Exception e) { 
            log("ERROR at LoginController: " + e.getMessage());
        } finally {
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
