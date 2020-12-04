/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Long
 */
public class RoleFilter implements Filter {
    
    private static final boolean debug = true;
    private static final String LOGIN = "index.jsp";

    private FilterConfig filterConfig = null;
    
    private final List<String> guest;
    private final List<String> actor;
    private final List<String> admin;
    
    public RoleFilter() {
        guest = new ArrayList<>();
        guest.add("index.jsp");
        guest.add("error.jsp");
        guest.add("LoginController");
        
        actor = new ArrayList<>();
        actor.add("index.jsp");
        actor.add("error.jsp");
        actor.add("actor/actor.jsp");
        actor.add("actor/viewCalamity.jsp");
        actor.add("actor/viewCalamityDetail.jsp");
        actor.add("MainController");
        actor.add("LoginController");
        
        admin = new ArrayList<>();
        admin.add("index.jsp");
        admin.add("error.jsp");
        admin.add("admin/admin.jsp");
        admin.add("admin/addActor.jsp");
        admin.add("admin/addProp.jsp");
        admin.add("admin/insertProp.jsp");
        admin.add("admin/insertActor.jsp");
        admin.add("admin/insertCalamity.jsp");
        admin.add("admin/updateProp.jsp");
        admin.add("admin/updateActor.jsp");
        admin.add("admin/updateCalamity.jsp");
        admin.add("admin/viewProp.jsp");
        admin.add("admin/viewActor.jsp");
        admin.add("admin/viewCalamity.jsp");
        admin.add("admin/viewCalamityDetail.jsp");
        admin.add("MainController");
        admin.add("LoginController");
    }    
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("RoleFilter:DoBeforeProcessing");
        }
    }    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("RoleFilter:DoAfterProcessing");
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        String url = LOGIN;
        
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        
        HttpSession session = req.getSession();
        String role = (String)session.getAttribute("ROLE");
        String uri = req.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String resource = uri.substring(lastIndex + 1);
        System.out.println("uri = " + uri);
        System.out.println("resource = " + resource);
        if (role == null) {   //chua dang nhap
            if (guest.contains(resource) || resource.endsWith("js") || resource.endsWith("css") || resource.endsWith("woff2") || resource.endsWith("woff") || resource.endsWith("ttf") || resource.endsWith("jpg") || resource.endsWith("png") || resource.endsWith("jpeg") || resource.endsWith("ico"))
                chain.doFilter(request, response);
            else
                res.sendRedirect(LOGIN);
        } else {    //da dang nhap
            if (resource.equals(""))
                res.sendRedirect(LOGIN);
            if (role.equals("actor")) {
                if (actor.contains(resource) || resource.endsWith("js") || resource.endsWith("css") || resource.endsWith("woff2") || resource.endsWith("woff") || resource.endsWith("ttf") || resource.endsWith("jpg") || resource.endsWith("png") || resource.endsWith("jpeg") || resource.endsWith("ico"))
                    chain.doFilter(request, response);
            } else if (role.equals("admin")) {
                if (admin.contains(resource) || resource.endsWith("js") || resource.endsWith("css") || resource.endsWith("woff2") || resource.endsWith("woff") || resource.endsWith("ttf") || resource.endsWith("jpg") || resource.endsWith("png") || resource.endsWith("jpeg") || resource.endsWith("ico"))
                    chain.doFilter(request, response);
            } else {
                res.sendRedirect(LOGIN);
            }
        }
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {        
    }

    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("RoleFilter:Initializing filter");
            }
        }
    }

    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("RoleFilter()");
        }
        StringBuffer sb = new StringBuffer("RoleFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);                
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");                
                pw.print(stackTrace);                
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
