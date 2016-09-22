/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author maruf
 */
@ManagedBean(name = "ticket")
@SessionScoped
public class Ticket implements Serializable{

    private int bookingId;
    private String pin;
    private int scheId;
    private String seatNumbers;
    private int totalCost;
    private String fromLocation;
    private String toLocation;
    private String optName;
    private String categoryName;
    private Date dprtDate;
    private Time dprtTime;
    private String userFirstName;
    private int userAge;
    private String stopageName;

    public Ticket() {
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getScheId() {
        return scheId;
    }

    public void setScheId(int scheId) {
        this.scheId = scheId;
    }

    public String getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(String seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getOptName() {
        return optName;
    }

    public void setOptName(String optName) {
        this.optName = optName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getDprtDate() {
        return dprtDate;
    }

    public void setDprtDate(Date dprtDate) {
        this.dprtDate = dprtDate;
    }

    public Time getDprtTime() {
        return dprtTime;
    }

    public void setDprtTime(Time dprtTime) {
        this.dprtTime = dprtTime;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getStopageName() {
        return stopageName;
    }

    public void setStopageName(String stopageName) {
        this.stopageName = stopageName;
    }

    
}
