package com.nuvu.project.services;


import com.nuvu.project.models.entity.Cliente;

import com.nuvu.project.repository.ITarjetaCreditoRepository;
import com.nuvu.project.services.interfaces.IClientService;
import com.nuvu.project.repository.IClientRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class ClientService implements IClientService {

    private final IClientRepository clientRepository;

    @Autowired
    public ClientService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Cliente> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Page<Cliente> findAll(Pageable pageable) {
        return clientRepository.findAll( pageable );
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clientRepository.findById( id );
    }

    @Override
    public Cliente save(Cliente client) {
      return   clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById( id );
    }
}
