package com.hostfully.modules.booking.features.block;

import com.hostfully.framework.entitybase.Identity;
import com.hostfully.modules.booking.domain.entity.Block;
import com.hostfully.modules.booking.domain.entity.Booking;
import com.hostfully.modules.booking.features.booking.BookingDTO;
import com.hostfully.modules.booking.features.booking.GuestMapper;

public class BlockMapper {
  public static BlockDTO toDTO(Block model) {
    return BlockDTO.builder()
        .id(model.getId().getNumber())
        .startDate(model.getStartDate())
        .endDate(model.getEndDate())
        .state(model.getState())
        .propertyId(model.getPropertyId())
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
