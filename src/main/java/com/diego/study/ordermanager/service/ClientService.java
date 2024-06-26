package com.diego.study.ordermanager.service;

import com.diego.study.ordermanager.exception.ResourceNotFound;
import com.diego.study.ordermanager.model.Client;
import com.diego.study.ordermanager.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client getClient(Integer id) {
        return clientRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Client id " + id + " not found. - " + Client.class.getName()));
    }
}
