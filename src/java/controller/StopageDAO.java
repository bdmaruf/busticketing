/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.SessionBean;
import beans.Stopage;
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
@ManagedBean(name = "stopageDAO")
@RequestScoped
public class StopageDAO implements Serializable {

    
    private  Stopage selectedStopage;
    
    @ManagedProperty(value = "#{database}")
    private controller.Database database;

    public void setDatabase(Database database) {
        this.database = database;
    }
    
    @ManagedProperty(value ="#{sessionBean}" )
    private beans.SessionBean sessionBean;
    
    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
    
    
    
    public StopageDAO() {
       
        
         
    }

    public Stopage getSelectedStopage() {
        System.out.println("Stopage selected :"+selectedStopage.getStopageName());
        return selectedStopage;
    }

    public void setSelectedStopage(Stopage selectedStopage) {
        System.out.println("Stopage selected :"+selectedStopage.getStopageName());
        this.selectedStopage = selectedStopage;
    }

    public List<Stopage> getAllStopages() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String stm = "Select * from bus.stopage";
        List<Stopage> records = new ArrayList<Stopage>();
        try {
            pst = database.getCon().prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                Stopage stopage = new Stopage();
                stopage.setStopageId(rs.getInt(1));
                stopage.setStopageName(rs.getString(2));
                stopage.setStopageLocId(rs.getInt(3));
                stopage.setOperatorId(rs.getInt(4));
                records.add(stopage);
            }
        } catch (SQLException e) {
        }
        return records;

    }

    public void editStopage(Stopage stopage) {
        System.out.println("Stopage Name= " + stopage.getStopageName());
        try {
            
            //String sql1 ="UPDATE maruf.student SET firstName ='Abdullah Al' where id = '1'";
            //String sql1 ="UPDATE maruf.student SET firstName ='"+student.getFirstName()+"' where id ='"+student.getId()+"'";
            // String sql = "UPDATE bus.stopage SET stopage_name ='"+stopage.getStopageName()+"' , "
            //         + "from_loc_id = '"+stopage.getFromLocId()+"',to_loc_id ='"+stopage.getToLocId()+"' where stopage_id ='"+stopage.getStopageId()+"'";
            //String sql1 = "UPDATE bus.stopage SET stopage_name ='"+stopage.getStopageName()+"',from_loc_id= '"+stopage.getFromLocId()+"',to_loc_id='"+stopage.getToLocId()+"' where stopage_id ='"+stopage.getStopageId()+"'";
            String sql2 = "UPDATE bus.stopage SET stopage_name ='" + stopage.getStopageName() + "',stopage_loc_id= '" + stopage.getStopageLocId() + "',opt_id='" + stopage.getOperatorId() + "' where stopage_id ='" + stopage.getStopageId() + "'";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql2);
            System.out.println(stopage.getStopageName());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StopageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addStopage(Stopage stopage) {
        try {
            
            String sql = "INSERT INTO bus.stopage (stopage_name,stopage_loc_id,opt_id)  VALUES (?,?,?)";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);
            preparedStatement.setString(1, stopage.getStopageName());
            preparedStatement.setInt(2, stopage.getStopageLocId());
            preparedStatement.setInt(3, stopage.getOperatorId());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StopageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteStopage(Stopage stopage) {
        try {
            
            //String sql1 ="UPDATE maruf.student SET firstName ='Abdullah Al' where id = '1'";
            String sql = "DELETE FROM bus.stopage where stopage_id ='" + stopage.getStopageId() + "'";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StopageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Stopage> getStopages() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        System.out.println(sessionBean.getSelectedSchedul().getSchedulId());
        int scheId = sessionBean.getSelectedSchedul().getSchedulId();
        //String stm = "Select * from bus.stopage";

        String stm = "select stopage_id, stopage_name\n"
                + "from bus.stopage,bus.bus,bus.route, bus.operator,bus.schedul\n"
                + "where(stopage.stopage_loc_id=route.from_loc_id)\n"
                + "and(route.route_id=bus.route_id)\n"
                + "and(bus.opt_id= operator.opt_id)\n"
                + "and(operator.opt_id = stopage.opt_id)\n"
                + "and(bus.bus_id=schedul.bus_id)\n"
                + "and(schedul.sche_id="+scheId+")";
        List<Stopage> records = new ArrayList<Stopage>();
        try {
            pst = database.getCon().prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                Stopage stopage = new Stopage();
                stopage.setStopageId(rs.getInt(1));
                stopage.setStopageName(rs.getString(2));
                
                records.add(stopage);
            }
        } catch (SQLException e) {
        }
        return records;

    }

}
