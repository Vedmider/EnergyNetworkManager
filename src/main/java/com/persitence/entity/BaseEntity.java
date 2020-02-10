package com.persitence.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.Set;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @NotNull
    @Column(unique = true, nullable = false)
    protected String id;
    @NotNull
    @Column
    protected String name;
    @Column
    protected String description;
    @ElementCollection
    @CollectionTable(name = "params", joinColumns = @JoinColumn(name = "entity_id"))
    @MapKeyColumn(name = "key")
    protected Map<String, String> params;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

    public String getEntityId() {
        return id;
    }

    public void setEntityId(String id) {
        this.id = id;
    }

    public abstract NodeType getNodeType();

    public abstract List<? extends BaseEntity> getChildrenNodes();

    public abstract void setChildrenNodes(List<? extends  BaseEntity> childrenNodes);

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        BaseEntity baseEntity = (BaseEntity) obj;
        return id == baseEntity.getEntityId();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id.hashCode();
        return result;
    }


}
