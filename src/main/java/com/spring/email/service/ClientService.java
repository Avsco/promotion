/**
 * @author: Alan Benavides
 */

package com.spring.email.service;

import com.spring.email.model.Client;
import com.spring.email.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClientService {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public Collection<Client> getClientByirthday(int month, int day){
        return this.repository.findByBirthday(month, day);
    }
}