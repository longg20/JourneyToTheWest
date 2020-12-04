/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PropBean;
import model.PropCart;

/**
 *
 * @author Long
 */
public class UpdatePropCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String cid = request.getParameter("cid");
            String pid = request.getParameter("pid");
            String quantityString = request.getParameter("txtQuantity");
            int quantity;
            if (quantityString.length() == 0)
                quantity = 0;
            else
                quantity = Integer.parseInt(quantityString);
            if (quantity < 0)
                quantity = 0;
            
            PropBean bean = new PropBean();
            bean.setId(pid);
            if (bean.findPropById().getAmount() < quantity)
                quantity = bean.findPropById().getAmount();
                
            HttpSession session = request.getSession();
            PropCart cart = (PropCart) session.getAttribute("propCart");
            
            cart.update(pid, quantity);
            session.setAttribute("propCart", cart);
            request.setAttribute("ID", cid);
        } catch (Exception e) {
            log("ERROR at UpdatePropCartController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("admin/addProp.jsp").forward(request, response);
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
