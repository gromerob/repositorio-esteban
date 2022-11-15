package com.proyectoestacionamiento.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(nullable = false, unique = true)
	private String nombre;
	
	@NotNull
	private int numero;
	
	@NotEmpty
	private String direccion;
	
	@NotEmpty
	private String rut;
	
	//para cuando llame al metodo no se llame de forma infinita, para que no se llamen entre si infinitamente
	@JsonIgnoreProperties(value ={"cliente","hibernateLazyInitializer","handler"}, allowSetters = true)
    @OneToMany(mappedBy = "cliente")
    private Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public Set<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Set<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Cliente(Long id, @NotEmpty String nombre, @NotNull int numero, @NotEmpty String direccion,
			@NotEmpty String rut, Set<Vehiculo> vehiculos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numero = numero;
		this.direccion = direccion;
		this.rut = rut;
		this.vehiculos = vehiculos;
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	

}
