package mk.finki.ukim.emt.flightlist.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.finki.ukim.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class AvailableSeats implements ValueObject {

    private final int availableSeats;

    public AvailableSeats() {
        this.availableSeats = 0;
    }
}
