package mk.finki.ukim.emt.paymentlist.service.forms;

import lombok.Data;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;

import java.util.Date;
@Data
public class PaymentForm {
    private Money amount;
    private Date paymentDate;
}
