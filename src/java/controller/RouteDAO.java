package controller;

import beans.Location;
import beans.Route;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RouteDAO implements Serializable {

    private Route selectedRoute;
    @ManagedProperty(value = "#{database}")
    private controller.Database database;

    public void setDatabase(Database database) {
        this.database = database;
    }

    public RouteDAO() {

    }

    public Route getSelectedRoute() {
        return selectedRoute;
    }

    public void setSelectedRoute(Route selectedRoute) {
        this.selectedRoute = selectedRoute;
    }

    public List<Route> getAllRoutes() {
        ResultSet rs = null;
        PreparedStatement pst = null;

        String stm = "Select * from bus.route";
        List<Route> records = new ArrayList<Route>();
        try {
            pst = database.getCon().prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                Route route = new Route();
                route.setRouteId(rs.getInt(1));
                route.setRouteName(rs.getString(2));
                route.setFromLocId(rs.getInt(3));
                route.setToLocId(rs.getInt(4));
                records.add(route);
            }
        } catch (SQLException e) {
        }
        return records;

    }

    public void editRoute(Route route) {
        System.out.println("Route Name= " + route.getRouteName());
        try {

            //String sql1 ="UPDATE maruf.student SET firstName ='Abdullah Al' where id = '1'";
            //String sql1 ="UPDATE maruf.student SET firstName ='"+student.getFirstName()+"' where id ='"+student.getId()+"'";
            String sql = "UPDATE bus.route SET route_name ='" + route.getRouteName() + "' , "
                    + "from_loc_id = '" + route.getFromLocId() + "',to_loc_id ='" + route.getToLocId() + "' where route_id ='" + route.getRouteId() + "'";
            String sql1 = "UPDATE bus.route SET route_name ='" + route.getRouteName() + "',from_loc_id= '" + route.getFromLocId() + "',to_loc_id='" + route.getToLocId() + "' where route_id ='" + route.getRouteId() + "'";
            String sql2 = "UPDATE bus.route SET route_name ='" + route.getRouteName() + "',from_loc_id= '" + route.getFromLocId() + "',to_loc_id='" + route.getToLocId() + "' where route_id ='" + route.getRouteId() + "'";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql2);
            System.out.println(route.getRouteName());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RouteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addRoute(Route route) {
        try {

            String sql = "INSERT INTO bus.route (route_name,from_loc_id,to_loc_id)  VALUES (?,?,?)";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);
            preparedStatement.setString(1, route.getRouteName());
            preparedStatement.setInt(2, route.getFromLocId());
            preparedStatement.setInt(3, route.getToLocId());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RouteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteRoute(Route route) {
        try {

            //String sql1 ="UPDATE maruf.student SET firstName ='Abdullah Al' where id = '1'";
            String sql = "DELETE FROM bus.route where route_id ='" + route.getRouteId() + "'";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RouteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
