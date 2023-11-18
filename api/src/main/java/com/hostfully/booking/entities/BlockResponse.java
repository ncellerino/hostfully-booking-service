package com.hostfully.booking.entities;

import com.hostfully.modules.booking.domain.enums.BlockState;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class BlockResponse {

  private final Long id;
  private final LocalDate startDate;
  private final LocalDate endDate;
  private final BlockState state;
  private final Long propertyId;
  private final Long ownerId;
}
