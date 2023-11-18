package com.hostfully.booking.repositories;

import com.hostfully.booking.entities.BookingEntity;
import com.hostfully.framework.entitybase.Identity;
import com.hostfully.modules.booking.domain.entity.Booking;
import com.hostfully.modules.booking.domain.exceptions.DomainException;
import com.hostfully.modules.booking.domain.exceptions.EntityNotFoundException;
import com.hostfully.modules.booking.features.booking.BookingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class BookingRepositoryImpl implements BookingRepository {

  private JPABookingRepository repository;

  public BookingRepositoryImpl(JPABookingRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<Booking> getById(Identity identity) {
    return repository.findById(identity.getNumber()).map(BookingEntity::fromThis);
  }

  @Override
  public Booking getByIdOrThrow(Identity identity) throws DomainException {
    BookingEntity booking =
        repository
            .findById(identity.getNumber())
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "Booking with id %s not found.", identity.getNumber()));
    return booking.fromThis();
  }

  @Override
  public Booking persist(Booking booking) {
    return repository.save(BookingEntity.from(booking)).fromThis();
  }

  @Override
  public Stream<Booking> getAll() {
    return repository.findAll().stream().map(BookingEntity::fromThis);
  }

  @Override
  public void delete(Booking booking) {
    repository.delete(BookingEntity.from(booking));
  }

  @Override
  public boolean isPropertyBookedBetweenDates(
      Long propertyId, LocalDate startDAte, LocalDate endDate) {
    return repository.isPropertyBookedBetweenDates(propertyId, startDAte, endDate);
  }
}
