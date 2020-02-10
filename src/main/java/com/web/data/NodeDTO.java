package com.web.data;

import com.persitence.entity.BaseEntity;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Component
public class NodeDTO {
    @NotNull
    private String id;
    @NotNull
    private String name;
    private String description;
    private Map<String, String> params;
    private List<? extends BaseEntity> nodes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public List<? extends BaseEntity> getNodes() {
        return nodes;
    }

    public void setNodes(List<? extends BaseEntity> nodes) {
        this.nodes = nodes;
    }
}
