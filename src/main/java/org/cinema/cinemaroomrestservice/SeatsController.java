package org.cinema.cinemaroomrestservice;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatsController {
    public Seats getAllSeats() {
        int totalRows = 9;
        int totalColumns = 9;
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 1; j <= totalColumns; j++) {
                seats.add(new Seat(i,j));
            }
        }
        return new Seats(totalRows,totalColumns,seats);
    }

    @GetMapping("/seats")
    public Seats getSeats() {
        return getAllSeats();
    }
}
