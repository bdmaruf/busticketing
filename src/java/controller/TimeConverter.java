/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author maruf
 */
public class TimeConverter {

    public static java.sql.Date sqlDate(java.util.Date calendarDate) {
        return new java.sql.Date(calendarDate.getTime());
    }

    public static java.sql.Time sqlTime(java.util.Date calendarDate) {
        return new java.sql.Time(calendarDate.getTime());
    }

    public static java.util.Date utilDate(java.sql.Date sqldate) {
        return new java.util.Date(sqldate.getTime());
    }

    public static java.util.Date utiltime(java.sql.Time sqltime) {
        return new java.util.Date(sqltime.getTime());
    }
    

}
