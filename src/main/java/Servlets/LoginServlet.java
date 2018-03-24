package Servlets;

import DAOs.UserDAO;
import DataObjects.User;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import POJOs.LoginPOJO;
import com.fasterxml.jackson.databind.ObjectMapper;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost()");
        UserDAO uDao = new UserDAO();
        ObjectMapper om = new ObjectMapper();
        LoginPOJO in = om.readValue(request.getParameter("LoginPOJO"), LoginPOJO.class);

        User u = uDao.findUserByEmailAndPassword(in.getEmailInput(), in.getPassInput());


        PrintWriter out = response.getWriter();
        if(u == null){
            out.print("invalid login");
            // redirect here
        }
        else{
            response.setStatus(300);
            //out.print("valid login");
            RequestDispatcher rd = request.getRequestDispatcher("/f");
            rd.forward(request, response);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet()");
        //PrintWriter out = response.getWriter();
        //RequestDAO requestDAO = new RequestDAO();
        //out.append("<h1>"+ requestDAO.findRequestById(21).getId() + "</h1>");

        //UserDAO dao = new UserDAO();
        //User u = new User();


        ObjectMapper om = new ObjectMapper();
        LoginPOJO in = om.readValue(request.getParameter("LoginPOJO"), LoginPOJO.class);
        System.out.println(in.toString());

    }

}
