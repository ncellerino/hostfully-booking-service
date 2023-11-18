package com.hostfully.modules.booking.features.booking;

import com.hostfully.framework.entitybase.Identity;
import com.hostfully.modules.booking.domain.entity.Guest;

public class GuestMapper {
  public static GuestDTO toDTO(Guest model) {
    return GuestDTO.builder()
        .id(model.getId().getNumber())
        .firstName(model.getFirstName())
        .lastName(model.getLastName())
        .phone(model.getPhone())
        .email(model.getEmail())
        .build();
  }

  public static Guest fromDTO(GuestDTO dto) {
    return Guest.builder()
        .id(dto.getId() != null ? new Identity(dto.getId()) : null)
        .firstName(dto.getFirstName())
        .lastName(dto.getLastName())
        .phone(dto.getPhone())
        .email(dto.getEmail())
        .build();
  }
}
