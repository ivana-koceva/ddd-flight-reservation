package mk.finki.ukim.emt.paymentlist.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.finki.ukim.emt.paymentlist.domain.exceptions.PaymentNotFoundException;
import mk.finki.ukim.emt.paymentlist.domain.model.Payment;
import mk.finki.ukim.emt.paymentlist.domain.model.PaymentId;
import mk.finki.ukim.emt.paymentlist.domain.repository.PaymentRepository;
import mk.finki.ukim.emt.paymentlist.service.PaymentService;
import mk.finki.ukim.emt.paymentlist.service.forms.PaymentForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Payment findById(PaymentId id) {
        return paymentRepository.findById(id).orElseThrow(PaymentNotFoundException::new);
    }

    @Override
    public Payment createPayment(PaymentForm form) {
        Payment f = Payment.build(form.getAmount(), form.getPaymentDate());
        paymentRepository.save(f);
        return f;
    }


    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }
}
