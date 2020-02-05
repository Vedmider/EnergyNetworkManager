package com.persitence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TransformerNode extends BaseEntity {
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<FeederNode> childrenNodes;
    @Column
    private NodeType nodeType = NodeType.TRANSFORMER;

    public Set<FeederNode> getChildrenNodes() {
        return childrenNodes;
    }

    public void setChildrenNodes(Set<FeederNode> childrenNodes) {
        this.childrenNodes = childrenNodes;
    }
    @Override
    public NodeType getNodeType() {
        return nodeType;
    }
}
