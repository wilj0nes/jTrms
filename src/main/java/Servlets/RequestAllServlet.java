package Servlets;

import DAOs.RequestDAO;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper om = new ObjectMapper();
        RequestDAO rDao = new RequestDAO();
        //HttpSession session = request.getSession();


        ArrayList<Request> allRequests = rDao.getAllRequests();
        String allRequestsString = om.writeValueAsString(allRequests);

        //session.setAttribute("allRequests", allRequests);

        response.getWriter().write(allRequestsString);
        String requestString = om.writeValueAsString(allRequests);
        response.getWriter().write(requestString);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
