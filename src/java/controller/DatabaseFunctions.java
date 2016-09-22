/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author maruf
 */
public class DatabaseFunctions {
    
    List<String> seatNumber = new ArrayList<String>();
    @ManagedProperty(value = "#{database}")
    private controller.Database database;

    public void setDatabase(Database database) {
        this.database = database;
    }
    
    public DatabaseFunctions(){
        
    }
    public List<String> getBookedSeats(int scheId){
        List<String> seatNumber = new ArrayList<String>();
        ResultSet rs = null;
        //this.setSearchId("2");
        PreparedStatement pst = null;
        Connection con =database.getCon();
        //String stm = "select * from bus.schedul where dprt_date = '"+date+"' ";
        String stm = "select seat_number from bus.seatbooking where sche_id = 2";
        
        try {
            pst = con.prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                seatNumber.add(rs.getString(1));
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seatNumber;
        
    }
    public int getAvailableSeat(int scheId) {
        ResultSet rs = null;
        //this.setSearchId("2");
        PreparedStatement pst = null;
        Connection con =database.getCon();
        //String stm = "select * from bus.schedul where dprt_date = '"+date+"' ";
        String stm = "select ((select total_seat from bus.bus where bus_id = (select bus_id from bus.schedul where sche_id = 5)) - (select count(*) from bus.seatbooking where sche_id = 2))";
        int availableseat = 0 ;

        try {
            pst = con.prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                availableseat = rs.getInt(1);
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return availableseat;
    }
    
}
