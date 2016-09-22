/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Searchview;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author maruf
 */
@ManagedBean
@RequestScoped
public class SearchviewDAO implements Serializable {

    private List<Searchview> searchviewlist = new ArrayList<Searchview>();

    @ManagedProperty(value = "#{database}")
    private controller.Database database;

    public void setDatabase(Database database) {
        this.database = database;
    }

    public SearchviewDAO() {
        //setSearchView();
    }

    public void setSearchView() {
        ResultSet rs = null;
        PreparedStatement pst = null;

        Connection con = database.getCon();
        String stm = "Select * from bus.searchview";
        Searchview searchview = new Searchview();
        try {
            pst = con.prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                searchview.setScheId(rs.getInt(1));
                searchview.setOptName(rs.getString(2));
                searchview.setCategoryName(rs.getString(3));
                searchviewlist.add(searchview);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Searchview getView(int scheId) {
        Searchview result = new Searchview();
        for (Searchview searchviewlist1 : this.searchviewlist) {
            if (searchviewlist1.getScheId() == scheId) {
                result = searchviewlist1;
            }
        }
        return result;
    }

    public String getOperatorName(int scheId) {
        String result = new String();
        ResultSet rs = null;
        PreparedStatement pst = null;

        String stm = "select opt_name from bus.searchview where sche_id = " + scheId + "";

        try {
            pst = database.getCon().prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                result = rs.getString(1);

            }
        } catch (SQLException e) {
        }

        return result;
    }

    public String getCategoryName(int scheId) {
        String result = new String();
        ResultSet rs = null;
        PreparedStatement pst = null;

        String stm = "select category_name from bus.searchview where sche_id = " + scheId + "";

        try {
            pst = database.getCon().prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                result = rs.getString(1);

            }
        } catch (SQLException e) {
        }

        return result;
    }
    public int getAvailableSeat(int scheId){
        int result = 0;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm ="select available_seat from bus.availableseats where sche_id ="+scheId +" ";
        try{
            pst = database.getCon().prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();
            while(rs.next()){
                result = rs.getInt(1);
                
            }
        }
        catch(SQLException e){
        }
        return result;
    }

}
