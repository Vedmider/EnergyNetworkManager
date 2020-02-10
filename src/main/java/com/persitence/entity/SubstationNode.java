package com.persitence.entity;

import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class SubstationNode extends BaseEntity {
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<TransformerNode> childrenNodes;
    @Column
    private NodeType nodeType = NodeType.SUBSTATION;

    public List<? extends BaseEntity> getChildrenNodes() {
        return childrenNodes;
    }

    public void setChildrenNodes(List<? extends BaseEntity> childrenNodes) {
        this.childrenNodes = (List<TransformerNode>) childrenNodes;
    }
    @Override
    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }
}
