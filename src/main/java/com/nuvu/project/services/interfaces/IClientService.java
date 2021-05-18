package com.nuvu.project.services.interfaces;

import com.nuvu.project.models.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IClientService {

    List<Cliente> findAll();

    Page<Cliente> findAll(Pageable pageable);

    Optional<Cliente> findById(Long id);

    Cliente save(Cliente cliente);

    void delete(Long id);
}
