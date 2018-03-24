package DAOs;
import ConnectionFactory.ConnectionFactory;
import DataObjects.Request;

import java.sql.*;

public class RequestDAO {

    //TODO do something about the date the request was made
    //TODO maybe do something about Blobs

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
                           String rejectionReason){
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
                "                      REJECTION_REASON) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
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
            ResultSet resultSet = ps.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
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
                        null,                                // TODO, deal with this later
                        rs.getString("STATUS"),
                        rs.getInt("USER_ID"),
                        this.getRequestType(rs.getInt("REQUEST_TYPE")),
                        rs.getInt("REQUEST_TYPE"),
                        rs.getString("REJECTION_REASON"));
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
        String s = "";
        String sql;
        PreparedStatement ps;
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        sql = "SELECT REQUEST FROM REQUEST_TYPE WHERE REQUEST_ID = ? ";
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
