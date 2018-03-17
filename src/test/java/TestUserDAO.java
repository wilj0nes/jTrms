import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import DAOs.UserDAO;
import DB_Objects.User;
import org.apache.log4j.Logger;
import org.junit.Test;

public class TestUserDAO {

    @Test
    public void testNewUser(){
        UserDAO d = new UserDAO();
        d.newUSER("testFirst2", "testLast2", 23, 2, "email2@email.com");
    }

    @Test
    public void testShowAllUsers(){
        UserDAO d = new UserDAO();
        d.readDB();
    }
}
