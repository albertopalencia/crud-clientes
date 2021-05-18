package com.nuvu.project.models.mapper;


import com.nuvu.project.models.dto.ClientDto;
import com.nuvu.project.models.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientEntityMapper {

    Cliente toDto(ClientDto client);

    ClientDto toEntity(Cliente  client);

}
