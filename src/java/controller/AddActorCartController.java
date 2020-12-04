/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.ErrorObj;
import dto.RegistrationDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.RegistrationBean;
import model.ActorCart;

/**
 *
 * @author Long
 */
public class AddActorCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String cid = request.getParameter("id");
            String aid = request.getParameter("actorList");
            String roleName = request.getParameter("txtRoleName");
            String roleDescription = request.getParameter("txtRoleDescription");
            String key = (aid + roleName).toLowerCase();
            boolean valid = true;
            ErrorObj errorObj = new ErrorObj();
            if (roleName.length() == 0) {
                valid = false;
                errorObj.setRoleNameError("Role Name can't be blank");
            }
            if (roleDescription.length() == 0) {
                valid = false;
                errorObj.setRoleDescriptionError("Role Description can't be blank");
            }
            
            RegistrationBean rbean = new RegistrationBean();
            rbean.setId(aid);
            RegistrationDTO dto = rbean.findActorById();
            dto.setRoleName(roleName);
            dto.setRoleDescription(roleDescription);
            
            HttpSession session = request.getSession();
            ActorCart cart = (ActorCart)session.getAttribute("actorCart");
            
            if (cart.getCart().containsKey(key)) {
                valid = false;
                errorObj.setRoleNameError("Actor already has that role");
            }
            if (valid) 
                cart.addToCart(key, dto);
            else
                request.setAttribute("INVALID", errorObj);
            request.setAttribute("ID", cid);
            session.setAttribute("actorCart", cart);
        } catch (Exception e) {
            log("ERROR at AddActorCartController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("admin/addActor.jsp").forward(request, response);
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
