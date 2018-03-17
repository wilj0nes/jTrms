import DAOs.RequestDAO;
import Controller.Request;
import org.junit.Test;

//import static java.sql.JDBCType.NULL;

public class TestRequestDAO {
    private RequestDAO requestDAO = new RequestDAO();

    @Test
    public void testNewRequest(){
        requestDAO = new RequestDAO();
        requestDAO.newRequest("testCity",
                    "testState",
                    12344,
                    234,
                    2,
                    "test JUSTIFICATION",
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
        r = requestDAO.findRequestById(2);
        System.out.println(r.getCity());
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
