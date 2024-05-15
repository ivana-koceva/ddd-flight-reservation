package mk.finki.ukim.emt.flightlist.domain.repository;

import mk.finki.ukim.emt.flightlist.domain.model.Flight;
import mk.finki.ukim.emt.flightlist.domain.model.FlightId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, FlightId> {
}
