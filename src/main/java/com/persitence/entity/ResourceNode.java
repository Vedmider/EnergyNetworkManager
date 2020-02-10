package com.persitence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
public class ResourceNode extends BaseEntity {
    @Column
    private NodeType nodeType = NodeType.RESOURCE;

    @Override
    public NodeType getNodeType() {
        return nodeType;
    }

    @Override
    public List<? extends BaseEntity> getChildrenNodes() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public void setChildrenNodes(List<? extends BaseEntity> childrenNodes) {
    }

}
