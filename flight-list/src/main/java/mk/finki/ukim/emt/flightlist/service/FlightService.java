package mk.finki.ukim.emt.flightlist.service;

import mk.finki.ukim.emt.flightlist.domain.model.Flight;
import mk.finki.ukim.emt.flightlist.domain.model.FlightId;
import mk.finki.ukim.emt.flightlist.service.forms.FlightForm;

import java.util.List;

public interface FlightService {

    Flight findById(FlightId id);
    Flight createFlight(FlightForm form);
    Flight seatTaken(FlightId productId, int qty);
    Flight seatRemoved(FlightId productId, int qty);
    List<Flight> getAll();

}
