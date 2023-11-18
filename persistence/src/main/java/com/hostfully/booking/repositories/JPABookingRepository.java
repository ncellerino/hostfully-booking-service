package com.hostfully.booking.repositories;

import com.hostfully.booking.entities.BookingEntity;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface JPABookingRepository extends GenericRepository<BookingEntity> {
  @Query(
      "select count(b) > 0 from BookingEntity b where b.propertyId = ?1 and b.state <> 'CANCELLED' and b.startDate between ?2 and ?3 or b.endDate between ?2 and ?3")
  boolean isPropertyBookedBetweenDates(Long propertyId, LocalDate startDate, LocalDate endDate);
}
