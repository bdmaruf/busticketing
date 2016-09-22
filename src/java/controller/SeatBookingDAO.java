/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.SeatBooking;
import beans.SessionBean;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import mypkg.SeatManagedBean;

/**
 *
 * @author maruf
 */
@ManagedBean(name = "seatBookingDAO")
@RequestScoped
public class SeatBookingDAO implements Serializable {

    private SeatBooking selectedSeatBooking;

    @ManagedProperty(value ="#{sessionBean}" )
    private beans.SessionBean sessionBean;

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    @ManagedProperty(value = "#{database}")
    private controller.Database database;

    public void setDatabase(Database database) {
        this.database = database;
    }

    public SeatBookingDAO() {

    }

    public SeatBooking getSelectedSeatBooking() {
        return selectedSeatBooking;
    }

    public void setSelectedSeatBooking(SeatBooking selectedSeatBooking) {
        this.selectedSeatBooking = selectedSeatBooking;
    }

    public List<SeatBooking> getAllSeatBooking() {
        ResultSet rs = null;
        PreparedStatement pst = null;

        String stm = "Select * from bus.seatBooking";
        List<SeatBooking> records = new ArrayList<SeatBooking>();
        try {
            pst = database.getCon().prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                SeatBooking seatBooking = new SeatBooking();
                seatBooking.setSeatbookingId(rs.getInt(1));
                seatBooking.setScheId(rs.getInt(2));
                seatBooking.setSeatNumber(rs.getString(3));
                records.add(seatBooking);

            }
        } catch (SQLException e) {
        }
        return records;

    }

    public void addSeatBooking() {

        int scheId = sessionBean.getSelectedSchedul().getSchedulId();
        List<String> seatNumbers = new ArrayList<String>();
        seatNumbers = sessionBean.getSelectedSeats();

        try {
            if (seatNumbers.size() > 0) {
                for (int i = 0; i < seatNumbers.size(); i++) {

                    String sql = "INSERT INTO bus.seatbooking (sche_id,seat_number)  VALUES ('" + scheId + "','" + seatNumbers.get(i) + "')";
                    PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);
                    // preparedStatement.setInt(1, scheId);
                    // preparedStatement.setString(2, seatNumber);
                    preparedStatement.executeUpdate();
                }
            }

            System.out.println("Seats are booked Successfully");

        } catch (SQLException ex) {
            Logger.getLogger(SeatBookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Map<Integer, Integer> getAvailableSeatMap() {

        ResultSet rs = null;
        PreparedStatement pst = null;

        String stm = "Select * from bus.availableseats";
        Map availableSeatMap = new HashMap<Integer, Integer>();
        try {
            pst = database.getCon().prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                availableSeatMap.put(rs.getInt(1), rs.getInt(2));

            }
        } catch (SQLException e) {
        }
        return availableSeatMap;
    }

    public List<String> getBookedSeatNumber() {

        ResultSet rs = null;
        PreparedStatement pst = null;
        System.out.println("seat number.");
        //int scheId = sessionBean.getSelectedSchedul().getSchedulId();

        int scheId = 8;
        scheId = sessionBean.getSelectedSchedul().getSchedulId();
        System.out.println("Schedul id: " + scheId);
        List<String> result = new ArrayList<String>();
        String stm = "select seat_number from bus.seatbooking  where sche_id = '" + scheId + "'";

        //String stm = "select seat_number from bus.seatbooking  where sche_id = 8 ";
        try {
            pst = database.getCon().prepareStatement(stm);
            if (pst != null) {
                pst.execute();
                rs = pst.getResultSet();
                while (rs.next()) {
                    result.add(rs.getString(1));
                    System.out.println(rs.getString(1));
                }
            } else {
                System.out.println("No seat booked.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

}
