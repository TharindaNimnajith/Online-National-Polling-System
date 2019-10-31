package com.mvc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mvc.bean.Admin;
import com.mvc.util.DBConnection;
 
public class AdminRegisterDAO {
 
 public String registerUser(Admin admin)
 {
 String fname = admin.getFname();
 String lname = admin.getLname();
 String address = admin.getAddress();
 String DoB = admin.getDoB();
 String gender = admin.getGender();
 String district= admin.getDistrict();
 String province = admin.getProvince();
 String nic = admin.getNic();
 String email = admin.getEmail();
 String phoneNo = admin.getPhoneNo();
 String username = admin.getUsername();
 String password = admin.getPassword();
 
 Connection con = null;
 PreparedStatement preparedStatement = null;
 
 try
 {
 con = DBConnection.createConnection();
 String query = "insert into admin(fname,lname,address,DoB,gender,district,province,nic,username,email,phoneNo,password) values (?,?,?,?,?,?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
 preparedStatement.setString(1,fname);
 preparedStatement.setString(2, lname);
 preparedStatement.setString(3, address);
 preparedStatement.setString(4, DoB );
 preparedStatement.setString(5, gender);
 preparedStatement.setString(6, district);
 preparedStatement.setString(7, province);
 preparedStatement.setString(8, nic);
 preparedStatement.setString(9, email);
 preparedStatement.setString(10, phoneNo);
 preparedStatement.setString(11, username);
 preparedStatement.setString(12, password);
 
 int x= preparedStatement.executeUpdate();
 
 if (x == 1)  //Just to ensure data has been inserted into the database
 return "SUCCESS"; 
 }
 catch(SQLException e)
 {
 e.printStackTrace();
 }
 
 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
 }
}