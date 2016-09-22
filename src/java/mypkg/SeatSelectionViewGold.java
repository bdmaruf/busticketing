/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import controller.SeatBookingDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author maruf
 */
@ManagedBean
@RequestScoped
public class SeatSelectionViewGold {

    private String[] selectedConsoles; 
    private List<String> selectedSeats ;
    private List<String> selectedSeatsNew ; 
    private List<String> seatnumbers;
    private SeatBookingDAO seatBookingDAO = new SeatBookingDAO(); 
    @PostConstruct
    public void init() {
        seatnumbers = new ArrayList<String>();
        seatnumbers.add("A1");
        seatnumbers.add("A2");
        seatnumbers.add("A3");
        seatnumbers.add("B1");
        seatnumbers.add("B2");
        seatnumbers.add("B3");
        
        seatnumbers.add("C1");
        seatnumbers.add("C2");
        seatnumbers.add("C3");
        
        seatnumbers.add("D1");
        seatnumbers.add("D2");
        seatnumbers.add("D3");
        
        seatnumbers.add("E1");
        seatnumbers.add("E2");
        seatnumbers.add("E3");
        
        seatnumbers.add("F1");
        seatnumbers.add("F2");
        seatnumbers.add("F3");
        
        seatnumbers.add("G1");
        seatnumbers.add("G2");
        seatnumbers.add("G3");
        
        seatnumbers.add("H1");
        seatnumbers.add("H2");
        seatnumbers.add("H3");
        
        seatnumbers.add("I1");
        seatnumbers.add("I2");
        seatnumbers.add("I3");
        
    }

    public SeatSelectionViewGold() {
        selectedSeats = seatBookingDAO.getBookedSeatNumber();
    }
    
 
    public String[] getSelectedConsoles() {
        return selectedConsoles;
    }
 
    public void setSelectedConsoles(String[] selectedConsoles) {
        this.selectedConsoles = selectedConsoles;
    }
    
    public List<String> getSelectedSeats() {
        
        return selectedSeats;
    }

    public void setSelectedSeats(List<String> selectedSeats) {
        this.setSelectedSeatsNew(selectedSeats);
        this.selectedSeats = selectedSeats;
    }

    public List<String> getSelectedSeatsNew() {
        
        return selectedSeatsNew;
    }

    public void setSelectedSeatsNew(List<String> selectedSeatsNew) {
        this.selectedSeatsNew = selectedSeatsNew;
    }
 
    
 
    
    public List<String> getSeatnumbers() {
        return seatnumbers;
    }
    
}
