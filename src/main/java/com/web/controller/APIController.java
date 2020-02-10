package com.web.controller;


import com.persitence.entity.*;
import com.services.*;
import com.web.data.NodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static com.web.constants.PathConstants.*;

@RestController
public class APIController {
    private ServiceFactory serviceFactory;

    @Autowired
    public APIController(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @PostMapping(SLASH_API + "/{type}")
    public ResponseEntity<? extends BaseEntity> createNode(@Valid @RequestBody NodeDTO nodeDTO,
                                                     @PathVariable NodeType type) {
        AbstractService service = serviceFactory.getService(type);
        Optional<? extends BaseEntity> node = EntityFactory.getEntity(type, nodeDTO);

        if (node.isPresent()) {
            node = service.createUpdate(node.get());
            if (node.isPresent()){
                return ResponseEntity.ok(node.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(SLASH_API + "/{type}")
    public ResponseEntity<Void> updateNode(@Valid @RequestBody NodeDTO nodeDTO,
                                           @PathVariable NodeType type) {
        AbstractService service = serviceFactory.getService(type);
        Optional<? extends BaseEntity> node = EntityFactory.getEntity(type, nodeDTO);
        if (node.isPresent()) {
            node = service.createUpdate(node.get());
            if (node.isPresent()){
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(SLASH_API + "/{type}/{id}")
    public ResponseEntity<Void> deleteNode(@PathVariable String id,
                                           @PathVariable NodeType type) {
        AbstractService service = serviceFactory.getService(type);
        Optional<NetworkNode> node = service.findById(id);

        if (node.isPresent()) {
            service.delete(node.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(SLASH_API + "/{type}/{id}")
    public ResponseEntity<NetworkNode> getNodeById(@PathVariable String id,
                                                      @PathVariable NodeType type){
        AbstractService service = serviceFactory.getService(type);
        Optional<NetworkNode> node = service.findById(id);

        if (node.isPresent()) {
            return ResponseEntity.ok(node.get());
        }
        return ResponseEntity.notFound().build();
    }

}
