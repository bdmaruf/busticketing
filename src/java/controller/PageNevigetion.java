/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Booking;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


@ManagedBean( name = "pageNevigetion")
@SessionScoped
public class PageNevigetion implements Serializable{

    @ManagedProperty(value = "#{booking}")
    private beans.Booking booking;

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
    
    public PageNevigetion(){
    }
    public String payPage() {
        if(booking.getPayMethodId() == 1){
            return "bkash";
        }
        else if(booking.getPayMethodId() == 2){
            return "mkash";
        }
        else {
            return "credit";
        }
    }
    
    
    
}
