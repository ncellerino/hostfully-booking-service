package com.hostfully.modules.booking.features.block.usecases;

import com.hostfully.framework.entitybase.Identity;
import com.hostfully.framework.usecase.BaseUseCase;
import com.hostfully.modules.booking.domain.entity.Block;
import com.hostfully.modules.booking.features.block.BlockDTO;
import com.hostfully.modules.booking.features.block.BlockMapper;
import com.hostfully.modules.booking.features.block.BlockRepository;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeleteBlockUseCase
    extends BaseUseCase<DeleteBlockUseCase.InputValues, DeleteBlockUseCase.OutputValues> {
  private final BlockRepository repository;

  @Override
  public OutputValues execute(InputValues input) {
    Block block = repository.getByIdOrThrow(input.getId());
    Block deletedBlock = block.delete();
    Block result = repository.persist(deletedBlock);

    return new OutputValues(BlockMapper.toDTO(result));
  }

  @Value
  public static class InputValues implements BaseUseCase.InputValues {
    private final Identity id;
  }

  @Value
  public static class OutputValues implements BaseUseCase.OutputValues {
    private final BlockDTO blockDTO;
  }
}
