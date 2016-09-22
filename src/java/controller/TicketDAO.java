/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Booking;
import beans.Ticket;
import beans.User;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
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
@ManagedBean(name = "ticketDAO")
@RequestScoped
public class TicketDAO implements Serializable {

    
    @ManagedProperty(value = "#{booking}")
    private beans.Booking booking;

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
       

    @ManagedProperty(value = "#{database}")
    private controller.Database database;

    public void setDatabase(Database database) {
        this.database = database;
    }

    public TicketDAO() {
    }

    public Ticket getTicket() {
        String pin = booking.getPin();

        Ticket ticket1 = new Ticket();
        ResultSet rs = null;
        PreparedStatement pst = null;
        System.out.println("Request PIN: " + pin);
        String stm = "select * from bus.ticket where ticket.pin = '" + pin + "'  ";
        //String stm = "select * from bus.ticket where bus.ticket.pin = '1430422901019'  ";
        try {
            pst = database.getCon().prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                //System.out.println("Ticket Id: "+rs.getInt(1));
                ticket1.setBookingId(rs.getInt(1));
                ticket1.setPin(rs.getString(2));
                ticket1.setScheId(rs.getInt(3));
                ticket1.setSeatNumbers(rs.getString(4));
                ticket1.setTotalCost(rs.getInt(5));
                ticket1.setFromLocation(rs.getString(6));
                ticket1.setToLocation(rs.getString(7));
                ticket1.setOptName(rs.getString(8));
                ticket1.setCategoryName(rs.getString(9));
                ticket1.setDprtDate(rs.getDate(10));
                ticket1.setDprtTime(rs.getTime(11));
                ticket1.setUserFirstName(rs.getString(12));
                ticket1.setUserAge(rs.getInt(13));
                ticket1.setStopageName(rs.getString(14));

                System.out.println("Ticket id:");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

        return ticket1;

    }

    
   

}
