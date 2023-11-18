package com.hostfully.modules.booking.domain.entity;

import com.hostfully.framework.entitybase.Entity;
import com.hostfully.framework.entitybase.Identity;
import com.hostfully.modules.booking.domain.enums.BlockState;
import com.hostfully.modules.booking.utils.DateRangeValidator;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Block extends Entity {
  private final Identity id;
  private final LocalDate startDate;
  private final LocalDate endDate;
  private final BlockState state;
  private final Long propertyId;
  private final Long ownerId;

  public static Block newInstance(
      LocalDate startDate, LocalDate endDate, Long propertyId, Long ownerId) {
    DateRangeValidator.validateDateRange(startDate, endDate);
    return Block.builder()
        .startDate(startDate)
        .endDate(endDate)
        .state(BlockState.CREATED)
        .propertyId(propertyId)
        .ownerId(ownerId)
        .build();
  }

  public Block newInstanceWith(BlockState state) {
    return Block.builder()
        .id(id)
        .startDate(startDate)
        .endDate(endDate)
        .propertyId(propertyId)
        .state(state)
        .ownerId(ownerId)
        .build();
  }

  public Block update(LocalDate startDate, LocalDate endDate) {
    DateRangeValidator.validateDateRange(startDate, endDate);
    return new Block(id, startDate, endDate, state, propertyId, ownerId);
  }

  public Block delete() {
    if (this.state == BlockState.CANCELLED) {
      throw new IllegalStateException("Block is already canceled");
    }
    return newInstanceWith(BlockState.CANCELLED);
  }
}
