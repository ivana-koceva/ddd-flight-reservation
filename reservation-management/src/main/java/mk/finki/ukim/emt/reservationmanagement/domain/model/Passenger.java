package mk.finki.ukim.emt.reservationmanagement.domain.model;

import lombok.NonNull;
import mk.finki.ukim.emt.reservationmanagement.domain.valueobjects.EmailAddress;
import mk.finki.ukim.emt.reservationmanagement.domain.valueobjects.PhoneNumber;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;

public class Passenger extends AbstractEntity<PassengerId> {

    private String name;
    private EmailAddress emailAddress;
    private PhoneNumber phoneNumber;

    public Passenger(@NonNull AbstractEntity<PassengerId> source, String name, EmailAddress emailAddress, PhoneNumber phoneNumber) {
        super(source);
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }
}
