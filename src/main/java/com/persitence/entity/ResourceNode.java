package com.persitence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ResourceNode extends BaseEntity {
    @Column
    private NodeType nodeType = NodeType.RESOURCE;
    @Override
    public NodeType getNodeType() {
        return nodeType;
    }
}
