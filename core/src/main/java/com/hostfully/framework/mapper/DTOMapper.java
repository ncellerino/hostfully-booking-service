package com.hostfully.framework.mapper;

public interface DTOMapper<M, D> {

    D toDTO(M model);
    M fromDTO(D dto);
}
