package com.proyectoestacionamiento.springboot.backend.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.ServicioVulcanizacion;
import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Vehiculo;
import com.proyectoestacionamiento.springboot.backend.apirest.service.IServicioVulcanizacion;
import com.proyectoestacionamiento.springboot.backend.apirest.service.IVehiculoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/apiEstacionamiento")
public class ServicioVulcanizacionResController {

	@Autowired
	IServicioVulcanizacion servicioVulcanizacion;
	
	@GetMapping("/servioVulcanizacion")
	public ResponseEntity<?> index(){
	Map<String,Object> response = new HashMap<>();
	List<ServicioVulcanizacion> listaServicio = null;
	try {
		listaServicio = servicioVulcanizacion.findAll();
		response.put("ok", true);
	} catch (Exception e) {
		// TODO: handle exception
		response.put("mensaje", "Error al realizar la consulta en la base de datos");
		response.put("ok", false);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
	}
	response.put("servicioVulcanizacion", listaServicio);
	return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);

}
}
