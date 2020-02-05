package com.services;

import com.persitence.entity.FeederNode;
import com.persitence.repository.FeederRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeederService extends AbstractService<FeederNode, FeederRepository> {

    @Autowired
    public FeederService(FeederRepository repository) {
        super(repository);
    }
}
