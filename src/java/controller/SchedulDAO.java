/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Bus;
import beans.Schedul;
import beans.Schedul;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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
public class SchedulDAO implements Serializable {

    private static Schedul selectedSchedul;
    private static Date searchDate;
    private static java.util.Date searchCalanDate;
    private static int searchFromLocId;
    private static int searchToLocId;

    @ManagedProperty(value = "#{database}")
    private controller.Database database;

    public void setDatabase(Database database) {
        this.database = database;
    }

    public SchedulDAO() {

    }

    public int getSearchFromLocId() {

        return searchFromLocId;
    }

    public void setSearchFromLocId(int searchFromLocId) {

        this.searchFromLocId = searchFromLocId;
    }

    public int getSearchToLocId() {
        return searchToLocId;
    }

    public void setSearchToLocId(int searchToLocId) {
        this.searchToLocId = searchToLocId;
    }

    public Date getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(Date searchDate) {
        this.searchDate = searchDate;
    }

    public java.util.Date getSearchCalanDate() {
        return searchCalanDate;
    }

    public void setSearchCalanDate(java.util.Date searchCalanDate) {
        this.searchCalanDate = searchCalanDate;
        this.setSearchDate(TimeConverter.sqlDate(searchCalanDate));

    }

    public Schedul getSelectedSchedul() {

        return selectedSchedul;
    }

    public void setSelectedSchedul(Schedul selectedSchedul) {
        this.selectedSchedul = selectedSchedul;
    }

    public List<Schedul> getAllSchedul() {
        ResultSet rs = null;
        PreparedStatement pst = null;

        String stm = "Select * from bus.schedul";
        List<Schedul> records = new ArrayList<Schedul>();
        try {
            pst = database.getCon().prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                Schedul schedul = new Schedul();
                schedul.setSchedulId(rs.getInt(1));
                schedul.setBusId(rs.getInt(2));
                schedul.setDprtDate(rs.getDate(3));
                schedul.setDprtTime(rs.getTime(4));
                schedul.setArivDate(rs.getDate(5));
                schedul.setArivTime(rs.getTime(6));
                schedul.setFare(rs.getInt(7));
                schedul.setSchedulStatus(rs.getInt(8));
                records.add(schedul);

            }
        } catch (SQLException e) {
        }
        return records;

    }

    public void updateSchedul(Schedul schedul) {
        try {
        
            //String sql = "UPDATE bus.schedul SET bus_id = '"+schedul.getBusId()+"', dprt_date = '"+schedul.getDprtDate()+"', dprt_time = '"+schedul.getDprtTime() +"', ariv_date='"+schedul.getArivDate() +"' , ariv_time ='"+schedul.getArivTime() +"' , fare = '"+schedul.getFare() +"', sche_status = '"+schedul.getSchedulStatus() + "'  where sche_id = '"+schedul.getSchedulId() +"' ";
            String sql = "UPDATE bus.schedul SET bus_id = ?, dprt_date = ?, dprt_time = ?, ariv_date=? , ariv_time = ?, fare = ?, sche_status = ?  where sche_id = ? ";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);
            preparedStatement.setInt(1, schedul.getBusId());
            preparedStatement.setDate(2, (Date) schedul.getDprtDate());
            preparedStatement.setTime(3, (Time) schedul.getDprtTime());
            preparedStatement.setDate(4, (Date) schedul.getArivDate());
            preparedStatement.setTime(5, (Time) schedul.getArivTime());
            preparedStatement.setInt(6, schedul.getFare());
            preparedStatement.setInt(7, schedul.getSchedulStatus());
            preparedStatement.setInt(8, schedul.getSchedulId());
            
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SchedulDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addSchedul(Schedul schedul) {

        try {

            String sql = "INSERT INTO bus.schedul (bus_id,dprt_date,dprt_time,ariv_date,ariv_time,fare,sche_status)  VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);

            preparedStatement.setInt(1, schedul.getBusId());
            preparedStatement.setDate(2, (Date) schedul.getDprtDate());
            preparedStatement.setTime(3, (Time) schedul.getDprtTime());
            preparedStatement.setDate(4, (Date) schedul.getArivDate());
            preparedStatement.setTime(5, (Time) schedul.getArivTime());
            preparedStatement.setInt(6, schedul.getFare());
            preparedStatement.setInt(7, schedul.getSchedulStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SchedulDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteSchedul(Schedul schedul) {
        try {

            //String sql1 ="UPDATE maruf.student SET firstName ='Abdullah Al' where id = '1'";
            String sql = "DELETE FROM bus.schedul where sche_id ='" + schedul.getSchedulId() + "'";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SchedulDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Schedul> getScheduls() {
        ResultSet rs = null;
        //this.setSearchId("2");
        Date date = this.getSearchDate();
        System.out.println("search date:" + date);
        System.out.println("From:" + searchFromLocId);
        System.out.println("To: " + searchToLocId);
        PreparedStatement pst = null;

        //String stm = "select * from bus.schedul where dprt_date = '"+date+"' ";
        /*
         String stm ="select * from bus.schedul where (dprt_date = '"+date+"') and\n" +
         "	(\n" +
         "	bus_id = \n" +
         "		(\n" +
         "			select bus_id from bus.bus where route_id = (select route_id from bus.route "
         + "where from_loc_id ="+searchFromLocId+" and to_loc_id = "+searchToLocId+")\n" +
         "		)\n" +
         "	)"; 
         */
        String stm = "select * from bus.schedul,bus.route,bus.bus \n"
                + "where (dprt_date = '" + date + "') \n"
                + "and(route.route_id =(\n"
                + "select route_id \n"
                + "from bus.route \n"
                + "where from_loc_id =" + searchFromLocId + " \n"
                + "and to_loc_id=" + searchToLocId + " ))\n"
                + "and \n"
                + "(bus.bus_id = schedul.bus_id) \n"
                + "and\n"
                + "(bus.route_id = route.route_id);";
        //String stm ="select * from bus.schedul where dprt_date = '2015-04-14' ";
        List<Schedul> records = new ArrayList<Schedul>();
        try {
            pst = database.getCon().prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                Schedul schedul = new Schedul();
                schedul.setSchedulId(rs.getInt(1));
                schedul.setBusId(rs.getInt(2));
                schedul.setDprtDate(rs.getDate(3));
                schedul.setDprtTime(rs.getTime(4));
                schedul.setArivDate(rs.getDate(5));
                schedul.setArivTime(rs.getTime(6));
                schedul.setFare(rs.getInt(7));
                schedul.setSchedulStatus(rs.getInt(8));
                records.add(schedul);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

}
