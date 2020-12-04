/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Calamity;
import dto.ErrorObj;
import dto.RegistrationDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CalamityBean;

/**
 *
 * @author Long
 */
public class UpdateCalamityController extends HttpServlet {

    private static final String SUCCESS = "SearchCalamityController";
    private static final String INVALID = "admin/updateCalamity.jsp";
    private static final String ERROR = "error.jsp";
            
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String id = request.getParameter("txtId");
            String name = request.getParameter("txtName");
            String description = request.getParameter("txtDescription");
            String location = request.getParameter("txtLocation");
            String startTime = request.getParameter("txtStartTime");
            String endTime = request.getParameter("txtEndTime");
            int timeShooting = Integer.parseInt(request.getParameter("txtTimeShooting"));
            CalamityBean bean = new CalamityBean();
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
            if (location.length() == 0) {
                valid = false;
                errorObj.setLocationError("Location can't be blank");
            }
            if (!startTime.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}")) {  // yyyy-MM-ddThh:mm
                valid = false;
                errorObj.setStartTimeError("Start Time can't be blank");
            }
            if (!endTime.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}")) {
                valid = false;
                errorObj.setEndTimeError("End Time can't be blank");
            }
            if (startTime.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}")) {
                if (Integer.parseInt(startTime.substring(5, 7)) > Integer.parseInt(endTime.substring(5, 7))) {
                    valid = false;
                    errorObj.setStartTimeError("Start Time must < End Time");
                }
            } else if (endTime.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}")) {
                if (Integer.parseInt(startTime.substring(5, 7)) == Integer.parseInt(endTime.substring(5, 7))) {
                    if (Integer.parseInt(startTime.substring(8, 10)) > Integer.parseInt(endTime.substring(8, 10))) {
                        valid = false;
                        errorObj.setStartTimeError("Start Time must < End Time");
                    }
                }
            }
            if (timeShooting < 0) {
                valid = false;
                errorObj.setTimeShootingError("Time Shooting must >= 0");
            }
            String file = "C:\\Users\\USER\\Documents\\NetBeansProjects\\SE140019_TranThanhLong_TayDuKi\\Role\\" + id + ".txt";
            Calamity calamity = new Calamity(id, name, description, location, startTime, endTime, timeShooting, file);
            if (valid) {
                startTime = startTime.replace('T', ' ');
                endTime = endTime.replace('T', ' ');
                calamity = new Calamity(id, name, description, location, startTime, endTime, timeShooting, file);
                if (bean.updateCalamity(calamity)) 
                    url = SUCCESS;
            } else {
                url = INVALID;
                request.setAttribute("CALAMITY", calamity);
                request.setAttribute("INVALID", errorObj);
            }
        } catch (Exception e) {
            log("ERROR at UpdateCalamityController: " + e.getMessage());
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
