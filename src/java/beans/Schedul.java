/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controller.TimeConverter;
import java.sql.Date;
import java.sql.Time;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class Schedul {

    private int schedulId;
    private int busId;
    private Date dprtDate;
    private Time dprtTime;
    private Date arivDate;
    private Time arivTime;
    private java.util.Date dprtCalanDate;
    private java.util.Date dprtCalanTime;
    private java.util.Date arivCalanDate;
    private java.util.Date arivCalanTime;
    private int fare;
    private int schedulStatus;
    
    
    
    
    public Schedul() {
    }

    public int getSchedulId() {
        return schedulId;
    }

    public void setSchedulId(int schedulId) {
        this.schedulId = schedulId;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
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

    public Date getArivDate() {
        return arivDate;
    }

    public void setArivDate(Date arivDate) {
        this.arivDate = arivDate;
    }

    public Time getArivTime() {
        return arivTime;
    }

    public void setArivTime(Time arivTime) {
        this.arivTime = arivTime;
    }

    public java.util.Date getDprtCalanDate() {
        return dprtCalanDate;
    }

    public void setDprtCalanDate(java.util.Date dprtCalanDate) {
        this.dprtCalanDate = dprtCalanDate;
        setDprtDate(TimeConverter.sqlDate(dprtCalanDate));
        
    }

    public java.util.Date getDprtCalanTime() {
        return dprtCalanTime;
    }

    public void setDprtCalanTime(java.util.Date dprtCalanTime) {
        this.dprtCalanTime = dprtCalanTime;
        setDprtTime(TimeConverter.sqlTime(dprtCalanTime));
    }

    public java.util.Date getArivCalanDate() {
        return arivCalanDate;
    }

    public void setArivCalanDate(java.util.Date arivCalanDate) {
        this.arivCalanDate = arivCalanDate;
        setArivDate(TimeConverter.sqlDate(arivCalanDate));
    }

    public java.util.Date getArivCalanTime() {
        return arivCalanTime;
    }

    public void setArivCalanTime(java.util.Date arivCalanTime) {
        this.arivCalanTime = arivCalanTime;
        setArivTime(TimeConverter.sqlTime(arivCalanTime));
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public int getSchedulStatus() {
        return schedulStatus;
    }

    public void setSchedulStatus(int schedulStatus) {
        this.schedulStatus = schedulStatus;
    }

   

    
    
}
