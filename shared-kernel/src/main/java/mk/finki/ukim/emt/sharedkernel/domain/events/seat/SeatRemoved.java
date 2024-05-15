package mk.finki.ukim.emt.sharedkernel.domain.events.seat;

import lombok.Getter;
import mk.finki.ukim.emt.sharedkernel.domain.config.TopicHolder;
import mk.finki.ukim.emt.sharedkernel.domain.events.DomainEvent;

@Getter
public class SeatRemoved extends DomainEvent {

    private String flightId;

    public SeatRemoved(String topic) {
        super(TopicHolder.TOPIC_SEAT_REMOVED);
    }

    public SeatRemoved(String topic, String flightId) {
        super(TopicHolder.TOPIC_SEAT_REMOVED);
        this.flightId = flightId;
    }
}
