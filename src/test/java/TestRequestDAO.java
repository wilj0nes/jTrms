import DAOs.RequestDAO;
import DataObjects.Request;
import org.junit.Test;

import java.util.ArrayList;


public class TestRequestDAO {
    private RequestDAO requestDAO = new RequestDAO();

    @Test
    public void testNewRequest(){
        requestDAO = new RequestDAO();
        requestDAO.newRequest("123 asd adsf",
                    "city",
                    "PA",
                    39392,
                    2334,
                    2,
                    "asdf justice",
                    0,
                    "asdf status",
                    104,
                    2,
                    "asdfasdfs rejection",
                    "some description");
    }

    @Test
    public void TestFindRequestById(){
        requestDAO = new RequestDAO();
        Request r;
        r = requestDAO.findRequestById(21);
        System.out.println("\n" + r.getId());
    }

    @Test
    public void testGetUserRequests(){
        requestDAO = new RequestDAO();
        ArrayList<Request> requestList = requestDAO.getUserRequests(83);
        System.out.println(requestList.size());

        for(Request r : requestList){
            System.out.println(r.toString());
        }

    }

    @Test
    public void TestSetRejection(){
        requestDAO = new RequestDAO();
        requestDAO.updateRejection(2, "because I said so");
    }

    @Test
    public void TestUpdateStatus(){
        requestDAO = new RequestDAO();
        requestDAO.updateStatus(2, "the status is status");
    }
}
