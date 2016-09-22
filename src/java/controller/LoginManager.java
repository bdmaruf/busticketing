/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.SessionBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author maruf
 */
@ManagedBean(name = "loginManager")
@RequestScoped
public class LoginManager {

    


    @ManagedProperty(value = "#{sessionBean}")
    private beans.SessionBean session;

    public void setSession(SessionBean session) {
        this.session = session;
    }

    public String userAuthentication() {
        if ("admin".equals(session.getUserName()) && "123".equals(session.getPassword())) {
            session.setAdminloginstatus("success");
            System.out.println("success");
            return "success";
        } else {
            session.setAdminloginstatus("fail");
            return "fail";
        }
    }

    public LoginManager() {
    }

}
