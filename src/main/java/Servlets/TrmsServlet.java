package Servlets;

import DataObjects.Request;
import DataObjects.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

//@WebServlet(name = "TrmsServlet")
public class TrmsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ObjectMapper om = new ObjectMapper();

        User user = (User)session.getAttribute("user");
        //ArrayList<Request> requestArrayList = (ArrayList<Request>) session.getAttribute("requestList");

        String userString = om.writeValueAsString(user);
        response.getWriter().write(userString);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet() the personal requests");
        HttpSession session = request.getSession();
        ObjectMapper om = new ObjectMapper();

        ArrayList<Request> requestList = (ArrayList<Request>) session.getAttribute("requestList");
        String requestString = om.writeValueAsString(requestList);
        response.getWriter().write(requestString);
    }
}
