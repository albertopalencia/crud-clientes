package com.nuvu.project.dao;

import com.nuvu.project.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientDao extends JpaRepository<Cliente, Long> {

}
