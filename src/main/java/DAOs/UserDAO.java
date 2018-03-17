package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import CF.ConnectionFactory;
import DB_Objects.User;
import oracle.jdbc.proxy.annotation.Pre;
import org.apache.log4j.Logger;

public class UserDAO {

    public void newUSER(String first, String last, float funds, int type, String email){
        String sql;
        PreparedStatement ps;
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        sql = "INSERT INTO USERS (FIRSTNAME, LASTNAME, FUNDS, USER_TYPE, EMAIL) VALUES (?, ?, ?, ?, ?) ";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, first);
            ps.setString(2, last);
            ps.setFloat(3, funds);
            ps.setInt(4, type);
            ps.setString(5, email);
            ResultSet resultSet = ps.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("Duplicates")
    public User findUserByEmail(String email){
        User user = null;
        String sql;
        PreparedStatement ps;
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        sql = "SELECT * FROM USERS WHERE EMAIL = ? ";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                user = new User(rs.getInt("USER_ID"),
                                rs.getString("FIRSTNAME"),
                                rs.getString("LASTNAME"),
                                rs.getFloat("FUNDS"),
                                rs.getInt("USER_TYPE"),
                                rs.getString("EMAIL"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public User findUserById(int id){
        User user = null;
        String sql;
        PreparedStatement ps;
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        sql = "SELECT * FROM USERS WHERE USER_ID = ? ";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                user = new User(rs.getInt("USER_ID"),
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"),
                        rs.getFloat("FUNDS"),
                        rs.getInt("USER_TYPE"),
                        rs.getString("EMAIL"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public void updateUserFunds(int id, float funds){
        String sql;
        PreparedStatement ps;
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        sql = "UPDATE USERS SET FUNDS = ? WHERE USER_ID = ? ";
        try{
            ps = conn.prepareStatement(sql);
            ps.setFloat(1, funds);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
            //conn.commit();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void readDB(){
        String sql;
        Connection conn;
        PreparedStatement ps;
        conn = ConnectionFactory.getInstance().getConnection();
        sql = "SELECT * FROM USERS ";
        try{
            ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                System.out.println(resultSet.getString("FIRSTNAME"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}
