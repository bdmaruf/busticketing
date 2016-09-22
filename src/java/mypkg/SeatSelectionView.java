/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

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
public class SeatSelectionView {
     
    private String[] selectedConsoles; 
    private String[] selectedSeats;  
    private List<String> seatnumbers;
     
    @PostConstruct
    public void init() {
        seatnumbers = new ArrayList<String>();
        seatnumbers.add("A1");
        seatnumbers.add("A2");
        seatnumbers.add("A3");
        seatnumbers.add("A4");
        seatnumbers.add("B1");
        seatnumbers.add("B2");
        seatnumbers.add("B3");
        seatnumbers.add("B4");
        seatnumbers.add("C1");
        seatnumbers.add("C2");
        seatnumbers.add("C3");
        seatnumbers.add("C4");
        seatnumbers.add("D1");
        seatnumbers.add("D2");
        seatnumbers.add("D3");
        seatnumbers.add("D4");
        seatnumbers.add("E1");
        seatnumbers.add("E2");
        seatnumbers.add("E3");
        seatnumbers.add("E4");
        seatnumbers.add("F1");
        seatnumbers.add("F2");
        seatnumbers.add("F3");
        seatnumbers.add("F4");
        seatnumbers.add("G1");
        seatnumbers.add("G2");
        seatnumbers.add("G3");
        seatnumbers.add("G4");
        seatnumbers.add("H1");
        seatnumbers.add("H2");
        seatnumbers.add("H3");
        seatnumbers.add("H4");
        seatnumbers.add("I1");
        seatnumbers.add("I2");
        seatnumbers.add("I3");
        seatnumbers.add("I4");
    }
 
    public String[] getSelectedConsoles() {
        return selectedConsoles;
    }
 
    public void setSelectedConsoles(String[] selectedConsoles) {
        this.selectedConsoles = selectedConsoles;
    }
 
    public String[] getSelectedSeats() {
        return selectedSeats;
    }
 
    public void setSelectedSeats(String[] selectedSeats) {
        this.selectedSeats = selectedSeats;
    }
 
    public List<String> getSeatnumbers() {
        return seatnumbers;
    }
}
