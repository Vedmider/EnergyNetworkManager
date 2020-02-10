package com.persitence.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class TransformerNode extends BaseEntity {
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<FeederNode> childrenNodes;
    @Column
    private NodeType nodeType = NodeType.TRANSFORMER;
    @Override
    public List<FeederNode> getChildrenNodes() {
        return childrenNodes;
    }
    @Override
    public void setChildrenNodes(List<? extends BaseEntity> childrenNodes) {
        this.childrenNodes = (List<FeederNode>) childrenNodes;
    }
    @Override
    public NodeType getNodeType() {
        return nodeType;
    }
}
