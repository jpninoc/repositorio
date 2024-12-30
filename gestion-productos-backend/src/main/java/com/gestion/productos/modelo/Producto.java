package com.gestion.productos.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Random;

@Entity
@Table(name="productos")
public class Producto {
	
   private static final Random RANDOM = new Random();
		
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
   @Column (name="numero", length=16, nullable=false)
   private Long numero;
   @Column (name="estado", length=2, nullable=false)
   private int estado;
   @Column (name="saldo", nullable=false)
   private float saldo;
   @Column(name="fecha_vencimiento", nullable=false)
   private Date fechaVencimiento;
   
   
   public Producto () {
	   
   }
   
   public Producto(Long id, Long numero, int estado, float saldo, Date fechaVencimiento) {
	   super();
	   this.id=id;
	   this.numero=numero;
	   this.estado=estado;
	   this.saldo=saldo;
	   this.fechaVencimiento=fechaVencimiento;
   }

	public float getSaldo() {
		return saldo;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getNumero() {
		return numero;
	}
	
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public String generarRandomDigitos(int longitud) {
	   StringBuilder builder= new StringBuilder();
	   for (int i=0;i<longitud;i++) {
		   int digito=RANDOM.nextInt();
		   builder.append(digito);
	   }
	   return builder.toString();
	}
	
	  
}
