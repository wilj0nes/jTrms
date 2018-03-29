package Servlets;

//import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    //Logger logger;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if(session != null){
            //session.removeAttribute("user");
//            session.removeAttribute("requestList");
//            session.removeAttribute("requestListAll");
            //session.invalidate();
            System.out.println("Logged out");
            //logger.trace("logged out");
        }
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/index.html");
        rd.include(request, response);
    }
}
