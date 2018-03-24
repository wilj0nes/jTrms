package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "FrontControllerServlet")
public class FrontControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

//    public static String process(HttpServletRequest request, HttpServletResponse response){
//
//        switch (request.getRequestURI()){
//            case "/mdl.html": {
//                return "/mdl.html";
//            }
//            case "asdf": {
//
//            }
//        }
//        return null;
//    }
}
