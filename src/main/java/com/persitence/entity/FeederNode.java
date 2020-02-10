package com.persitence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class FeederNode extends BaseEntity {
    @Column
    private NodeType nodeType = NodeType.FEEDER;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ResourceNode> childrenNodes;
    @Override
    public NodeType getNodeType() {
        return nodeType;
    }

    public List<ResourceNode> getChildrenNodes() {
        return childrenNodes;
    }
    @Override
    public void setChildrenNodes(List<? extends BaseEntity> childrenNodes) {
        this.childrenNodes = (List<ResourceNode>) childrenNodes;
    }

}
