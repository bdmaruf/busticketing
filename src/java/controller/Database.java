/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author maruf
 */
@ManagedBean(name = "database")
@ApplicationScoped
public class Database {

    /**
     * Creates a new instance of Database
     */
    public Database() {
    }
    Connection con = null;

    public void createConnection() {
        String url = "jdbc:mysql://localhost:3306/maruf";
        String user = "root";
        String password = "maruf";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection completed.");
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        } finally {
        }

    }

    public Connection getCon() {
        if (con != null) {
            return con;
        } else {
            createConnection();
            return con;
        }
    }

    public void setCon(Connection con) {
        String url = "jdbc:mysql://localhost:3306/maruf";
        String user = "root";
        String password = "maruf";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection completed.");
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        } finally {
        }

        this.con = con;
    }

}
