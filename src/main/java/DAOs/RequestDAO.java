package DAOs;
import ConnectionFactory.ConnectionFactory;
import DataObjects.Request;
//import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class RequestDAO {

    //TODO do something about the date the request was made
    //TODO maybe do something about Blobs

    //Logger logger;

    public void newRequest(String address,
                           String city,
                           String state,
                           int zip,
                           float cost,
                           int formatID,
                           String justification,
                           int blobID,
                           String status,
                           int ownerID,
                           int typeID,
                           String rejectionReason,
                           String description){
        String sql;
        PreparedStatement ps;
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        sql = "INSERT INTO REQUESTS (DATE_CREATED, \n" +
                "                      ADDRESS,\n" +
                "                      CITY, \n" +
                "                      STATE, \n" +
                "                      ZIP, \n" +
                "                      COST, \n" +
                "                      GRADING_FORMAT, \n" +
                "                      JUSTIFICATION, \n" +
                "                      BLOB_ID,\n" +
                "                      STATUS, \n" +
                "                      USER_ID, \n" +
                "                      REQUEST_TYPE, \n" +
                "                      REJECTION_REASON,\n" +
                "                      DESCRIPTION) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try{
            ps = conn.prepareStatement(sql);
            ps.setDate(1, null);
            ps.setString(2, address);
            ps.setString(3, city);
            ps.setString(4, state);
            ps.setInt(5, zip);
            ps.setFloat(6, cost);
            ps.setInt(7, formatID);
            ps.setString(8, justification);
            ps.setInt(9, blobID);
            ps.setString(10, status);
            ps.setInt(11, ownerID);
            ps.setInt(12, typeID);
            ps.setString(13, rejectionReason);
            ps.setString(14, description);
            ResultSet resultSet = ps.executeQuery();
            //logger.trace("New request was submitted");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    @SuppressWarnings("Duplicates")
    public ArrayList<Request> getAllRequests(){
        ArrayList<Request> requestList = new ArrayList<Request>();
        String sql;
        PreparedStatement ps;
        Connection conn = ConnectionFactory.getInstance().getConnection();
        //language=Oracle
        sql = "SELECT * FROM REQUESTS ORDER BY REQUEST_ID ";
        try{
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Request request = new Request(rs.getInt("REQUEST_ID"),
                        rs.getString("ADDRESS"),
                        rs.getString("CITY"),
                        rs.getString("STATE"),
                        rs.getInt("ZIP"),
                        rs.getFloat("COST"),
                        "Letter grade", //this.getFormat(rs.getInt("GRADING_FORMAT")), // TODO deal with this
                        rs.getString("JUSTIFICATION"),
                        rs.getInt("BLOB_ID"),
                        null,                                // TODO, deal with this later
                        rs.getString("STATUS"),
                        rs.getInt("USER_ID"),
                        this.getRequestType(rs.getInt("REQUEST_TYPE")),
                        rs.getInt("REQUEST_TYPE"),
                        rs.getString("REJECTION_REASON"),
                        rs.getString("DESCRIPTION")
                );
                requestList.add(request);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }

        return requestList;
    }

    @SuppressWarnings("Duplicates")
    public ArrayList<Request> getUserRequests(int userId){
        ArrayList<Request> requestArrayList = new ArrayList<Request>();
        String sql;
        PreparedStatement ps;
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        //language=GenericSQL
        sql = "SELECT * FROM REQUESTS WHERE REQUESTS.USER_ID = ? ORDER BY REQUEST_ID ";

        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){

                //System.out.println("--> " + this.getRequestType(rs.getInt("REQUEST_TYPE")));

                Request request = new Request(rs.getInt("REQUEST_ID"),
                        rs.getString("ADDRESS"),
                        rs.getString("CITY"),
                        rs.getString("STATE"),
                        rs.getInt("ZIP"),
                        rs.getFloat("COST"),
                        this.getFormat(rs.getInt("GRADING_FORMAT")),
                        rs.getString("JUSTIFICATION"),
                        rs.getInt("BLOB_ID"),
                        null,                                // TODO, deal with this later
                        rs.getString("STATUS"),
                        rs.getInt("USER_ID"),
                        this.getRequestType(rs.getInt("REQUEST_TYPE")),
                        rs.getInt("REQUEST_TYPE"),
                        rs.getString("REJECTION_REASON"),
                        rs.getString("DESCRIPTION")
                );
                //System.out.println("--> " + this.getRequestType(rs.getInt("REQUEST_TYPE")));
                requestArrayList.add(request);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        //System.out.println(requestArrayList.size());
        return requestArrayList;
    }

    @SuppressWarnings("Duplicates")
    public Request findRequestById(int id){
        Request request = null;
        String sql;
        PreparedStatement ps;
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        sql = "SELECT * FROM REQUESTS WHERE REQUEST_ID = ? ";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                request = new Request(rs.getInt("REQUEST_ID"),
                        rs.getString("ADDRESS"),
                        rs.getString("CITY"),
                        rs.getString("STATE"),
                        rs.getInt("ZIP"),
                        rs.getFloat("COST"),
                        this.getFormat(rs.getInt("GRADING_FORMAT")),
                        rs.getString("JUSTIFICATION"),
                        rs.getInt("BLOB_ID"),
                        null,                // TODO, deal with this later
                        rs.getString("STATUS"),
                        rs.getInt("USER_ID"),
                        this.getRequestType(rs.getInt("REQUEST_TYPE")),
                        rs.getInt("REQUEST_TYPE"),
                        rs.getString("REJECTION_REASON"),
                        rs.getString("DESCRIPTION")
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        return request;
    }

    public String getRequestType(int typeId){
        String s = "Request type not found";
        PreparedStatement ps;
        Connection conn = ConnectionFactory.getInstance().getConnection();
        String sql = "SELECT REQUEST FROM REQUEST_TYPE WHERE REQUEST_ID = ? ";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, typeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return rs.getString("REQUEST");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return s;
    }

    public int getRequestTypeID(String requestType){
        PreparedStatement ps;
        Connection conn = ConnectionFactory.getInstance().getConnection();
        //language=Oracle
        String sql = "SELECT REQUEST_ID FROM REQUEST_TYPE WHERE REQUEST = ? ";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, requestType);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return rs.getInt("REQUEST_ID");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return 5;// TODO should probably not do this
    }

    public String getFormat(int typeId){
        String s = "";
        String sql;
        PreparedStatement ps;
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        sql = "SELECT FORMAT_TYPE FROM GRADING_FORMAT WHERE FORMAT_ID = ? ";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, typeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return rs.getString("FORMAT_TYPE");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return s;
    }

    public int getFormatID(String s){
        PreparedStatement ps;
        Connection conn = ConnectionFactory.getInstance().getConnection();
        //language=Oracle
        String sql = "SELECT FORMAT_ID FROM GRADING_FORMAT WHERE FORMAT_TYPE = ? ";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt("FORMAT_ID");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    @SuppressWarnings("Duplicates")
    public void updateRejection(int id, String reason){
        String sql;
        PreparedStatement ps;
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        sql = "UPDATE REQUESTS SET REJECTION_REASON = ? WHERE REQUEST_ID = ? ";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, reason);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("Duplicates")
    public void updateStatus(int id, String status){
        String sql;
        PreparedStatement ps;
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        sql = "UPDATE REQUESTS SET STATUS = ? WHERE REQUEST_ID = ? ";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
