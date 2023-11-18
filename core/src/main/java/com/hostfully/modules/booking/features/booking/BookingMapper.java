package com.hostfully.modules.booking.features.booking;

import com.hostfully.framework.entitybase.Identity;
import com.hostfully.modules.booking.domain.entity.Booking;

public class BookingMapper {
  public static BookingDTO toDTO(Booking model) {
    return BookingDTO.builder()
        .id(model.getId().getNumber())
        .startDate(model.getStartDate())
        .endDate(model.getEndDate())
        .state(model.getState())
        .propertyId(model.getPropertyId())
        .guest(GuestMapper.toDTO(model.getGuest()))
        .build();
  }

  public static Booking fromDTO(BookingDTO dto) {
    return Booking.builder()
        .id(new Identity(dto.getId()))
        .startDate(dto.getStartDate())
        .endDate(dto.getEndDate())
        .state(dto.getState())
        .propertyId(dto.getPropertyId())
        .guest(GuestMapper.fromDTO(dto.getGuest()))
        .build();
  }
}
