package com.services;

import com.persitence.entity.BaseEntity;

import java.util.Optional;

public interface CommonService<E extends BaseEntity> {
    Optional<E> createUpdate(E entity);

    void delete(E entity);

    Optional<E> findById(String id);
}
