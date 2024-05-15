package mk.finki.ukim.emt.paymentlist.domain.repository;

import mk.finki.ukim.emt.paymentlist.domain.model.Payment;
import mk.finki.ukim.emt.paymentlist.domain.model.PaymentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, PaymentId> {
}
