package mk.finki.ukim.emt.paymentlist.service;

import mk.finki.ukim.emt.paymentlist.domain.model.Payment;
import mk.finki.ukim.emt.paymentlist.domain.model.PaymentId;
import mk.finki.ukim.emt.paymentlist.service.forms.PaymentForm;

import java.util.List;

public interface PaymentService {

    Payment findById(PaymentId id);
    Payment createPayment(PaymentForm form);

    List<Payment> getAll();

}
