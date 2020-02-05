package com.services;

import com.persitence.entity.SubstationNode;
import com.persitence.repository.SubstationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubstationService extends AbstractService<SubstationNode, SubstationRepository> {

    @Autowired
    public SubstationService(SubstationRepository repository) {
        super(repository);
    }
}
