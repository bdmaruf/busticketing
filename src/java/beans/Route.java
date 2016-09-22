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
public class Route {

    private int routeId;
    private String routeName;
    private int fromLocId;
    private int toLocId;
    
    public Route() {
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public int getFromLocId() {
        return fromLocId;
    }

    public void setFromLocId(int fromLocId) {
        this.fromLocId = fromLocId;
    }

    public int getToLocId() {
        return toLocId;
    }

    public void setToLocId(int toLocId) {
        this.toLocId = toLocId;
    }
    
}
