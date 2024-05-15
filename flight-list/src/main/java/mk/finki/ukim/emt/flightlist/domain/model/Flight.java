package mk.finki.ukim.emt.flightlist.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.finki.ukim.emt.flightlist.domain.valueobjects.AvailableSeats;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;

import java.util.Date;

@Entity
@Table(name="flight")
@Getter
public class Flight extends AbstractEntity<FlightId> {

    private String DepartureCity;
    private String DestinationCity;
    private Date DepartureTime;
    private Date ArrivalTime;
    private Money ticketPrice;
    private int availableSeats;

    public Flight() {
        super(FlightId.randomId(FlightId.class));
    }

    public static Flight build(String DepartureCity, String DestinationCity, Date DepartureTime, Date ArrivalTime,
    Money ticketPrice, int availableSeats) {
        Flight f = new Flight();
        f.DepartureCity = DepartureCity;
        f.DestinationCity = DestinationCity;
        f.DepartureTime = DepartureTime;
        f.ArrivalTime = ArrivalTime;
        f.ticketPrice = ticketPrice;
        f.availableSeats = availableSeats;
        return f;
    }

    public void addSeat() {
        this.availableSeats += 1;
    }

    public void removeSeat() {
        this.availableSeats -= 1;
    }



}
