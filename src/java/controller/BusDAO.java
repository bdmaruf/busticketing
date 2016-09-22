/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Bus;
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
import org.primefaces.context.ApplicationContext;

/**
 *
 * @author maruf
 */
@ManagedBean
@RequestScoped
public class BusDAO implements Serializable {

    
    @ManagedProperty(value = "#{database}")
    private controller.Database database;

    public void setDatabase(Database database) {
        this.database = database;
    }

    private static Bus selectedBus;
    
    public BusDAO() {

    
    }

    
    

    public Bus getSelectedBus() {
        return selectedBus;
    }

    public void setSelectedBus(Bus selectedBus) {
        this.selectedBus = selectedBus;
    }

    public List<Bus> getAllBus() {
        ResultSet rs = null;
        PreparedStatement pst = null;

        String stm = "Select * from bus.bus";
        List<Bus> records = new ArrayList<Bus>();
        try {
            pst = database.getCon().prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                Bus bus = new Bus();
                bus.setBusId(rs.getInt(1));
                bus.setOptId(rs.getInt(2));
                bus.setCategoryId(rs.getInt(3));
                bus.setRouteId(rs.getInt(4));
                bus.setRegNo(rs.getString(5));
                bus.setTotalSeat(rs.getInt(6));
                records.add(bus);

            }
        } catch (SQLException e) {
        }
        return records;

    }

    public void addBus(Bus bus) {
        try {

            String sql = "INSERT INTO bus.bus (opt_id,category_id,route_id,reg_no,total_seat)  VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);

            preparedStatement.setInt(1, bus.getOptId());
            preparedStatement.setInt(2, bus.getCategoryId());
            preparedStatement.setInt(3, bus.getRouteId());
            preparedStatement.setString(4, bus.getRegNo());
            preparedStatement.setInt(5, bus.getTotalSeat());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteBus(Bus bus) {
        try {

            //String sql1 ="UPDATE maruf.student SET firstName ='Abdullah Al' where id = '1'";
            String sql = "DELETE FROM bus.bus where bus_id ='" + bus.getBusId() + "'";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
