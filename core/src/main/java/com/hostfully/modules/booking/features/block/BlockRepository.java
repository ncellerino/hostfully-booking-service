package com.hostfully.modules.booking.features.block;

import com.hostfully.framework.entitybase.Identity;
import com.hostfully.framework.repository.IGenericRepository;
import com.hostfully.modules.booking.domain.entity.Block;

import java.time.LocalDate;

public interface BlockRepository extends IGenericRepository<Block, Identity> {
  boolean isPropertyBlockedBetweenDates(Long propertyId, LocalDate startDate, LocalDate endDate);
}
