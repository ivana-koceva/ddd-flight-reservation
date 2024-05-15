package mk.finki.ukim.emt.sharedkernel.domain.events.seat;

import lombok.Getter;
import mk.finki.ukim.emt.sharedkernel.domain.config.TopicHolder;
import mk.finki.ukim.emt.sharedkernel.domain.events.DomainEvent;

@Getter
public class SeatTaken extends DomainEvent {

    private String flightId;

    public SeatTaken(String topic) {
        super(TopicHolder.TOPIC_SEAT_REMOVED);
    }

    public SeatTaken(String topic, String flightId) {
        super(TopicHolder.TOPIC_SEAT_TAKEN);
        this.flightId = flightId;
    }

}
