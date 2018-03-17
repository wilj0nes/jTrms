package Controller;

import DAOs.UserDAO;

public class jTrms {
    public static void main(String args[]){
        System.out.println("hello world");
        UserDAO d = new UserDAO();
        d.readDB();
    }
}

