package mk.finki.ukim.emt.paymentlist.domain.model;

import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;

public class PaymentId extends DomainObjectId {

    private PaymentId() {
        super(PaymentId.randomId(PaymentId.class).getId());
    }

    public PaymentId(@NonNull String uuid) {
        super(uuid);
    }

    public static PaymentId of(String uuid) {
        PaymentId p = new PaymentId(uuid);
        return p;
    }

}
