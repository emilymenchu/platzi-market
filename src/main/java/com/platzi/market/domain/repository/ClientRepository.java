package com.platzi.market.domain.repository;

import com.platzi.market.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    List<Client> findAll();

    Optional<Client> findById(String clientId);

    Client save(Client client);

    void delete(String clientId);
}
