package com.persitence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class NetworkNode extends BaseEntity {
    @Column
    private NodeType nodeType = NodeType.NETWORK;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<SubstationNode> childrenNodes;
    @Override
    public NodeType getNodeType() {
        return nodeType;
    }

    public Set<SubstationNode> getChildrenNodes() {
        return childrenNodes;
    }

    public void setChildrenNodes(Set<SubstationNode> childrenNodes) {
        this.childrenNodes = childrenNodes;
    }
}
