package com.hostfully.modules.booking.features.block.usecases;

import com.hostfully.framework.entitybase.Identity;
import com.hostfully.framework.usecase.BaseUseCase;
import com.hostfully.modules.booking.domain.entity.Block;
import com.hostfully.modules.booking.domain.exceptions.EntityNotFoundException;
import com.hostfully.modules.booking.features.block.BlockDTO;
import com.hostfully.modules.booking.features.block.BlockMapper;
import com.hostfully.modules.booking.features.block.BlockRepository;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class UpdateBlockUseCase
    extends BaseUseCase<UpdateBlockUseCase.InputValues, UpdateBlockUseCase.OutputValues> {
  private final BlockRepository repository;

  @Override
  public OutputValues execute(InputValues input) {
    Block savedBlock =
        repository
            .getById(input.id)
            .orElseThrow(
                () -> new EntityNotFoundException("Block with id %s not found.", input.id));
    Block updatedBlock = savedBlock.update(input.startDate, input.endDate);
    Block block = repository.persist(updatedBlock);
    return new OutputValues(BlockMapper.toDTO(block));
  }

  @Value
  public static class InputValues implements BaseUseCase.InputValues {
    private final Identity id;
    private final LocalDate startDate;
    private final LocalDate endDate;
  }

  @Value
  public static class OutputValues implements BaseUseCase.OutputValues {
    private final BlockDTO blockDTO;
  }
}
