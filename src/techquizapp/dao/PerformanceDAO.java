/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Performance;
import techquizapp.pojo.StudentScore;

/**
 *
 * @author kundankumargupta
 */
public class PerformanceDAO {
    public static ArrayList<String> getAllExamId(String studentId) throws SQLException
    {
        String qry="Select examId from performance where userId=?";
        ArrayList<String> examId = new ArrayList();
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1, studentId);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            String id=rs.getString(1);
            examId.add(id);
        }
        return examId;
    }
    
    public static ArrayList<Performance> getAllData() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ArrayList<Performance> performanceList= new ArrayList<>();
        ResultSet rs=st.executeQuery("Select * from Performance");
        while(rs.next()){
            String userId=rs.getString(1);
            String examId=rs.getString(2);
            int right=rs.getInt(3);
            int wrong=rs.getInt(4);
            int unatt=rs.getInt(5);
            double per=rs.getDouble(6);
            String lang=rs.getString(7);
            Performance p= new Performance(userId,examId,right,wrong,unatt,per,lang);
            performanceList.add(p);
        }
        return performanceList;
    }
    public static ArrayList<String> getAllStudentId() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ArrayList<String> studentList= new ArrayList<>();
        ResultSet rs=st.executeQuery("Select distinct userId from Performance");
        while(rs.next()){
            String userId=rs.getString(1);
            studentList.add(userId);
        }
        return studentList;
    }
    public static StudentScore getScore(String studentId,String examId) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select language,per from performance where userid =? and examId=?");
        ps.setString(1, studentId);
        ps.setString(2, examId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        StudentScore obj = new StudentScore();
        obj.setLanguage(rs.getString(1));
        obj.setPer(rs.getDouble(2));
        return obj;
    }
    public static void addPerformance(Performance performance) throws SQLException
    {
        String qry="insert into performance values(?,?,?,?,?,?,?)";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1,performance.getUserId());
        ps.setString(2,performance.getExamId());
        ps.setInt(3,performance.getRight());
        ps.setInt(4,performance.getWrong());
        ps.setInt(5,performance.getUnattempted());
        ps.setDouble(6,performance.getPer());
        ps.setString(7,performance.getLanguage());
        ps.executeUpdate();
    }
    
}
