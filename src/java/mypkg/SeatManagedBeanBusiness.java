/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import controller.SeatBookingDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author maruf
 */
@ManagedBean
@RequestScoped
public class SeatManagedBeanBusiness {

    private SeatBookingDAO seatBookingDAO;
    private List<Seat> seatList;
    private List<String> selectedSeats;
    Seat seat;

    public SeatManagedBeanBusiness() {
        seatBookingDAO = new SeatBookingDAO();
        seatList = new ArrayList<Seat>();
        
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

        seatIni();

    }

    public List<String> getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(List<String> selectedSeats) {
        this.selectedSeats = selectedSeats;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public void seatIni() {
        List<String> selectedSeats = seatBookingDAO.getBookedSeatNumber();
        for (int j = 0; j < selectedSeats.size(); j++) {
            System.out.println(selectedSeats.get(j));
            for (int i = 0; i < seatList.size(); i++) {
                if (seatList.get(i).getName().equals(selectedSeats.get(j)) == true) {
                    seatList.get(i).setDisabled(true);

                }
            }
        }

    }

}
