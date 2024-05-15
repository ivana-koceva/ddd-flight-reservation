package mk.finki.ukim.emt.reservationmanagement.domain.repository;

import mk.finki.ukim.emt.reservationmanagement.domain.model.Reservation;
import mk.finki.ukim.emt.reservationmanagement.domain.model.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {
}
