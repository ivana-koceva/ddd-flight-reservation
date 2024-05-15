package mk.finki.ukim.emt.flightlist.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.finki.ukim.emt.flightlist.domain.exceptions.FlightNotFoundException;
import mk.finki.ukim.emt.flightlist.domain.model.Flight;
import mk.finki.ukim.emt.flightlist.domain.model.FlightId;
import mk.finki.ukim.emt.flightlist.domain.repository.FlightRepository;
import mk.finki.ukim.emt.flightlist.service.FlightService;
import mk.finki.ukim.emt.flightlist.service.forms.FlightForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Override
    public Flight findById(FlightId id) {
        return flightRepository.findById(id).orElseThrow(FlightNotFoundException::new);
    }

    @Override
    public Flight createFlight(FlightForm form) {
        Flight f = Flight.build(form.getDepartureCity(), form.getDestinationCity(), form.getDepartureTime(),
                form.getArrivalTime(), form.getTicketPrice(), form.getAvailableSeats());
        flightRepository.save(f);
        return f;
    }

    @Override
    public Flight seatTaken(FlightId flightId) {
        Flight f = flightRepository.findById(flightId).orElseThrow(FlightNotFoundException::new);
        f.removeSeat();
        flightRepository.saveAndFlush(f);
        return f;
    }

    @Override
    public Flight seatRemoved(FlightId flightId) {
        Flight f = flightRepository.findById(flightId).orElseThrow(FlightNotFoundException::new);
        f.addSeat();
        flightRepository.saveAndFlush(f);
        return f;
    }

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }
}
