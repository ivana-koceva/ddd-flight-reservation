package mk.finki.ukim.emt.flightlist.xport.events;

import lombok.AllArgsConstructor;
import mk.finki.ukim.emt.flightlist.domain.model.FlightId;
import mk.finki.ukim.emt.flightlist.service.FlightService;
import mk.finki.ukim.emt.sharedkernel.domain.config.TopicHolder;
import mk.finki.ukim.emt.sharedkernel.domain.events.DomainEvent;
import mk.finki.ukim.emt.sharedkernel.domain.events.seat.SeatRemoved;
import mk.finki.ukim.emt.sharedkernel.domain.events.seat.SeatTaken;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FlightEventListener {

    private final FlightService flightService;

    @KafkaListener(topics= TopicHolder.TOPIC_SEAT_TAKEN, groupId = "flightList")
    public void consumeSeatTakenEvent(String jsonMessage) {
        try {
            SeatTaken event = DomainEvent.fromJson(jsonMessage,SeatTaken.class);
            flightService.seatTaken(FlightId.of(event.getFlightId()));
        } catch (Exception e){

        }

    }

    @KafkaListener(topics= TopicHolder.TOPIC_SEAT_REMOVED, groupId = "flightList")
    public void consumeSeatRemovedEvent(String jsonMessage) {
        try {
            SeatRemoved event = DomainEvent.fromJson(jsonMessage,SeatRemoved.class);
            flightService.seatRemoved(FlightId.of(event.getFlightId()));
        } catch (Exception e){

        }

    }
}
