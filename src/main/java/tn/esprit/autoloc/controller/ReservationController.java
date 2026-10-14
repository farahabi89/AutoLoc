
package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    private final IReservationService reservationService;

    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        return reservationService.retrieveAllReservations();
    }

    @GetMapping("/retrieve-reservation/{reservationId}")
    public Reservation retrieveReservation(@PathVariable Long reservationId) {
        return reservationService.retrieveReservation(reservationId);
    }

    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @DeleteMapping("/remove-reservation/{reservationId}")
    public void removeReservation(@PathVariable Long reservationId) {
        reservationService.removeReservation(reservationId);
    }

    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation reservation) {
        return reservationService.modifyReservation(reservation);
    }
}
