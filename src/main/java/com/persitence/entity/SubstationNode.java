package com.persitence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SubstationNode extends BaseEntity {
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<TransformerNode> childrenNodes;
    @Column
    private NodeType nodeType = NodeType.SUBSTATION;

    public Set<TransformerNode> getChildrenNodes() {
        return childrenNodes;
    }

    public void setChildrenNodes(Set<TransformerNode> childrenNodes) {
        this.childrenNodes = childrenNodes;
    }
    @Override
    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }
}
