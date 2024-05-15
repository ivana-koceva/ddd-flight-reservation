package mk.finki.ukim.emt.reservationmanagement.service.forms;

import lombok.Data;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
public class ReservationForm {

    @Valid
    @NotEmpty
    private List<PassengerForm> passengerForms = new ArrayList<>();

}
