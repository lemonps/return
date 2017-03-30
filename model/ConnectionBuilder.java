/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

/**
 *
 * @author Lemon
 */
public class ConnectionBuilder {
    
    public static Connection getConnection(){
           Connection con = null;
          
           try{
               Class.forName("com.mysql.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://188.166.252.187:3306/"
                       + "return_dev?zeroDateTimeBehavior=convertToNull","return_devman","dev128");
           }catch(SQLException e){
               System.out.println(e);
           }catch(ClassNotFoundException e){
               System.out.println(e);
           }
         return con;
    }
        
    public static void main(String[] args) {
        Connection con = getConnection();
        System.out.println("eiei");
    }
}
