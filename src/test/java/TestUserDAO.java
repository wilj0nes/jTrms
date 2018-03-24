import DAOs.UserDAO;
import DataObjects.User;
import org.junit.Test;

public class TestUserDAO {

    @Test
    public void testNewUser(){
        UserDAO d = new UserDAO();
        d.newUSER("testFirst2", "testLast2", 23, 2, "email2@email.com", "password");
    }

    @Test
    public void testShowAllUsers(){
        UserDAO d = new UserDAO();
        d.readDB();
    }

    @Test
    public void testFindUserById(){
        UserDAO d = new UserDAO();
        User u;
        u = d.findUserById(83);
        System.out.println(u.getFirstName());
    }

    @Test
    public void testUpdateUserFunds(){
        UserDAO d = new UserDAO();
        d.updateUserFunds(83, 1000);
    }
}
