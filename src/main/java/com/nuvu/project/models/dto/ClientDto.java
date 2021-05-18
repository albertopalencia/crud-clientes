package com.nuvu.project.models.dto;

import com.nuvu.project.models.entity.TarjetaCredito;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    @NotEmpty(message = "no puede estar vacio")
    @Size(min = 2, max = 4, message = "el tamaño tiene que estar entre 2 y 4")
    @Column(nullable = false)
    private String tipoDocumento;

    @NotEmpty(message = "no puede estar vacio")
    @Size(min = 4, max = 4, message = "el tamaño tiene que estar entre 4 y 12")
    @Column(nullable = false)
    private String documento;


    @NotEmpty(message = "no puede estar vacio")
    @Size(min = 4, max = 12, message = "el tamaño tiene que estar entre 4 y 12")
    @Column(nullable = false)
    private String nombre;

    @NotEmpty(message = "no puede estar vacio")
    private String apellido;


    @Column(nullable = false, unique = true)
    private String telefono;

    @Column(nullable = false, unique = true)
    private String direccion;

    @NotEmpty(message = "no puede estar vacio")
    @Email(message = "no es una dirección de correo bien formada")
    @Column(nullable = false, unique = true)
    private String email;

    private TarjetaCredito tarjetas;

}
