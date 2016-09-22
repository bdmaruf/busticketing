/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author maruf
 */
@ManagedBean
@RequestScoped
public class SeatBooking {

    private int seatbookingId;
    private int scheId;
    private String seatNumber;
    
    public SeatBooking() {
    }

    public int getSeatbookingId() {
        return seatbookingId;
    }

    public void setSeatbookingId(int seatbookingId) {
        this.seatbookingId = seatbookingId;
    }

    public int getScheId() {
        return scheId;
    }

    public void setScheId(int scheId) {
        this.scheId = scheId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
    
}
