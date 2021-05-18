package com.nuvu.project.repository;


import com.nuvu.project.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Cliente, Long> {

}
