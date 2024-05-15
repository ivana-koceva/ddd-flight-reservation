package mk.finki.ukim.emt.flightlist.domain.model;

import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;

public class FlightId extends DomainObjectId {

    private FlightId() {
        super(FlightId.randomId(FlightId.class).getId());
    }

    public FlightId(@NonNull String uuid) {
        super(uuid);
    }

    public static FlightId of(String uuid) {
        FlightId p = new FlightId(uuid);
        return p;
    }

}
