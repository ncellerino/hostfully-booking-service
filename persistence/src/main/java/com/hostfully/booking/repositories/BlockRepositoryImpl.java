package com.hostfully.booking.repositories;

import com.hostfully.booking.entities.BlockEntity;
import com.hostfully.framework.entitybase.Identity;
import com.hostfully.modules.booking.domain.entity.Block;
import com.hostfully.modules.booking.domain.exceptions.DomainException;
import com.hostfully.modules.booking.domain.exceptions.EntityNotFoundException;
import com.hostfully.modules.booking.features.block.BlockRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class BlockRepositoryImpl implements BlockRepository {

  private JPABlockRepository repository;

  public BlockRepositoryImpl(JPABlockRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<Block> getById(Identity identity) {
    return repository.findById(identity.getNumber()).map(BlockEntity::fromThis);
  }

  @Override
  public Block getByIdOrThrow(Identity identity) throws DomainException {
    BlockEntity block =
        repository
            .findById(identity.getNumber())
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "Block with id %s not found.", identity.getNumber()));
    return block.fromThis();
  }

  @Override
  public Block persist(Block block) {
    return repository.save(BlockEntity.from(block)).fromThis();
  }

  @Override
  public Stream<Block> getAll() {
    return repository.findAll().stream().map(BlockEntity::fromThis);
  }

  @Override
  public void delete(Block block) {
    repository.delete(BlockEntity.from(block));
  }

  @Override
  public boolean isPropertyBlockedBetweenDates(
      Long propertyId, LocalDate startDate, LocalDate endDate) {
    return repository.isPropertyBlockedBetweenDates(propertyId, startDate, endDate);
  }
}
