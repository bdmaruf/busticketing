/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Booking;
import beans.SessionBean;
import beans.User;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
@ManagedBean
@RequestScoped
public class BookingDAO {

    @ManagedProperty (value = "#{ticketDAO}")
    private controller.TicketDAO ticketDAO;

    public void setTicketDAO(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }
    
    
    @ManagedProperty(value = "#{database}")
    private controller.Database database;

    public void setDatabase(Database database) {
        this.database = database;
    }

    @ManagedProperty(value = "#{booking}")
    private beans.Booking booking;

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @ManagedProperty(value = "#{user}")
    private beans.User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    
    

    @ManagedProperty(value = "#{stopageDAO}")
    private StopageDAO stopageDAO;

    public void setStopageDAO(StopageDAO stopageDAO) {
        this.stopageDAO = stopageDAO;
    }

    @ManagedProperty(value = "#{seatBookingDAO}")
    private SeatBookingDAO seatBookingDAO;

    public void setSeatBookingDAO(SeatBookingDAO seatBookingDAO) {
        this.seatBookingDAO = seatBookingDAO;
    }

    @ManagedProperty(value = "#{seatManagedBean}")
    private mypkg.SeatManagedBean seatManagedBean;

    public void setSeatManagedBean(SeatManagedBean seatManagedBean) {
        this.seatManagedBean = seatManagedBean;
    }

    @ManagedProperty(value = "#{sessionBean}")
    private beans.SessionBean sessionBean;

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public BookingDAO() {

    }

    private List<String> selectedSeats;

    public void bookingFirstStage() {
        System.out.println("From First Stage function");
        booking.setScheId(sessionBean.getSelectedSchedul().getSchedulId());
        booking.setTotalCost(seatManagedBean.getTotalFare());
        booking.setTotalSeat(seatManagedBean.getTotoalSelectedSeat());
        booking.setSelectedSeats(seatManagedBean.getSelectedSeats());
        sessionBean.setSelectedSeats(seatManagedBean.getSelectedSeats());
        String userId = String.valueOf(new java.util.Date().getTime());

        user.setUserId(userId);
        booking.setUserId(userId);

        /*
         //final result
         System.out.println("scheId: "+booking.getScheId());
         System.out.println("userId:" +user.getUserId());
         System.out.println("TotalSeat: "+booking.getTotalSeat());
         System.out.println("Seat Numbers:" +booking.getSelectedSeats());
         //System.out.println("Stopage: "+booking.getStopageid());
         java.sql.Date sqlDate = TimeConverter.sqlDate(new java.util.Date());
         System.out.println("Booking Time:"+sqlDate);
         System.out.println("Paymethod:"+booking.getPayMethodId());
         System.out.println("Tranxid:");
         System.out.println("Total cost"+booking.getTotalCost());
         System.out.println("Pin:"+new java.util.Date().getTime());
         System.out.println("Booking Status: 0");
         */
    }

    public void bookingConfirm() {

        System.out.println("scheId: " + booking.getScheId());
        System.out.println("userId:" + booking.getUserId());
        System.out.println("TotalSeat: " + booking.getTotalSeat());
        System.out.println("Seat Numbers:" + booking.getSelectedSeats().toString());
        System.out.println("Stopage: " + booking.getStopageid());
        //System.out.println("Booking Time:" + booking.getBookingTime());
        System.out.println("Paymethod:" + booking.getPayMethodId());
        System.out.println("Tranxid:");
        System.out.println("Total cost" + booking.getTotalCost());
        //System.out.println("Pin:" + booking.getPin());
        System.out.println("Booking Status: " + booking.getBookingStatus());

        addBooking();
        
        
        
        

    }

    public void addBooking() {

        java.sql.Date sqlDate = TimeConverter.sqlDate(new java.util.Date());
        //booking.setBookingTime(sqlDate);
        booking.setPin(String.valueOf(new java.util.Date().getTime()));
        
        //ticketDAO.getTicket(booking.getPin());
        booking.setBookingStatus(0);
        try {

            String sql = "INSERT INTO bus.booking (sche_id,user_id,total_seat,seat_numbers,bording_stopage_id,booking_time,pay_method_id,total_cost,pin,booking_status)  VALUES (?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);

            preparedStatement.setInt(1, booking.getScheId());
            preparedStatement.setString(2, booking.getUserId());
            preparedStatement.setInt(3, booking.getTotalSeat());
            preparedStatement.setString(4, booking.getSelectedSeats().toString());
            preparedStatement.setInt(5, booking.getStopageid());
            preparedStatement.setDate(6, (Date)sqlDate);
            preparedStatement.setInt(7, booking.getPayMethodId());
            preparedStatement.setInt(8, booking.getTotalCost());
            preparedStatement.setString(9, booking.getPin());
            preparedStatement.setInt(10, booking.getBookingStatus());

            preparedStatement.executeUpdate();
            System.out.println("Booking Added successfully.");
        } catch (SQLException ex) {
            Logger.getLogger(BusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Booking> getAllBookings() {
        ResultSet rs = null;
        PreparedStatement pst = null;

        String stm = "Select * from bus.booking";
        List<Booking> records = new ArrayList<Booking>();
        try {
            pst = database.getCon().prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                Booking booking = new Booking();
                booking.setBookingId(rs.getInt(1));
                booking.setScheId(rs.getInt(2));
                booking.setUserId(rs.getString(3));
                booking.setTotalSeat(rs.getInt(4));
                
                String s = rs.getString(5);
                List<String> myList = new ArrayList<String>(Arrays.asList(s.split(",")));
                booking.setSelectedSeats(myList);
               // booking.setSelectedSeats(rs.getString(5));
                booking.setStopageid(rs.getInt(6));
                booking.setBookingTime(rs.getDate(7));
                booking.setPayMethodId(rs.getInt(8));
                booking.setTranxid(rs.getInt(9));
                booking.setTotalCost(rs.getInt(10));
                booking.setPin(rs.getString(11));
                booking.setBookingStatus(rs.getInt(12));
                
                records.add(booking);

            }
        } catch (SQLException e) {
        }
        return records;

    }

}
