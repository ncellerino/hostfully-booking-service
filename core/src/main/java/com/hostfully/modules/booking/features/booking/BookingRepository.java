package com.hostfully.modules.booking.features.booking;

import com.hostfully.framework.entitybase.Identity;
import com.hostfully.framework.repository.IGenericRepository;
import com.hostfully.modules.booking.domain.entity.Booking;

import java.time.LocalDate;

public interface BookingRepository extends IGenericRepository<Booking, Identity> {
  boolean isPropertyBookedBetweenDates(Long propertyId, LocalDate startDate, LocalDate endDate);
}
