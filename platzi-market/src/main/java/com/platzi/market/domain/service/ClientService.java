package com.platzi.market.domain.service;

import com.platzi.market.domain.Client;
import com.platzi.market.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Optional<Client> findById(String clientId) {
        return repository.findById(clientId);
    }

    public Client save(Client client) {
        client.setClient(client.getClient().toUpperCase());
        client.setEmail(client.getEmail().toLowerCase());
        client.setLastName(client.getLastName().toUpperCase());
        client.setAddress(client.getAddress().toUpperCase());
        return repository.save(client);
    }

    public boolean delete(String clientId) {
        return findById(clientId).map(client -> {repository.delete(clientId);
        return true;
        }).orElse(false);
    }



}
