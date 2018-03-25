package Servlets;

import DAOs.RequestDAO;
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

//@WebServlet(name = "RequestServlet")
public class RequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RequestServlet doPost()");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        System.out.println("zip --> " + request.getParameter("zip"));

        RequestDAO rDao = new RequestDAO();
        rDao.newRequest(
                request.getParameter("address"),
                request.getParameter("city"),
                request.getParameter("state"),
                Integer.parseInt(request.getParameter("zip")),
                Float.parseFloat(request.getParameter("cost")),
                rDao.getFormatID(request.getParameter("grading-format")),
                request.getParameter("justification"),
                0,
                "pending",
                user.getId(),
                rDao.getRequestTypeID(request.getParameter("event-type")),
                "N/A",
                request.getParameter("description")
        );
        response.sendRedirect("trms.html");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
