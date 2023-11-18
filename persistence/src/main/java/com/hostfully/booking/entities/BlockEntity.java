package com.hostfully.booking.entities;

import com.hostfully.framework.entitybase.Identity;
import com.hostfully.modules.booking.domain.entity.Block;
import com.hostfully.modules.booking.domain.enums.BlockState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor()
@Table(name = "blocks")
@NoArgsConstructor
@Getter
public class BlockEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column private LocalDate startDate;

  @Column private LocalDate endDate;

  @Enumerated(EnumType.STRING)
  private BlockState state;

  @Column private Long propertyId;
  @Column private Long ownerId;

  public static BlockEntity from(Block block) {
    return new BlockEntity(
        IdentityMapper.mapId(block.getId()),
        block.getStartDate(),
        block.getEndDate(),
        block.getState(),
        block.getPropertyId(),
        block.getOwnerId());
  }

  public Block fromThis() {
    return Block.builder()
        .id(new Identity(id))
        .startDate(startDate)
        .endDate(endDate)
        .state(state)
        .propertyId(propertyId)
        .ownerId(ownerId)
        .build();
  }
}
