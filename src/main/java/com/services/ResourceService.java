package com.services;

import com.persitence.entity.ResourceNode;
import com.persitence.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService extends AbstractService<ResourceNode, ResourceRepository> {

    @Autowired
    public ResourceService(ResourceRepository repository) {
        super(repository);
    }
}

