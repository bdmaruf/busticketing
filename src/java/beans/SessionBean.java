/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author maruf
 */
@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable{

    private Location selectedLocation;
    private Route selectedRoute;
    private Bus selectedBus;
    private Schedul selectedSchedul;
    private Stopage selectedStopage;
    private List<String> selectedSeats;
    private String adminloginstatus ;
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public String getAdminloginstatus() {
        return adminloginstatus;
    }

    public void setAdminloginstatus(String adminloginstatus) {
        this.adminloginstatus = adminloginstatus;
    }
    
    

    public List<String> getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(List<String> selectedSeats) {
        System.out.println("From session selected seat method");
        this.selectedSeats = selectedSeats;

    }

    public Stopage getSelectedStopage() {
        return selectedStopage;
    }

    public void setSelectedStopage(Stopage selectedStopage) {
        this.selectedStopage = selectedStopage;
    }

    public Schedul getSelectedSchedul() {
        System.out.println("Present time: "+new java.util.Date().getTime());
        return selectedSchedul;
    }

    public void setSelectedSchedul(Schedul selectedSchedul) {
        this.selectedSchedul = selectedSchedul;
    }

    public Bus getSelectedBus() {
        return selectedBus;
    }

    public void setSelectedBus(Bus selectedBus) {
        this.selectedBus = selectedBus;
    }

    public Location getSelectedLocation() {
        return selectedLocation;
    }

    public void setSelectedLocation(Location selectedLocation) {
        this.selectedLocation = selectedLocation;
    }

    public Route getSelectedRoute() {
        return selectedRoute;
    }

    public void setSelectedRoute(Route selectedRoute) {
        this.selectedRoute = selectedRoute;
    }

}
