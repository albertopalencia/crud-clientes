package com.nuvu.project.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TarjetaCreditoDto {

    @NotEmpty(message = "no puede estar vacio")
    @Size(min = 16, max = 16, message = "el tamaño tiene que estar entre 4 y 12")
    @Column(nullable = false)
    private String numero;

    @NotEmpty(message = "no puede estar vacio")
    @Column(nullable = false)
    private float cupo;

    @NotEmpty(message = "no puede estar vacio")
    @Column(nullable = false)
    private String expiracion;

    @NotEmpty(message = "no puede estar vacio")
    @Column(nullable = false)
    @Size(min = 3, max = 4, message = "el tamaño tiene que estar entre 3 y 4")
    private String codigoSeguridad;
}
