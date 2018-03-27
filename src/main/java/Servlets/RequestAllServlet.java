package Servlets;

import DataObjects.Request;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

//@WebServlet(name = "RequestAllServlet")
public class RequestAllServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ObjectMapper om = new ObjectMapper();

        ArrayList<Request> allRequests = (ArrayList<Request>) session.getAttribute("requestListAll");
        String allRequestsString = om.writeValueAsString(allRequests);
        response.getWriter().write(allRequestsString);
    }
}
