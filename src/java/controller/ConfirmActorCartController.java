/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Calamity;
import dto.Prop;
import dto.RegistrationDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CalamityBean;
import model.RegistrationBean;
import model.ActorCart;

/**
 *
 * @author Long
 */
public class ConfirmActorCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String cid = request.getParameter("id");
            HttpSession session = request.getSession();
            ActorCart cart = (ActorCart)session.getAttribute("actorCart");
            RegistrationBean rbean = new RegistrationBean();
            CalamityBean cbean = new CalamityBean();
            cbean.setId(cid);
            if (cart != null) {
                String filepath = (String) session.getAttribute("FILE");
                PrintWriter out = new PrintWriter(filepath);
                cbean.deleteAllActorRole();
                for (Map.Entry mapItem : cart.getCart().entrySet()) {
                    RegistrationDTO dto = (RegistrationDTO) mapItem.getValue();
                    cbean.insertActorRole(dto);
                    out.println("=== " + dto.getId() + "-" + dto.getFullname() + " ===\n" +
                                "Role Name: " + dto.getRoleName() + "\n" +
                                "Role Description: " + dto.getRoleDescription() + "\n\n");
                }
                out.close();
            }
            Calamity calamity = cbean.findCalamityById();
            request.setAttribute("ID", calamity.getId());
            request.setAttribute("NAME", calamity.getName());
            request.setAttribute("DESCRIPTION", calamity.getDescription());
            request.setAttribute("LOCATION", calamity.getLocation());
            request.setAttribute("STARTTIME", calamity.getStartTime());
            request.setAttribute("ENDTIME", calamity.getEndTime());
            request.setAttribute("TIMESHOOTING", calamity.getTimeShooting());
            request.setAttribute("PROPS", cbean.findPropsUsed());
            request.setAttribute("FILE", calamity.getFile());
            request.setAttribute("ROLES", cbean.findActorRole());
            session.removeAttribute("actorCart");
            session.removeAttribute("INFO");
        } catch (Exception e) {
            log("ERROR at ConfirmActorCartController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("admin/viewCalamityDetail.jsp").forward(request, response);
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
