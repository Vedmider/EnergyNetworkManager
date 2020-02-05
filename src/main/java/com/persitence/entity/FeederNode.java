package com.persitence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FeederNode extends BaseEntity {
    @Column
    private NodeType nodeType = NodeType.FEEDER;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ResourceNode> childrenNodes;
    @Override
    public NodeType getNodeType() {
        return nodeType;
    }

    public Set<ResourceNode> getChildrenNodes() {
        return childrenNodes;
    }

    public void setChildrenNodes(Set<ResourceNode> childrenNodes) {
        this.childrenNodes = childrenNodes;
    }
}
