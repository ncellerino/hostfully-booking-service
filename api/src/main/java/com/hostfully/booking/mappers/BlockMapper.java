package com.hostfully.booking.mappers;

import com.hostfully.booking.entities.*;
import com.hostfully.framework.entitybase.Identity;
import com.hostfully.modules.booking.features.block.BlockDTO;
import com.hostfully.modules.booking.features.block.usecases.CreateBlockUseCase;
import com.hostfully.modules.booking.features.block.usecases.DeleteBlockUseCase;
import com.hostfully.modules.booking.features.block.usecases.UpdateBlockUseCase;
import com.hostfully.modules.booking.features.booking.GuestDTO;

public class BlockMapper {
  public static CreateBlockUseCase.InputValues map(CreateBlockCommand createBlockCommand) {
    return new CreateBlockUseCase.InputValues(
        createBlockCommand.getStartDate(),
        createBlockCommand.getEndDate(),
        createBlockCommand.getPropertyId(),
        createBlockCommand.getOwnerId());
  }

  public static UpdateBlockUseCase.InputValues map(Long id, UpdateBlockCommand updateBlockCommand) {
    return new UpdateBlockUseCase.InputValues(
        new Identity(id), updateBlockCommand.getStartDate(), updateBlockCommand.getEndDate());
  }

  public static BlockResponse map(CreateBlockUseCase.OutputValues outputValues) {
    BlockDTO blockDTO = outputValues.getBlockDTO();
    return fromBlockDTO(blockDTO);
  }

  public static BlockResponse map(UpdateBlockUseCase.OutputValues outputValues) {
    BlockDTO blockDTO = outputValues.getBlockDTO();
    return fromBlockDTO(blockDTO);
  }

  public static BlockResponse map(DeleteBlockUseCase.OutputValues outputValues) {
    BlockDTO blockDTO = outputValues.getBlockDTO();
    return fromBlockDTO(blockDTO);
  }

  private static BlockResponse fromBlockDTO(BlockDTO blockDTO) {
    return BlockResponse.builder()
        .id(blockDTO.getId())
        .startDate(blockDTO.getStartDate())
        .endDate(blockDTO.getEndDate())
        .state(blockDTO.getState())
        .propertyId(blockDTO.getPropertyId())
        .ownerId(blockDTO.getOwnerId())
        .build();
  }

  private static BookingResponse.Guest map(GuestDTO guestDTO) {
    return BookingResponse.Guest.builder()
        .id(guestDTO.getId())
        .firstName(guestDTO.getFirstName())
        .lastName(guestDTO.getLastName())
        .phone(guestDTO.getPhone())
        .email(guestDTO.getEmail())
        .build();
  }

  private static GuestDTO map(CreateBookingCommand.Guest guest) {
    return GuestDTO.builder()
        .firstName(guest.getFirstName())
        .lastName(guest.getLastName())
        .phone(guest.getPhone())
        .email(guest.getEmail())
        .build();
  }

  private static GuestDTO map(UpdateBookingCommand.UpdateGuest guest) {
    return GuestDTO.builder()
        .firstName(guest.getFirstName())
        .lastName(guest.getLastName())
        .phone(guest.getPhone())
        .build();
  }
}
