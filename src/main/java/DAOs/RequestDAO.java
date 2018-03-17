package DAOs;
import CF.ConnectionFactory;
import Controller.Request;

import java.sql.*;

public class RequestDAO {

    public void newRequest(String city,
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

        //language=GenericSQL
        sql = "INSERT INTO REQUESTS (DATE_CREATED, \n" +
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
                "                      REJECTION_REASON) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try{
            ps = conn.prepareStatement(sql);
            ps.setDate(1, null);
            ps.setString(2, city);
            ps.setString(3, state);
            ps.setInt(4, zip);
            ps.setFloat(5, cost);
            ps.setInt(6, formatID);
            ps.setString(7, justification);
            ps.setInt(8, blobID);
            ps.setString(9, status);
            ps.setInt(10, ownerID);
            ps.setInt(11, typeID);
            ps.setString(12, rejectionReason);
            ResultSet resultSet = ps.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

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
                        rs.getString("CITY"),
                        rs.getString("STATE"),
                        rs.getInt("ZIP"),
                        rs.getFloat("COST"),
                        this.getFormat(rs.getInt("GRADING_FORMAT")),   // format
                        rs.getString("JUSTIFICATION"),
                        rs.getInt("BLOB_ID"),
                        null,                                // blob, deal with this later
                        rs.getString("STATUS"),
                        rs.getInt("USER_ID"),
                        this.getRequestType(rs.getInt("REQUEST_TYPE")),    // Request type
                        rs.getInt("REQUEST_TYPE"),
                        rs.getString("REJECTION_REASON"));
            }
        }
        catch (SQLException e){
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
