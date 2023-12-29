package org.cinema.cinemaroomrestservice;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private int totalRows, totalColumns;
    private List<Seat> availableSeats;
    @JsonIgnore
    private List<OrderedSeat> orderedSets = new ArrayList<>();

    public Cinema(int totalRows, int totalColumns, List<Seat> availableSeats) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.availableSeats = availableSeats;
    }

    public Cinema() {

    }

    public static Cinema getAllSeats(int rows, int columns) {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                seats.add(new Seat(i, j));
            }
        }
        return new Cinema(rows, columns, seats);
    }

    public boolean validateCinemaPurchase(Seat seat, Cinema cinema) {
        return seat.getColumn() > cinema.getTotalColumns()
                || seat.getRow() > cinema.getTotalRows()
                || seat.getRow() < 1
                || seat.getColumn() < 1;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public List<OrderedSeat> getOrderedSets() {
        return orderedSets;
    }

    public void setOrderedSets(List<OrderedSeat> orderedSets) {
        this.orderedSets = orderedSets;
    }
}
