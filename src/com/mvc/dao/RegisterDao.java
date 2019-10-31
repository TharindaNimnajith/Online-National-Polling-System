package com.mvc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mvc.bean.RegisterBean;
import com.mvc.util.DBConnection;
 
public class RegisterDao {
 
 public String registerUser(RegisterBean registerBean)
 {
 String fname = registerBean.getFname();
 String lname = registerBean.getLname();
 String address = registerBean.getAddress();
 String DoB = registerBean.getDoB();
 String gender = registerBean.getGender();
 String district= registerBean.getDistrict();
 String province = registerBean.getProvince();
 String nic = registerBean.getNic();
 String email = registerBean.getEmail();
 String phoneNo = registerBean.getPhoneNo();
 String username = registerBean.getUsername();
 String password = registerBean.getPassword();
 
 Connection con = null;
 PreparedStatement preparedStatement = null;
 
 try
 {
 con = DBConnection.createConnection();
 String query = "insert into voterdetails(fname,lname,address,DoB,gender,district,province,nic,username,email,phoneNo,password) values (?,?,?,?,?,?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
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
 
 int i= preparedStatement.executeUpdate();
 
 if (i!=0)  //Just to ensure data has been inserted into the database
 return "SUCCESS"; 
 }
 catch(SQLException e)
 {
 e.printStackTrace();
 }
 
 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
 }
}