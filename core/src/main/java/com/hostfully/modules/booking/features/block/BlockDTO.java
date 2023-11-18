package com.hostfully.modules.booking.features.block;

import com.hostfully.modules.booking.domain.enums.BlockState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class BlockDTO {

  private Long id;
  private LocalDate startDate;
  private LocalDate endDate;
  private BlockState state;
  private Long propertyId;
  private Long ownerId;
}
