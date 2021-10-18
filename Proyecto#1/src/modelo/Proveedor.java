package modelo;

import java.util.Date;
import java.util.HashMap;

public class Proveedor {
	
	private String Orden="";
	
	private HashMap<Integer, Producto > productos = new HashMap<>();
	
	private int precioTotalDeLaOrden=0;
	
	private Date fechaDeHoy = new Date();
	
	private Date fechaDeEntrega= new Date();
	
	private int id=0;
	
	public Proveedor(int pId, HashMap<Integer, Producto> productosPedido, Date pfecha)
	{
		id=pId;
		productos=productosPedido;
		fechaDeHoy=pfecha;
		
	}
	
	public void precioProductos(HashMap<Integer, Producto> productosPedido)
	{
		System.out.println(""+productosPedido.get(1).getNombre());
		for (int i = 1; i<= productosPedido.size(); i++)
		{
			Producto producto1= productosPedido.get(i);
			int precioVenta=CalcularPrecioVenta(producto1);
			precioTotalDeLaOrden+= precioVenta;
			System.out.println("El producto: "+productosPedido.get(i).getNombre() + " , tiene un precio de: "+precioVenta +".\n");	
		}
		
		System.out.println("El precio total del pedido: $"+precioTotalDeLaOrden);
	}
	
	public int CalcularPrecioVenta(Producto producto)
	{
		int precioVenta=0;
		if(producto.getPrecio()<=1000)
		{
			precioVenta= (int) (producto.getPrecio()-producto.getPrecio()*0.50);
		}
		else if (producto.getPrecio()>1000 && producto.getPrecio()<=10000)
		{
			precioVenta= (int) (producto.getPrecio()-producto.getPrecio()*0.25);
		}
		else if (producto.getPrecio()>10000 && producto.getPrecio()<=100000)
		{
			precioVenta= (int) (producto.getPrecio()-producto.getPrecio()*0.13);
		}
		else 
		{
			precioVenta= (int) (producto.getPrecio()-producto.getPrecio()*0.08);
		}
		
		
		return precioVenta;
	}
	
	public int getPrecioTotal()
	{
		return precioTotalDeLaOrden;
	}
}