import DAOs.RequestDAO;
import Controller.Request;
import org.junit.Test;

//import static java.sql.JDBCType.NULL;

public class TestRequestDAO {

    @Test
    public void testNewRequest(){
        RequestDAO d = new RequestDAO();
        d.newRequest("testCity",
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
        RequestDAO d = new RequestDAO();
        Request r;
        r = d.findRequestById(2);
        System.out.println(r.getCity());
    }
}
