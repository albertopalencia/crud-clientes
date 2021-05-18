package com.nuvu.project.repository;

import com.nuvu.project.models.entity.TarjetaCredito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITarjetaCreditoRepository extends CrudRepository<TarjetaCredito, Long> {
}
