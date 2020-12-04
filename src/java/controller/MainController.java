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

/**
 *
 * @author Long
 */
public class MainController extends HttpServlet {

    private static final String ERROR           = "error.jsp";
    //private static final String LOGIN           = "LoginController";
    private static final String LOGOUT          = "LogoutController";
    private static final String RETURN          = "ReturnController";
    private static final String INSERT          = "InsertController";
    
    private static final String INSERT_ACTOR    = "InsertActorController";
    private static final String INSERT_PROP     = "InsertPropController";
    private static final String INSERT_CALAMITY = "InsertCalamityController";
    
    private static final String EDIT_ACTOR      = "EditActorController";
    private static final String EDIT_PROP       = "EditPropController";
    private static final String EDIT_CALAMITY   = "EditCalamityController";
    
    private static final String UPDATE_ACTOR    = "UpdateActorController";
    private static final String UPDATE_PROP     = "UpdatePropController";
    private static final String UPDATE_CALAMITY = "UpdateCalamityController";
    
    private static final String SEARCH_ACTOR    = "SearchActorController";
    private static final String SEARCH_PROP     = "SearchPropController";
    private static final String SEARCH_CALAMITY = "SearchCalamityController";
    
    private static final String DELETE_ACTOR    = "DeleteActorController";
    private static final String DELETE_PROP     = "DeletePropController";
    private static final String DELETE_CALAMITY = "DeleteCalamityController";
    
    private static final String VIEW_CALAMITY_DETAIL = "ViewCalamityDetailController";
    
    private static final String ADD_PROP_CART        = "AddPropCartController";
    private static final String VIEW_PROP_CART       = "ViewPropCartController";
    private static final String CONFIRM_PROP_CART    = "ConfirmPropCartController";
    private static final String UPDATE_PROP_CART     = "UpdatePropCartController";
    private static final String DELETE_PROP_CART     = "DeletePropCartController";
    
    private static final String VIEW_ACTOR_CART      = "ViewActorCartController";
    private static final String ADD_ACTOR_CART       = "AddActorCartController";
    private static final String CONFIRM_ACTOR_CART   = "ConfirmActorCartController";
    private static final String UPDATE_ACTOR_CART    = "UpdateActorCartController";
    private static final String DELETE_ACTOR_CART    = "DeleteActorCartController";

    private static final String SEARCH_ALL           = "SearchCalamityUserController";
    private static final String SEARCH_FINISHED      = "SearchCalamityUserController";
    private static final String SEARCH_ONGOING       = "SearchCalamityUserController";
    private static final String SEARCH_UPCOMING      = "SearchCalamityUserController";
    private static final String VIEW_CALAMITY_DETAIL_USER = "ViewCalamityDetailUserController";
    
    private static final String CONFIRM_EDIT         = "ConfirmEditController";
    private static final String DOWNLOAD             = "DownloadController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
//            if (action.equals("Login"))
//                url = LOGIN;
            if (action.equals("Log Out"))
                url = LOGOUT;
            else if (action.equals("Return"))
                url = RETURN;
            else if (action.equals("Insert"))
                url = INSERT;
            
            else if (action.equals("Insert Actor"))
                url = INSERT_ACTOR;
            else if (action.equals("Insert Prop"))
                url = INSERT_PROP;
            else if (action.equals("Insert Calamity"))
                url = INSERT_CALAMITY;
            
            else if (action.equals("Search Actor"))
                url = SEARCH_ACTOR;
            else if (action.equals("Search Prop"))
                url = SEARCH_PROP;
            else if (action.equals("Search Calamity"))
                url = SEARCH_CALAMITY;
            
            else if (action.equals("Edit Actor"))
                url = EDIT_ACTOR;
            else if (action.equals("Edit Prop"))
                url = EDIT_PROP;
            else if (action.equals("Edit Calamity"))
                url = EDIT_CALAMITY;
            
            else if (action.equals("Update Actor"))
                url = UPDATE_ACTOR;
            else if (action.equals("Update Prop"))
                url = UPDATE_PROP;
            else if (action.equals("Update Calamity"))
                url = UPDATE_CALAMITY;
            
            else if (action.equals("Delete Actor"))
                url = DELETE_ACTOR;
            else if (action.equals("Delete Prop"))
                url = DELETE_PROP;
            else if (action.equals("Delete Calamity"))
                url = DELETE_CALAMITY;
            
            else if (action.equals("Add to Prop Cart"))
                url = ADD_PROP_CART;
            else if (action.equals("Add to Actor Cart"))
                url = ADD_ACTOR_CART;
            else if (action.equals("View Prop Cart"))
                url = VIEW_PROP_CART;
            else if (action.equals("View Actor Cart"))
                url = VIEW_ACTOR_CART;
            else if (action.equals("Confirm Add to Calamity"))
                url = CONFIRM_PROP_CART;
            else if (action.equals("Confirm Add Role to Calamity"))
                url = CONFIRM_ACTOR_CART;
            else if (action.equals("Update"))
                url = UPDATE_PROP_CART;
            else if (action.equals("Delete"))
                url = DELETE_PROP_CART;
            else if (action.equals("Update Description"))
                url = UPDATE_ACTOR_CART;
            else if (action.equals("Delete Role"))
                url = DELETE_ACTOR_CART;
            else if (action.equals("View Calamity Detail"))
                url = VIEW_CALAMITY_DETAIL;
            
            else if (action.equals("View Finished Calamities"))
                url = SEARCH_FINISHED;
            else if (action.equals("View Ongoing Calamities"))
                url = SEARCH_ONGOING;
            else if (action.equals("View Upcoming Calamities"))
                url = SEARCH_UPCOMING;
            else if (action.equals("View Calamity"))
                url = SEARCH_ALL;
            else if (action.equals("View Calamity Detail By User"))
                url = VIEW_CALAMITY_DETAIL_USER;
            
            else if (action.equals("Confirm Edit"))
                url = CONFIRM_EDIT;
            else if (action.equals("Download"))
                url = DOWNLOAD;
            
            else
                request.setAttribute("ERROR", "Invalid action!");               
        } catch (Exception e) {
            log("ERROR at MainController: " + e.getMessage());
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
