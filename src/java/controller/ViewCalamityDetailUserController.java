/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Calamity;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CalamityBean;

/**
 *
 * @author Long
 */
public class ViewCalamityDetailUserController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String id = request.getParameter("id");
            CalamityBean bean = new CalamityBean();
            bean.setId(id);
            Calamity calamity = bean.findCalamityById();

            request.setAttribute("ID", calamity.getId());
            request.setAttribute("NAME", calamity.getName());
            request.setAttribute("DESCRIPTION", calamity.getDescription());
            request.setAttribute("LOCATION", calamity.getLocation());
            request.setAttribute("STARTTIME", calamity.getStartTime());
            request.setAttribute("ENDTIME", calamity.getEndTime());
            request.setAttribute("TIMESHOOTING", calamity.getTimeShooting());
            request.setAttribute("PROPS", bean.findPropsUsed());
            request.setAttribute("ROLES", bean.findActorRole());
            request.setAttribute("FILE", calamity.getFile());
        } catch (Exception e) {
            log("ERROR at ViewCalamityDetailUserController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("actor/viewCalamityDetail.jsp").forward(request, response);
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
