/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Location;
import beans.PayMethod;
import beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author maruf
 */
@ManagedBean
@RequestScoped
public class UserDAO {

    @ManagedProperty(value = "#{user}")
    private beans.User user;

    public void setUser(User user) {
        this.user = user;
    }

    
    
    
    @ManagedProperty(value = "#{database}")
    private controller.Database database;

       
    public void setDatabase(Database database) {
        this.database = database;
    }

    public UserDAO() {

    }

    public List<User> getAllUser() throws SQLException {

        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = "Select * from bus.user";
        List<User> records = new ArrayList<User>();
        try {
            pst = database.getCon().prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getString(1));
                user.setUserName(rs.getString(2));
                user.setFirstName(rs.getString(3));
                user.setLastName(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setSex(rs.getString(6));
                user.setAge(rs.getInt(7));
                user.setMobNumber(rs.getString(8));
                user.setEmail(rs.getString(9));
                user.setUserTypeId(rs.getInt(10));
                records.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

        return records;

    }

    public void addUser() {
        String userName = "guest";
        String password = "guest";
        int userType = 1;
        System.out.println("user id from UserDAO:  "+user.getUserId());

        try {
            //String sql = "INSERT INTO bus.user (user_name,user_firstname,user_lastname,password,user_sex,user_age,user_mobile,user_email,user_type_id)  "
            //        + "VALUES (?,?,?,?,?,?,?,?,?)";
            String sql = "INSERT INTO bus.user (user_id,user_name,user_firstname,user_lastname,password,user_sex,user_age,user_mobile,user_email,user_type_id) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);
            preparedStatement.setString(1, user.getUserId());
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, user.getSex());
            preparedStatement.setInt(7, user.getAge());
            preparedStatement.setString(8, user.getMobNumber());
            preparedStatement.setString(9, user.getEmail());
            preparedStatement.setInt(10, userType);

            preparedStatement.executeUpdate();
            System.out.println("User successfully Added.");
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    

}
