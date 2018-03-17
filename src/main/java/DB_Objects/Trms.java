package DB_Objects;

import DAOs.UserDAO;

import java.sql.SQLException;

public class Trms {

    public static void main(String args[]){
        System.out.println("hello world");
        UserDAO d = new UserDAO();
        d.readDB();
    }
}

