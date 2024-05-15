package mk.finki.ukim.emt.flightlist.service.forms;

import lombok.Data;
import mk.finki.ukim.emt.flightlist.domain.valueobjects.AvailableSeats;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;

import java.util.Date;
@Data
public class FlightForm {
    private String DepartureCity;
    private String DestinationCity;
    private Date DepartureTime;
    private Date ArrivalTime;
    private Money ticketPrice;
    private int availableSeats;
}
