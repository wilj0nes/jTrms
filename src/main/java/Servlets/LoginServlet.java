package Servlets;

import Controller.Driver;
import DAOs.RequestDAO;
import DAOs.UserDAO;
import DataObjects.Request;
import DataObjects.User;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.Line;

import com.fasterxml.jackson.databind.ObjectMapper;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost()");
        //PrintWriter out = response.getWriter();
        //out.print("<h1>doPost()</h1>");
        ObjectMapper om = new ObjectMapper();
        InfoPOJO in = om.readValue(request.getParameter("InfoPOJO"), InfoPOJO.class);
        System.out.println("------>  " + in.toString());
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
        InfoPOJO in = om.readValue(request.getParameter("InfoPOJO"), InfoPOJO.class);
        System.out.println(in.toString());


    }

}
