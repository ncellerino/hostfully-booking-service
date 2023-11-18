package com.hostfully.modules.booking.features.block.usecases;

import com.hostfully.framework.usecase.BaseUseCase;
import com.hostfully.modules.booking.domain.entity.Block;
import com.hostfully.modules.booking.features.block.BlockDTO;
import com.hostfully.modules.booking.features.block.BlockMapper;
import com.hostfully.modules.booking.features.block.BlockRepository;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class CreateBlockUseCase
    extends BaseUseCase<CreateBlockUseCase.InputValues, CreateBlockUseCase.OutputValues> {
  private final BlockRepository repository;

  @Override
  public OutputValues execute(InputValues input) {
    Block newBlock =
        Block.newInstance(input.startDate, input.endDate, input.propertyId, input.ownerId);
    Block block = repository.persist(newBlock);
    return new OutputValues(BlockMapper.toDTO(block));
  }

  @Value
  public static class InputValues implements BaseUseCase.InputValues {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Long propertyId;
    private final Long ownerId;
  }

  @Value
  public static class OutputValues implements BaseUseCase.OutputValues {
    private final BlockDTO blockDTO;
  }
}
