package modelo;

import java.util.Date;
import java.util.HashMap;

public class proovedor {
	
	private String Orden="";
	
	private HashMap<String, Producto > productos = new HashMap<>();
	
	private int precioTotalDeLaOrden=0;
	
	private Date fechaDeEntrega= new Date();
	
}
