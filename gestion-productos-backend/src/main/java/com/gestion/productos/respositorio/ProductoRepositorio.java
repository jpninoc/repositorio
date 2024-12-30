package com.gestion.productos.respositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.productos.modelo.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long>{
	
}
