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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PropBean;
import model.PropCart;
import model.CalamityBean;

/**
 *
 * @author Long
 */
public class AddPropCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String cid = request.getParameter("id");
            String pid = request.getParameter("propList");
            String quantityString = request.getParameter("txtQuantity");
            int quantity;
            if (quantityString.length() == 0)
                quantity = 0;
            else
                quantity = Integer.parseInt(quantityString);
            
            boolean valid = true;
            ErrorObj errorObj = new ErrorObj();
            if (quantity < 0) {
                valid = false;
                errorObj.setQuantityError("Quantity must >=0");
            }
            
            PropBean pbean = new PropBean();
            pbean.setId(pid);
            Prop prop = pbean.findPropById();
            prop.setQuantity(quantity);
            
            HttpSession session = request.getSession();
            PropCart cart = (PropCart)session.getAttribute("propCart");
            if (cart.getCart().get(pid) != null) {
                if (prop.getAmount() < cart.getCart().get(pid).getQuantity() + quantity) {
                    valid = false;
                    errorObj.setExceedError("Exceed the maximum amount!");
                }
            } else {
                if (prop.getAmount() < prop.getQuantity()) {
                    valid = false;
                    errorObj.setExceedError("Exceed the maximum amount!");
                }
            }
            if (valid) 
                cart.addToCart(prop);
            else
                request.setAttribute("INVALID", errorObj);
            request.setAttribute("ID", cid);
            session.setAttribute("propCart", cart);

        } catch (Exception e) {
            log("ERROR at AddPropCartController: " + e.getMessage());
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
