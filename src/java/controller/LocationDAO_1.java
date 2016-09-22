/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Location;
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

public class LocationDAO_1 {

    private static Location selectedLocation;
    @ManagedProperty(value = "#{database}")
    private controller.Database database;

    public void setDatabase(Database database) {
        this.database = database;
    }
    public LocationDAO_1() {
     
    }

    public static Location getSelectedLocation() {
        return selectedLocation;
    }

    public static void setSelectedLocation(Location selectedLocation) {
        LocationDAO_1.selectedLocation = selectedLocation;
    }
    
    private List<Location> getAllLocations(){
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = database.getCon();
        String stm = "Select * from bus.location";
        List<Location> records = new ArrayList<Location>();
        try {
            pst = con.prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                Location location = new Location();
                location.setId(rs.getInt(1));
                location.setLocName(rs.getString(2));
                location.setDistrict(rs.getString(3));
                records.add(location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
        
    }
    
    
}
