package com.web.controller;


import com.persitence.entity.*;
import com.services.*;
import com.web.data.NodeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static com.web.constants.PathConstants.*;

@RestController
public class APIController {
    private static final Logger LOG = LoggerFactory.getLogger(APIController.class);
    private ServiceFactory serviceFactory;

    @Autowired
    public APIController(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @PostMapping(SLASH_API + "/{type}")
    public ResponseEntity<? extends BaseEntity> createNode(@Valid @RequestBody NodeDTO nodeDTO,
                                                           @PathVariable String type) {
        LOG.info("Creating new node of type : {}", type);
        AbstractService service = serviceFactory.getService(NodeType.valueOf(type.toUpperCase()));
        Optional<? extends BaseEntity> node = EntityFactory.getEntity(NodeType.valueOf(type.toUpperCase()), nodeDTO);

        if (node.isPresent()) {
            node = service.createUpdate(node.get());
            if (node.isPresent()) {
                return ResponseEntity.ok(node.get());
            } else {
                LOG.info("Could not create node");
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(SLASH_API + "/{type}")
    public ResponseEntity<Void> updateNode(@Valid @RequestBody NodeDTO nodeDTO,
                                           @PathVariable NodeType type) {
        LOG.info("Trying to update node with ID: {}", nodeDTO.getId());
        AbstractService service = serviceFactory.getService(type);
        Optional<? extends BaseEntity> node = EntityFactory.getEntity(type, nodeDTO);
        if (node.isPresent()) {
            node = service.createUpdate(node.get());
            if (node.isPresent()) {
                return ResponseEntity.noContent().build();
            } else {
                LOG.info("Could not update node");
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(SLASH_API + "/{type}/{id}")
    public ResponseEntity<Void> deleteNode(@PathVariable String id,
                                           @PathVariable NodeType type) {
        LOG.info("Deleting node of type: {} and ID: {}", type, id);
        AbstractService service = serviceFactory.getService(type);
        Optional<NetworkNode> node = service.findById(id);

        if (node.isPresent()) {
            service.delete(node.get());
            return ResponseEntity.noContent().build();
        }
        LOG.info("Could not find node with ID:{}", id);
        return ResponseEntity.notFound().build();
    }

    @GetMapping(SLASH_API + "/{type}/{id}")
    public ResponseEntity<NetworkNode> getNodeById(@PathVariable String id,
                                                   @PathVariable NodeType type) {
        LOG.info("Getting node type: {} by ID: {}", type, id);
        AbstractService service = serviceFactory.getService(type);
        Optional<NetworkNode> node = service.findById(id);

        if (node.isPresent()) {
            return ResponseEntity.ok(node.get());
        }
        LOG.info("Could not find node");
        return ResponseEntity.notFound().build();
    }

}
