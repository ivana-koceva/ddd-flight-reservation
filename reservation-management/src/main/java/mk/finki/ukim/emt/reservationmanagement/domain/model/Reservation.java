package mk.finki.ukim.emt.reservationmanagement.domain.model;

import jakarta.persistence.*;
import lombok.NonNull;
import mk.finki.ukim.emt.reservationmanagement.domain.valueobjects.FlightId;
import mk.finki.ukim.emt.reservationmanagement.domain.valueobjects.SeatNumber;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Reservation extends AbstractEntity<ReservationId> {

    @AttributeOverride(name = "id", column = @Column(name = "flight_id", nullable = false))
    private FlightId flightId;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Passenger> passengers = new HashSet<>();
    private SeatNumber seatNumber;
    private Date ReservationDate;

    public Passenger addPassenger(@NonNull Passenger passenger) {
        Objects.requireNonNull(passenger,"passenger must not be null");
        passengers.add(passenger);
        return passenger;
    }

    public void removeItem(@NonNull PassengerId passengerId) {
        Objects.requireNonNull(passengerId,"passenger must not be null");
        passengers.removeIf(v->v.getId().equals(passengerId));
    }

}
