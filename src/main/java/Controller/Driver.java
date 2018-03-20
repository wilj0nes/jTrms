package Controller;

import DataObjects.User;
import DataObjects.Request;
import java.util.*;
import java.io.*;
import java.net.*;


import org.apache.log4j.Logger;

public class Driver {
    private static final int PORT = 9999;

    public String serverName = "localhost";

    Logger logger;
    User user;
    ObjectOutputStream out;
    public ObjectInputStream in;

    public void connect(){


        try{
            InetAddress addr = InetAddress.getByName(serverName);
            Socket s = new Socket(addr, PORT);

            out = new ObjectOutputStream(s.getOutputStream());
            out.flush();
            out.writeObject("Hello world");

        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
