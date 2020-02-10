package com.persitence.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class NetworkNode extends BaseEntity {
    @Column
    private NodeType nodeType = NodeType.NETWORK;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<SubstationNode> childrenNodes;
    @Override
    public NodeType getNodeType() {
        return nodeType;
    }

    public List<SubstationNode> getChildrenNodes() {
        return childrenNodes;
    }
    @Override
    public void setChildrenNodes(List<? extends BaseEntity> childrenNodes) {
        this.childrenNodes = (List<SubstationNode>) childrenNodes;
    }
}
