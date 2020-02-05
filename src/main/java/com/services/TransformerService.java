package com.services;

import com.persitence.entity.TransformerNode;
import com.persitence.repository.TransformerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransformerService extends AbstractService<TransformerNode, TransformerRepository>{

    @Autowired
    public TransformerService(TransformerRepository repository) {
        super(repository);
    }
}
