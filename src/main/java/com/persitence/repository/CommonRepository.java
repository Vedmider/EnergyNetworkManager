package com.persitence.repository;

import com.persitence.entity.BaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository <E extends BaseEntity> extends CrudRepository<E, String> {
}
