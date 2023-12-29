package org.cinema.cinemaroomrestservice;

import java.util.List;

public class CinemaResponse {
    private final int rows;
    private final int columns;
    private final List<Seat> seats;

    public CinemaResponse(int rows, int columns, List<Seat> seats) {
        this.rows = rows;
        this.columns = columns;
        this.seats = seats;
    }


}

