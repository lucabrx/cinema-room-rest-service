package org.cinema.cinemaroomrestservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class CinemaController {
    private Cinema cinema;

    public CinemaController() {
        this.cinema = Cinema.getAllSeats(9,9);
    }


    @GetMapping("/seats")
    public CinemaResponse getSeats() {
        return new CinemaResponse(cinema.getTotalRows(), cinema.getTotalColumns(), cinema.getAvailableSeats());
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchase(@RequestBody Seat seat) {
        if(cinema.validateCinemaPurchase(seat, cinema)) {
            return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        }

        for(int i = 0; i < cinema.getAvailableSeats().size(); i++) {
            Seat s = cinema.getAvailableSeats().get(i);
            if (s.equals(seat)) {
                OrderedSeat orderedSeat = new OrderedSeat(UUID.randomUUID(), s);
                cinema.getOrderedSets().add(orderedSeat);
                cinema.getAvailableSeats().remove(i);
                return new ResponseEntity<>(orderedSeat, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody Token token) {
        List<OrderedSeat> orderedSeats = cinema.getOrderedSets();
        for (OrderedSeat orderedSeat : orderedSeats) {
            if (orderedSeat.getToken().equals(token.getToken())) {
                orderedSeats.remove(orderedSeat);
                cinema.getAvailableSeats().add(orderedSeat.getTicket());
                return new ResponseEntity<>(Map.of("ticket", orderedSeat.getTicket()), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(Map.of("error", "Wrong token!"), HttpStatus.BAD_REQUEST);
    }
}
