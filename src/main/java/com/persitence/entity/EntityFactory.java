package com.persitence.entity;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EntityFactory {
    private static final Optional<BaseEntity> feederNode = Optional.of(new FeederNode());
    private static final Optional<BaseEntity> networkNode = Optional.of(new NetworkNode());
    private static final Optional<BaseEntity> resourceNode = Optional.of(new ResourceNode());
    private static final Optional<BaseEntity> substationNode = Optional.of(new SubstationNode());
    private static final Optional<BaseEntity> transformerNode = Optional.of(new TransformerNode());

    public static Optional<BaseEntity> getEntity(NodeType nodeType){
        switch (nodeType){
            case FEEDER: return feederNode;
            case NETWORK: return networkNode;
            case RESOURCE: return resourceNode;
            case SUBSTATION: return substationNode;
            case TRANSFORMER: return transformerNode;
        }
        return Optional.empty();
    }

}
