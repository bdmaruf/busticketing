/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Operator;
import java.io.Serializable;
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
public class OperatorDAO implements Serializable {

    private static Operator selectedOperator;
    
    @ManagedProperty(value = "#{database}")
    private controller.Database database;

    public void setDatabase(Database database) {
        this.database = database;
    }

    public OperatorDAO() {

    }

    public Operator getSelectedOperator() {
        return selectedOperator;
    }

    public void setSelectedOperator(Operator selectedOperator) {
        this.selectedOperator = selectedOperator;
    }

    public List<Operator> getAllOperator() {
        ResultSet rs = null;
        PreparedStatement pst = null;

        String stm = "Select * from bus.operator";
        List<Operator> records = new ArrayList<Operator>();
        try {
            pst = database.getCon().prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                Operator operator = new Operator();
                operator.setOperatorId(rs.getInt(1));
                operator.setOperatorName(rs.getString(2));
                operator.setDetails(rs.getString(3));
                records.add(operator);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;

    }

    public void editOperator(Operator operator) {
        try {

            //String sql1 ="UPDATE maruf.student SET firstName ='Abdullah Al' where id = '1'";
            //String sql1 ="UPDATE maruf.student SET firstName ='"+student.getFirstName()+"' where id ='"+student.getId()+"'";
            String sql = "UPDATE bus.operator SET opt_name ='" + operator.getOperatorName() + "' , "
                    + "opt_details = '" + operator.getDetails() + "' where opt_id ='" + operator.getOperatorId() + "'";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OperatorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addOperator(Operator operator) {
        try {

            String sql = "INSERT INTO bus.operator (opt_name,opt_details)  VALUES (?,?)";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);
            preparedStatement.setString(1, operator.getOperatorName());
            preparedStatement.setString(2, operator.getDetails());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OperatorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteOperator(Operator operator) {
        try {

            //String sql1 ="UPDATE maruf.student SET firstName ='Abdullah Al' where id = '1'";
            String sql = "DELETE FROM bus.operator where opt_id ='" + operator.getOperatorId() + "'";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OperatorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
