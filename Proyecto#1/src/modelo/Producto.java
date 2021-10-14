package modelo;

import java.util.Date;

public class Producto {

	private String nombre="";
	
	private String id="";
	
	private int precio=0;
	
	private double peso=0;
	
	private Date fechaDeVencimiento= new Date();
	
	private String descripcion="";
	
	public Producto(String pNombre, String pId, int pPrecio, double pPeso, Date pDate, String pDescripcion)
	{
		nombre=pNombre;
		
		id=pId;
		
		precio=pPrecio;
		
		peso=pPeso;
		
		fechaDeVencimiento=pDate;
		
		descripcion= pDescripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Date getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}

	public void setFechaDeVencimiento(Date fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
