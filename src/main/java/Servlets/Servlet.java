package Servlets;

import DAOs.UserDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

//@WebServlet(name="Servlet", urlPatterns= {"/"})
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setStatus(200);
        System.out.println("doPost()");
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        response.setStatus(200);
//        out.print("<h1> Hello world </h1>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setStatus(200);
        System.out.println("doGet()");
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        response.setStatus(200);
//        out.append("<h1> Hello world </h1>");
    }

}
