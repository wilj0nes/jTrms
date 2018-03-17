package Controller;

import DAOs.UserDAO;

public class Trms {

    public static void main(String args[]){
        System.out.println("hello world");
        UserDAO d = new UserDAO();
        d.readDB();
    }
}

