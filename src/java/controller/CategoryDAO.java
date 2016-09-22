/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Category;
import beans.Location;
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

/**
 *
 * @author maruf
 */
@ManagedBean
@RequestScoped
public class CategoryDAO implements Serializable {

    private static Category selectedCategory;

    @ManagedProperty(value = "#{database}")
    private controller.Database database;

    public void setDatabase(Database database) {
        this.database = database;
    }

    public CategoryDAO() {

    }

    public Category getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(Category selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public List<Category> getAllCategory() {
        ResultSet rs = null;
        PreparedStatement pst = null;

        String stm = "Select * from bus.category";
        List<Category> records = new ArrayList<Category>();
        try {
            pst = database.getCon().prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                Category category = new Category();
                category.setCategoryId(rs.getInt(1));
                category.setCategoryName(rs.getString(2));
                category.setFacility(rs.getString(3));
                records.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;

    }

    public void editCategory(Category category) {
        try {

            //String sql1 ="UPDATE maruf.student SET firstName ='Abdullah Al' where id = '1'";
            //String sql1 ="UPDATE maruf.student SET firstName ='"+student.getFirstName()+"' where id ='"+student.getId()+"'";
            String sql = "UPDATE bus.category SET category_name ='" + category.getCategoryName() + "' , "
                    + "facility = '" + category.getFacility() + "' where category_id ='" + category.getCategoryId() + "'";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addCategory(Category category) {
        try {

            String sql = "INSERT INTO bus.category (category_name,facility)  VALUES (?,?)";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.setString(2, category.getFacility());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteCategory(Category category) {
        try {

            //String sql1 ="UPDATE maruf.student SET firstName ='Abdullah Al' where id = '1'";
            String sql = "DELETE FROM bus.category where category_id ='" + category.getCategoryId() + "'";
            PreparedStatement preparedStatement = database.getCon().prepareStatement(sql);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
