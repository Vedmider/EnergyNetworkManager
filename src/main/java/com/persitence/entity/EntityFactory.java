package com.persitence.entity;

import com.web.data.NodeDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EntityFactory {
    private static final Optional<? extends BaseEntity> feederNode = Optional.of(new FeederNode());
    private static final Optional<? extends BaseEntity> networkNode = Optional.of(new NetworkNode());
    private static final Optional<? extends BaseEntity> resourceNode = Optional.of(new ResourceNode());
    private static final Optional<? extends BaseEntity> substationNode = Optional.of(new SubstationNode());
    private static final Optional<? extends BaseEntity> transformerNode = Optional.of(new TransformerNode());

    public static Optional<? extends BaseEntity> getEntity(NodeType nodeType){
        switch (nodeType){
            case FEEDER: return feederNode;
            case NETWORK: return networkNode;
            case RESOURCE: return resourceNode;
            case SUBSTATION: return substationNode;
            case TRANSFORMER: return transformerNode;
        }
        return Optional.empty();
    }

    public static Optional<? extends BaseEntity> getEntity(NodeType nodeType, NodeDTO nodeDTO){
        Optional<? extends BaseEntity> node = getEntity(nodeType);
        if (node.isPresent()){
            node.get().setEntityId(nodeDTO.getId());
            node.get().setChildrenNodes(nodeDTO.getNodes());
            node.get().setDescription(nodeDTO.getDescription());
            node.get().setName(nodeDTO.getName());
            node.get().setParams(nodeDTO.getParams());
        }
        return node;
    }

}
