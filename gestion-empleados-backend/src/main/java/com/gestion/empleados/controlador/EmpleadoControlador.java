package com.gestion.empleados.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.modelo.Empleado;
import com.gestion.empleados.respositorio.EmpleadoRepositorio;
import com.gestion.empleados.excepciones.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins="http://localhost:4200")
public class EmpleadoControlador {

	@Autowired
	private EmpleadoRepositorio repositorio;

	//Este método sirve para listar todos los empleados
	@GetMapping("/empleados")
	public List<Empleado> listarTodosLosEmpleados() {
		return repositorio.findAll();
	}
	
	//Este método sirve para guardar el empleado
	@PostMapping("/empleados")
	public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
		return repositorio.save(empleado);
	}
	
	//Este método sirve para buscar un empleado por ID
	@GetMapping("/empleados/{id}")
	public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id) {
		Empleado empleado=repositorio.findById(id).orElseThrow(()->new ResourceNotFoundException("No existe el empleado con ID: "+id));
		return ResponseEntity.ok(empleado);
	}
	
	//Este método sirve para actualizar un empleado por ID
	@PutMapping("/empleados/{id}")
	public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id, @RequestBody Empleado detallesEmpleado) {
		Empleado empleado=repositorio.findById(id).orElseThrow(()->new ResourceNotFoundException("No existe el empleado con ID: "+id));
		empleado.setNombre(detallesEmpleado.getNombre());
		empleado.setApellido(detallesEmpleado.getApellido());
		empleado.setEmail(detallesEmpleado.getEmail());
		Empleado empleadoActualizado=repositorio.save(empleado);
		return ResponseEntity.ok(empleadoActualizado);
	}
}
