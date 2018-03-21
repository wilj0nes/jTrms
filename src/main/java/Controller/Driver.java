package Controller;

import org.apache.log4j.Logger;
import DAOs.RequestDAO;
import DataObjects.Request;


public class Driver {

    public void connect(){
        RequestDAO requestDAO = new RequestDAO();
        Request r;
        r = requestDAO.findRequestById(21);
        System.out.println("\ndata: " + r.getId());
    }
}
