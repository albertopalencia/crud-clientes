package com.nuvu.project.services.interfaces;

import com.nuvu.project.dao.IClientDao;
import com.nuvu.project.models.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    private final IClientDao clienteDao;

    public ClientService(IClientDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Override
    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    @Override
    public Page<Cliente> findAll(Pageable pageable) {
        return clienteDao.findAll( pageable );
    }

    @Override
    public Cliente findById(Long id) {
        return clienteDao.findById( id ).orElse( null );
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteDao.save( cliente );
    }

    @Override
    public void delete(Long id) {
        clienteDao.deleteById( id );
    }
}
