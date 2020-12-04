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
import model.RegistrationBean;

/**
 *
 * @author Long
 */
public class UpdateActorController extends HttpServlet {

    private static final String SUCCESS = "SearchActorController";
    private static final String INVALID = "admin/updateActor.jsp";
    private static final String ERROR = "error.jsp";
            
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String id = request.getParameter("txtId");
            String password = request.getParameter("txtPassword");
            String confirm = request.getParameter("txtConfirm");
            String fullname = request.getParameter("txtFullname");
            String image = request.getParameter("txtImage");
            String description = request.getParameter("txtDescription");
            String phone = request.getParameter("txtPhone");
            String email = request.getParameter("txtEmail");
            boolean valid = true;
            ErrorObj errorObj = new ErrorObj();
            if (id.length() == 0) {
                valid = false;
                errorObj.setIdError("ID can't be blank");
            }
            if (password.length() == 0) {
                valid = false;
                errorObj.setPasswordError("Password can't be blank");
            }
            if (!confirm.equals(password)) {
                valid = false;
                errorObj.setConfirmError("Confirm must match password");
            }
            if (fullname.length() == 0) {
                valid = false;
                errorObj.setFullnameError("Fullname can't be blank");
            }
            if (image.length() == 0) {
                valid = false;
                errorObj.setImageError("Image can't be blank");
            }
            if (description.length() == 0) {
                valid = false;
                errorObj.setDescriptionError("Description can't be blank");
            }
            if (!phone.matches("[0-9]{10}")) {
                valid = false;
                errorObj.setPhoneError("Phone must be 10 digits only");
            }
            if (!email.matches("([a-zA-Z0-9[-][_]]{3,15})(@)([a-zA-Z]{3,10})([.])([a-zA-Z]{1,10})([.][a-zA-Z]{1,10})?")) {
                valid = false;
                errorObj.setEmailError("Email must follow format username@domain.abc");
            }
            RegistrationDTO dto = new RegistrationDTO(id, fullname, image, description, phone, email, "actor");
            dto.setPassword(password);
            if (valid) {
                RegistrationBean bean = new RegistrationBean();
                if (bean.updateActor(dto)) {
                    bean.insertEdit(dto.getId());
                    url = SUCCESS;
                }
            } else {
                url = INVALID;
                request.setAttribute("DTO", dto);
                request.setAttribute("INVALID", errorObj);
            }
            
        } catch (Exception e) {
            log("ERROR at UpdateActorController: " + e.getMessage());
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
