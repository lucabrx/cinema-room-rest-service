package org.cinema.cinemaroomrestservice;

import java.util.List;

public class Seats {
    private int totalRows, totalColumns;
    private List<Seat> available_seats;

    public Seats(int total_rows, int total_columns, List<Seat> available_seats) {
        this.totalRows = total_rows;
        this.totalColumns = total_columns;
        this.available_seats = available_seats;
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

    public List<Seat> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<Seat> available_seats) {
        this.available_seats = available_seats;
    }
}

