import DAOs.RequestDAO;
import DataObjects.Request;
import org.junit.Test;


public class TestRequestDAO {
    private RequestDAO requestDAO = new RequestDAO();

    @Test
    public void testNewRequest(){
        requestDAO = new RequestDAO();
        requestDAO.newRequest("123 something",
                    "city",
                    "PA",
                    39392,
                    2333334,
                    2,
                    "justice",
                    0,
                    "test status",
                    83,
                    2,
                    "test rejection");
    }

    @Test
    public void TestFindRequestById(){
        requestDAO = new RequestDAO();
        Request r;
        r = requestDAO.findRequestById(21);
        System.out.println("\n" + r.getId());
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
