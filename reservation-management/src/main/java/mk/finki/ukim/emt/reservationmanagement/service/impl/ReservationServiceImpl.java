package mk.finki.ukim.emt.reservationmanagement.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.finki.ukim.emt.reservationmanagement.domain.exceptions.PassengerIdNotExistException;
import mk.finki.ukim.emt.reservationmanagement.domain.exceptions.ReservationIdNotExistException;
import mk.finki.ukim.emt.reservationmanagement.domain.model.PassengerId;
import mk.finki.ukim.emt.reservationmanagement.domain.model.Reservation;
import mk.finki.ukim.emt.reservationmanagement.domain.model.ReservationId;
import mk.finki.ukim.emt.reservationmanagement.domain.repository.ReservationRepository;
import mk.finki.ukim.emt.reservationmanagement.service.ReservationService;
import mk.finki.ukim.emt.reservationmanagement.service.forms.PassengerForm;
import mk.finki.ukim.emt.reservationmanagement.service.forms.ReservationForm;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import javax.xml.transform.Source;
import javax.xml.validation.Validator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final Validator validator;

    @Override
    public ReservationId makeReservation(ReservationForm reservationForm) {
//        Objects.requireNonNull(reservationForm,"reservation must not be null.");
//        var constraintViolations = validator.validate((Source) reservationForm);
//        if (constraintViolations.size()>0) {
//            throw new ConstraintViolationException("The order form is not valid", constraintViolations);
//        }
//        var newOrder = reservationRepository.saveAndFlush(toDomainObject(orderForm));
//        newOrder.getOrderItemList().forEach(item->domainEventPublisher.publish(new OrderItemCreated(item.getProductId().getId(),item.getQuantity())));
//        return newOrder.getId();
        return null;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findById(ReservationId id) {
        return reservationRepository.findById(id);
    }

    @Override
    public void addPassenger(ReservationId reservationId, PassengerForm passengerForm) throws ReservationIdNotExistException {
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(ReservationIdNotExistException::new);
        reservation.addPassenger(passengerForm.getPassenger());
        reservationRepository.saveAndFlush(reservation);

    }

    @Override
    public void deletePassenger(ReservationId reservationId, PassengerId passengerId) throws ReservationIdNotExistException, PassengerIdNotExistException {
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(ReservationIdNotExistException::new);
        reservation.removeItem(passengerId);
        reservationRepository.saveAndFlush(reservation);

    }

    private Reservation toDomainObject(ReservationForm reservationForm) {
        var reservation = new Reservation();
        reservationForm.getPassengerForms().forEach(item->reservation.addPassenger(item.getPassenger()));
        return reservation;
    }

}
