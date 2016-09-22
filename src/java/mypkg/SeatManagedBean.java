/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import beans.SessionBean;
import controller.SearchviewDAO;
import controller.SeatBookingDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author maruf
 */
@ManagedBean(name = "seatManagedBean")
@RequestScoped
public class SeatManagedBean {

    private List<Seat> seatList;
    private static List<String> selectedSeats;
    private int seatArrangeColumn = 4;
    Seat seat;
    private int totalFare = 0;
    private static int totoalSelectedSeat;

    @ManagedProperty(value = "#{seatBookingDAO}")
    private controller.SeatBookingDAO seatBookingDAO;

    public void setSeatBookingDAO(SeatBookingDAO seatBookingDAO) {
        this.seatBookingDAO = seatBookingDAO;
    }

    @ManagedProperty(value = "#{sessionBean}")
    private beans.SessionBean sessionBean;

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    @ManagedProperty(value = "#{searchviewDAO}")
    private controller.SearchviewDAO searchviewDAO;

    public void setSearchviewDAO(SearchviewDAO searchviewDAO) {
        this.searchviewDAO = searchviewDAO;
    }
    
    
    public SeatManagedBean() {

        
    }

    public void prepareSeatView() {

    }

    public int getSeatArrangeColumn() {
        return seatArrangeColumn;
    }

    public void setSeatArrangeColumn(int seatArrangeColumn) {
        this.seatArrangeColumn = seatArrangeColumn;
    }

    public int getTotoalSelectedSeat() {
        return totoalSelectedSeat;
    }

    public void setTotoalSelectedSeat(int totoalSelectedSeat) {
        this.totoalSelectedSeat = totoalSelectedSeat;
    }

    public List<String> getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(List<String> selectedSeats) {

        setTotalFare(selectedSeats.size() * sessionBean.getSelectedSchedul().getFare());
        totoalSelectedSeat = selectedSeats.size();
        SeatManagedBean.selectedSeats = selectedSeats;
        //sessionBean.setSelectedSeats(selectedSeats);
    }

    public int getTotalFare() {

        return totalFare;
    }

    public void setTotalFare(int totalFare) {
        this.totalFare = totalFare;
    }

    public List<Seat> getSeatList() {
        seatIni();
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        //prepareSeatView();
        this.seatList = seatList;
    }

    public void seatIni() {
        seatList = new ArrayList<Seat>();
        selectedSeats = new ArrayList<String>();
        //int a = 2;
        String cat = searchviewDAO.getCategoryName(sessionBean.getSelectedSchedul().getSchedulId());
        System.out.println("Category is : "+cat);
        if(cat.equalsIgnoreCase("Business")){
            seatArrangeColumn = 3;
        }
        else{
            seatArrangeColumn =4;
        }
        //System.out.println("value of a:"+ a);
        if (seatArrangeColumn > 3) {

            seat = new Seat();
            seat.setName("A1");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("A2");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("A3");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("A4");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("B1");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("B2");
            seat.setChecked(false);
            seatList.add(seat);
            seat = new Seat();
            seat.setName("B3");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("B4");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("C1");
            seat.setChecked(false);
            seatList.add(seat);
            seat = new Seat();

            seat.setName("C2");
            seat.setChecked(false);
            seatList.add(seat);
            seat = new Seat();
            seat.setName("C3");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("C4");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("D1");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("D2");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("D3");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("D4");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("E1");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("E2");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("E3");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("E4");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("F1");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("F2");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("F3");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("F4");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("G1");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("G2");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("G3");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("G4");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("H1");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("H2");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("H3");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("H4");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("I1");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("I2");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("I3");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("I4");
            seat.setChecked(false);
            seatList.add(seat);
        } else {

            seat = new Seat();
            seat.setName("A1");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("A2");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("A3");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("B1");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("B2");
            seat.setChecked(false);
            seatList.add(seat);
            seat = new Seat();
            seat.setName("B3");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("C1");
            seat.setChecked(false);
            seatList.add(seat);
            seat = new Seat();

            seat.setName("C2");
            seat.setChecked(false);
            seatList.add(seat);
            seat = new Seat();
            seat.setName("C3");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("D1");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("D2");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("D3");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("E1");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("E2");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("E3");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("F1");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("F2");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("F3");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("G1");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("G2");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("G3");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("H1");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("H2");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("H3");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("I1");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("2");
            seat.setChecked(false);
            seatList.add(seat);

            seat = new Seat();
            seat.setName("I3");
            seat.setChecked(false);
            seatList.add(seat);
        }

        List<String> selectedSeats = seatBookingDAO.getBookedSeatNumber();
        for (int j = 0; j < selectedSeats.size(); j++) {
            //System.out.println(selectedSeats.get(j));
            for (int i = 0; i < seatList.size(); i++) {
                //System.out.println("original: "+seatList.get(i).getName());
                if (seatList.get(i).getName().equals(selectedSeats.get(j)) == true) {
                    seatList.get(i).setDisabled(true);

                }
            }
        }

    }

}
