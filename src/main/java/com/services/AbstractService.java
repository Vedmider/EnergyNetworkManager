package com.services;

import com.persitence.entity.BaseEntity;
import com.persitence.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<E extends BaseEntity, R extends CommonRepository<E>>
        implements CommonService<E> {
    protected final R repository;


    protected AbstractService(R repository) {
        this.repository = repository;
    }

    public Optional<E> createUpdate(E entity){
        return Optional.ofNullable(repository.save(entity));
    }

    public void delete(E entity){
        repository.delete(entity);
    }

    public Optional<E> findById(String id){
        return repository.findById(id);
    }

    public List<E> getAll(){
        return  repository.findAll();
    }

}
