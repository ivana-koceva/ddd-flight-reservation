package mk.finki.ukim.emt.reservationmanagement.service.forms;

import lombok.Data;
import lombok.Getter;
import mk.finki.ukim.emt.reservationmanagement.domain.model.Passenger;


import javax.validation.constraints.NotNull;

@Data
public class PassengerForm {

    @NotNull
    private Passenger passenger;

    public Passenger getPassenger() {
        return passenger;
    }
}
