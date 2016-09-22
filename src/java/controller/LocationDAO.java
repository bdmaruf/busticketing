
package controller;

import beans.Location;
import java.io.Serializable;
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

 
@ManagedBean
@RequestScoped
public class LocationDAO implements Serializable{

    
    private Location selectedLocation;
    private int searchId;
        
    @ManagedProperty(value = "#{database}")
    private controller.Database database;

    public void setDatabase(Database database) {
        this.database = database;
    }
   
    public LocationDAO() {
    
    }

    public  Location getSelectedLocation() {
        return selectedLocation;
    }

    public void setSelectedLocation(Location selectedLocation) {
       selectedLocation = selectedLocation;
    }
    
    public List<Location> getAllLocations() throws SQLException{
        
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String stm = "Select * from bus.location";
        List<Location> records = new ArrayList<Location>();
        try {
            pst = database.getCon().prepareStatement(stm);
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
        finally{
            
        }
        
        return records;
        
    }
    public void editLocation(Location location){
        try {
           
            //String sql1 ="UPDATE maruf.location SET firstName ='Abdullah Al' where id = '1'";
            //String sql1 ="UPDATE maruf.location SET firstName ='"+location.getFirstName()+"' where id ='"+location.getId()+"'";
            String sql = "UPDATE bus.location SET loc_name ='"+location.getLocName()+"' , "
                    + "district = '"+location.getDistrict()+"' where loc_id ='"+location.getId()+"'";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addLocation(Location location) {
        try {
           
            String sql = "INSERT INTO bus.location (loc_name,district)  VALUES (?,?)";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);
            preparedStatement.setString(1, location.getLocName());
            preparedStatement.setString(2, location.getDistrict());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteLocation(Location location){
        try {
            
            //String sql1 ="UPDATE maruf.location SET firstName ='Abdullah Al' where id = '1'";
            String sql ="DELETE FROM bus.location where loc_id ='"+location.getId()+"'";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Location getLocation(int id) {
        Location loc = null;
        try {
            ResultSet rs = null;
            //this.setSearchId("2");
            
            //int id = this.searchId;
            
            int i=0;
            while(i<getAllLocations().size()){
                if(getAllLocations().get(i).getId() == id){
                    loc = getAllLocations().get(i);
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loc;
    }
    
    
}
