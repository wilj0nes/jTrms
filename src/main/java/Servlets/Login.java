package Servlets;

import Controller.Driver;
import DAOs.RequestDAO;
import DAOs.UserDAO;
import DataObjects.Request;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost()");
        PrintWriter out = response.getWriter();
        out.print("<h1>doPost()</h1>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet()");
        PrintWriter out = response.getWriter();

        System.out.println("request: " + request.toString());


        RequestDAO requestDAO = new RequestDAO();
        out.append("<h1>"+ requestDAO.findRequestById(21).getId() + "</h1>");
    }

}
