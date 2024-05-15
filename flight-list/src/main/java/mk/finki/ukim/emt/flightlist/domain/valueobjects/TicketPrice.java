package mk.finki.ukim.emt.flightlist.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.finki.ukim.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class TicketPrice implements ValueObject {

    private final double price;

    public TicketPrice() {
        this.price = 0;
    }
}
