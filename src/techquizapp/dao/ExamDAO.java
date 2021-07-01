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
import techquizapp.pojo.Exam;

/**
 *
 * @author kundankumargupta
 */
public class ExamDAO {
    public static String getExamId() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select count(*) from exam");
        rs.next();
        int count=rs.getInt(1);
        String newId = "EX-"+(count+1);
        return newId;
    }
    
    public static boolean addExam(Exam exam) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into exam values(?,?,?)");
        ps.setString(1,exam.getExamId());
        ps.setString(2,exam.getLanguage());
        ps.setInt(3,exam.getTotalQuestion());
        int ans=ps.executeUpdate();
        return ans==1;
    }
    
    
    public static ArrayList<String> getExamIdBySubject(String subject) throws SQLException 
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select examId from exam where language=?");
        ps.setString(1, subject);
        ResultSet rs=ps.executeQuery();
        ArrayList<String> examIdList = new ArrayList<>();
        while(rs.next())
        {
            examIdList.add(rs.getString(1));
        }
        return examIdList;
    }
    
    public static int getQuestionCountByExam( String examId) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select total_question from exam where examId=?");
        ps.setString(1, examId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    public static boolean isPaperSet(String subject) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select examId from exam where language=?");
        ps.setString(1, subject);
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
    public static ArrayList<String> getExamIdBySubject(String userId,String subject) throws SQLException
    {
        String qry="select examId from exam where language= ? minus select examId from performance where userId=?";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1, subject);
        ps.setString(2, userId);
        ResultSet rs=ps.executeQuery();
        ArrayList<String> examId = new ArrayList();
        while(rs.next()){
            String id=rs.getString(1);
            examId.add(id);
        }
        return examId;
    }
}
