package Servlets;

import DAOs.RequestDAO;
import DAOs.UserDAO;
import DataObjects.Request;
import DataObjects.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import POJOs.LoginPOJO;
import com.fasterxml.jackson.databind.ObjectMapper;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("doPost()");
        HttpSession session = request.getSession();

        UserDAO uDao = new UserDAO();
        RequestDAO rDao = new RequestDAO();

        ObjectMapper om = new ObjectMapper();
        LoginPOJO in = om.readValue(request.getParameter("LoginPOJO"), LoginPOJO.class);

        User u = new User();
        u = uDao.findUserByEmailAndPassword(in.getEmailInput(), in.getPassInput());

        PrintWriter out = response.getWriter();
        if(u == null){
            out.print("invalid");
        }
        else{
            System.out.println("valid");

            // put the user's requests in session

            session.setAttribute("user", u);

            //ArrayList<Request> requestList = rDao.getUserRequests(u.getId());

            ArrayList<Request> requestListAll = rDao.getAllRequests();
            session.setAttribute("requestListAll", requestListAll);

            if(requestListAll.size() != 0){
                session.setAttribute("requestList", requestListAll);
            }
            else {
                System.out.println("no requests found");
            }

            String userString = om.writeValueAsString(u);
            response.getWriter().write(userString);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet()");
        ObjectMapper om = new ObjectMapper();
        LoginPOJO in = om.readValue(request.getParameter("LoginPOJO"), LoginPOJO.class);
        System.out.println(in.toString());
    }

}
