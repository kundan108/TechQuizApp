/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.User;

/**
 *
 * @author kundankumargupta
 */
public class UserDAO {
    public static boolean validateUser(User user) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where userid=? and password =? and usertype =?");
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        int ans=ps.executeUpdate();
        return ans==1;
    }
    public static boolean checkUser(String userId) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from users where userid=? and usertype=?");
        ps.setString(1, userId);
        ps.setString(2, "student");
        int ans=ps.executeUpdate();
        return ans==1;
    }
    public static boolean addUser(User user) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into users values (?,?,?)");
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        int ans=ps.executeUpdate();
        return ans==1;
    }
    public static boolean updateUser(User user) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update users set password=? where userid=? and usertype=?");
        ps.setString(1, user.getPassword());
        ps.setString(2, user.getUserId());
        ps.setString(3, user.getUserType());
        int ans=ps.executeUpdate();
        return ans==1;
    }
}
