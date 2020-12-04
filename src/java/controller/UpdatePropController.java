/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Prop;
import dto.ErrorObj;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PropBean;

/**
 *
 * @author Long
 */
public class UpdatePropController extends HttpServlet {

    private static final String SUCCESS = "SearchPropController";
    private static final String INVALID = "admin/updateProp.jsp";
    private static final String ERROR = "error.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String id = request.getParameter("txtId");
            String name = request.getParameter("txtName");
            String description = request.getParameter("txtDescription");
            String image = request.getParameter("txtImage");
            int amount = Integer.parseInt(request.getParameter("txtAmount"));
            String status = request.getParameter("txtStatus");
            boolean valid = true;
            ErrorObj errorObj = new ErrorObj();
            if (id.length() == 0) {
                valid = false;
                errorObj.setIdError("ID can't be blank");
            }
            if (name.length() == 0) {
                valid = false;
                errorObj.setNameError("Name can't be blank");
            }
            if (description.length() == 0) {
                valid = false;
                errorObj.setDescriptionError("Description can't be blank");
            }
            if (image.length() == 0) {
                valid = false;
                errorObj.setImageError("Image can't be blank");
            }
            if (amount < 0) {
                valid = false;
                errorObj.setAmountError("Amount must >= 0");
            }
            if (status.length() == 0) {
                valid = false;
                errorObj.setStatusError("Status can't be blank");
            }
            Prop prop = new Prop(id, name, description, image, amount, status);
            if (valid) {
                PropBean bean = new PropBean();
                if (bean.updateProp(prop))
                    url = SUCCESS;
            } else {
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
                request.setAttribute("PROP", prop);
            }
            
        } catch (Exception e) {
            log("ERROR at UpdatePropController: " + e.getMessage()); 
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
