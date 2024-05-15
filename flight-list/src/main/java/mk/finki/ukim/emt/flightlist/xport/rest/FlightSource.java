package mk.finki.ukim.emt.flightlist.xport.rest;

import lombok.AllArgsConstructor;
import mk.finki.ukim.emt.flightlist.domain.model.Flight;
import mk.finki.ukim.emt.flightlist.service.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
@AllArgsConstructor
public class FlightSource {

    private final FlightService flightService;

    @GetMapping
    public List<Flight> getAll() {
        return flightService.getAll();
    }

}
