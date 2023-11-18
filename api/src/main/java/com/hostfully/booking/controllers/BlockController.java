package com.hostfully.booking.controllers;

import com.hostfully.booking.entities.BlockResponse;
import com.hostfully.booking.entities.CreateBlockCommand;
import com.hostfully.booking.entities.UpdateBlockCommand;
import com.hostfully.booking.mappers.BlockMapper;
import com.hostfully.framework.entitybase.Identity;
import com.hostfully.modules.booking.features.block.usecases.CreateBlockUseCase;
import com.hostfully.modules.booking.features.block.usecases.DeleteBlockUseCase;
import com.hostfully.modules.booking.features.block.usecases.UpdateBlockUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blocks")
public class BlockController {

  private final CreateBlockUseCase createBlockUseCase;
  private final UpdateBlockUseCase updateBlockUseCase;
  private final DeleteBlockUseCase deleteBlockUseCase;

  @PostMapping("")
  BlockResponse createBooking(@RequestBody @Valid CreateBlockCommand createBlockCommand) {
    CreateBlockUseCase.OutputValues outputValues =
        createBlockUseCase.execute(BlockMapper.map(createBlockCommand));
    return BlockMapper.map(outputValues);
  }

  @PatchMapping("/{id}")
  BlockResponse updateBooking(
          @PathVariable Long id, @RequestBody @Valid UpdateBlockCommand updateBlockCommand) {
    UpdateBlockUseCase.OutputValues outputValues =
        updateBlockUseCase.execute(BlockMapper.map(id, updateBlockCommand));
    return BlockMapper.map(outputValues);
  }

  @DeleteMapping("/{id}")
  BlockResponse deleteBooking(@PathVariable Long id) {
    DeleteBlockUseCase.OutputValues outputValues =
        deleteBlockUseCase.execute(new DeleteBlockUseCase.InputValues(new Identity(id)));
    return BlockMapper.map(outputValues);
  }
}
