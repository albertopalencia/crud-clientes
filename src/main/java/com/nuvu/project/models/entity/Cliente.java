package com.nuvu.project.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
	
	@JsonIgnoreProperties(value={"cliente", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<TarjetaCredito> tarjetaCreditos;
}
