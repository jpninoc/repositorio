package com.gestion.productos.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.productos.modelo.Producto;
import com.gestion.productos.respositorio.ProductoRepositorio;


@RestController
@RequestMapping("/api/v1/")
public class ProductoControlador {
	
 private static final Long CONSTANTE_VISA=(long) 491268;
	
   @Autowired
   private ProductoRepositorio repositorio;
   
   @GetMapping("/card/{id}/number")
   public ResponseEntity<Producto> generarNumeroTarjeta(@PathVariable Long id) {
	  Long randomNum=generarRandomDigitos(6);
	  return CONSTANTE_VISA+randomNum;
   }
   
   @PostMapping("/card/enrroll")
   public Producto activarTarjeta(@RequestBody Producto producto) {
	   return repositorio.save(producto);
   }
   
}
