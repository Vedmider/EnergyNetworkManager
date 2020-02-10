package com.services;

import com.persitence.entity.BaseEntity;
import com.persitence.entity.NodeType;
import com.persitence.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory {
    private FeederService feederService;
    private NetworkService networkService;
    private ResourceService resourceService;
    private SubstationService substationService;
    private TransformerService transformerService;


    @Autowired
    public ServiceFactory(FeederService feederService,
                          NetworkService networkService,
                          ResourceService resourceService,
                          SubstationService substationService,
                          TransformerService transformerService) {

        this.feederService = feederService;
        this.networkService = networkService;
        this.resourceService = resourceService;
        this.substationService = substationService;
        this.transformerService = transformerService;
    }

    public AbstractService<? extends BaseEntity, ? extends CommonRepository> getService(NodeType nodeType) {

        switch (nodeType) {
            case NETWORK:
                return networkService;
            case SUBSTATION:
                return substationService;
            case TRANSFORMER:
                return transformerService;
            case FEEDER:
                return feederService;
            case RESOURCE:
                return resourceService;
            default: return null;
        }
    }
}
