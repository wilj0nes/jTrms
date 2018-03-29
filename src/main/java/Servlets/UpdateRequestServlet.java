package Servlets;

import DAOs.RequestDAO;
import DataObjects.Request;
import POJOs.RequestUpdatePOJO;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

//@WebServlet(name = "UpdateRequestServlet")
public class UpdateRequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UpdateRequestServlet()");
        ObjectMapper om = new ObjectMapper();
        RequestDAO rDao = new RequestDAO();
        HttpSession session = request.getSession();

        RequestUpdatePOJO requestUpdate = om.readValue(request.getParameter("RequestUpdatePOJO"), RequestUpdatePOJO.class);

        rDao.updateStatus(requestUpdate.getId(), requestUpdate.getStatus());
        rDao.updateRejection(requestUpdate.getId(), requestUpdate.getRejectionReason());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
