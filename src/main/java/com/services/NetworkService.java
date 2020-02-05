package com.services;

import com.persitence.entity.NetworkNode;
import com.persitence.repository.NetworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetworkService extends AbstractService<NetworkNode, NetworkRepository> {

    @Autowired
    public NetworkService(NetworkRepository networkRepository){
        super(networkRepository);
    }

}
