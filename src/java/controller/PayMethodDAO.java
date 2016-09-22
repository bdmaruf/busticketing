/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import beans.PayMethod;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author maruf
 */
@ManagedBean
@RequestScoped
public class PayMethodDAO {

    @ManagedProperty(value = "#{database}")
    private controller.Database database;

    public void setDatabase(Database database) {
        this.database = database;
    }
    public PayMethodDAO() {
        
    }
    public List<PayMethod> getAllPayMethods() throws SQLException{
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = "Select * from bus.paymethod";
        List<PayMethod> records = new ArrayList<PayMethod>();
        try {
            pst = database.getCon().prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                PayMethod payMethod = new PayMethod();
                payMethod.setMethodId(rs.getInt(1));
                payMethod.setMethodName(rs.getString(2));
                payMethod.setMethodDetails(rs.getString(3));
                payMethod.setMethodMobNum(rs.getString(4));
                records.add(payMethod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            
        }
        
        return records;
        
    }
    
}
