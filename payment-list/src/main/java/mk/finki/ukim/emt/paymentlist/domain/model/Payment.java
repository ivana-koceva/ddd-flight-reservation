package mk.finki.ukim.emt.paymentlist.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;

import java.util.Date;

@Entity
@Table(name="flight")
@Getter
public class Payment extends AbstractEntity<PaymentId> {

    private Money amount;
    private Date paymentDate;

    public Payment() {
        super(PaymentId.randomId(PaymentId.class));
    }

    public static Payment build(Money amount, Date paymentDate) {
        Payment f = new Payment();
        f.amount = amount;
        f.paymentDate = paymentDate;
        return f;
    }

}
