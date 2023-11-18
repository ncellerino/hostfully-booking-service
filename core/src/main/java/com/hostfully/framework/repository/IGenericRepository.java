package com.hostfully.framework.repository;

import com.hostfully.framework.exceptions.DomainException;


import java.util.Optional;
import java.util.stream.Stream;

public interface IGenericRepository<T, ID> {

  Optional<T> getById(ID id);

  T getByIdOrThrow(ID id) throws DomainException;

  T persist(T entity);

  Stream<T> getAll();

  void delete(T entity);
}
