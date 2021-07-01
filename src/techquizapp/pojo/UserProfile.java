/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

/**
 *
 * @author kundankumargupta
 */
public class UserProfile {
    static private String username;
    static private String userType;
    
    public static void setUsername(String user){
        username=user;
    }
    public static void setUserType(String type){
        userType=type;
    }
    
    public static String getUsername(){
            return username;
    }
    public static String getUserType(){
            return userType;
    }
}
