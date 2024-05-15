package mk.finki.ukim.emt.reservationmanagement.service;

import mk.finki.ukim.emt.reservationmanagement.domain.exceptions.PassengerIdNotExistException;
import mk.finki.ukim.emt.reservationmanagement.domain.exceptions.ReservationIdNotExistException;
import mk.finki.ukim.emt.reservationmanagement.domain.model.PassengerId;
import mk.finki.ukim.emt.reservationmanagement.domain.model.Reservation;
import mk.finki.ukim.emt.reservationmanagement.domain.model.ReservationId;
import mk.finki.ukim.emt.reservationmanagement.service.forms.PassengerForm;
import mk.finki.ukim.emt.reservationmanagement.service.forms.ReservationForm;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    ReservationId makeReservation(ReservationForm orderForm);

    List<Reservation> findAll();

    Optional<Reservation> findById(ReservationId id);

    void addPassenger(ReservationId reservationId, PassengerForm passengerForm) throws ReservationIdNotExistException;

    void deletePassenger(ReservationId reservationId, PassengerId passengerId) throws ReservationIdNotExistException, PassengerIdNotExistException;


}
