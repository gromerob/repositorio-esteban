package com.proyectoestacionamiento.springboot.backend.apirest.models.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue(value="flete")
public class ServicioFlete extends Servicio{

	private boolean ocupado;

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public ServicioFlete(Long id, @NotNull int precio, boolean ocupado) {
		super(id, precio);
		this.ocupado = ocupado;
	}

	public ServicioFlete() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServicioFlete(Long id, @NotNull int precio) {
		super(id, precio);
		// TODO Auto-generated constructor stub
	}
	
	//para cuando llame al metodo no se llame de forma infinita, para que no se llamen entre si infinitamente
	//value=para el arreglo
	@JsonIgnoreProperties(value = {"serviciosVulcanizacion","hibernateLazyInitializer","handler"}, allowSetters = true)
    @ManyToOne()
    @JoinColumn(name="id_estacionamiento2", referencedColumnName="id")
    private Estacionamiento estacionamiento;
	
	@JsonIgnoreProperties(value = {"serviciosVulcanizacion","hibernateLazyInitializer","handler"}, allowSetters = true)
    @ManyToOne()
    @JoinColumn(name="id_trabajador", referencedColumnName="id")
    private Trabajador trabajador;
	

}
