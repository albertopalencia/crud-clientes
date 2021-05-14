package com.nuvu.project.models.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


/**
 * @author: Alberto Palencia <alberto.palencia@ingeneo.com.co>
 * CreateTime: 5/10/2021
 * Description:
 */
@Data
@Entity
@Table(name = "tarjetacredito")
public class TarjetaCredito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
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
    
    
    @JsonIgnoreProperties(value={"tarjetacredito", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
}
