package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import modelo.Producto;

public class Pedido {
	
	private String id="";
	
	private int cantidad = 0;

	private HashMap<String, Producto > productos = new HashMap<>();
	
	private ArrayList<Producto> pedido = new ArrayList<>();
	
//	public Pedido (String pId)
//	{
//		id=pId;
//	}
//	
	public HashMap<String, Producto> getListaProductos()
	{
		return productos;
	}
	
	public void añadirProductoNuevo(String Nombre, String Id, int Precio, double Peso, Date Date, String Descripcion)
	{
		Producto productoNuevo = new Producto(Nombre, Id, Precio, Peso, Date, Descripcion);
		productos.put(Nombre, productoNuevo);
	}
	
	public void añadirProductoAPedido(String Nombre) throws Exception
	{
		try
		{
			for(int i =0; i<=productos.size(); i++)
			{
				if(productos.get(Nombre)!=null)
				{
					pedido.add(productos.get(Nombre));
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("No se encuentra el producto en el sistema.");
		}
	}
	
	public int obtenerCantidad (String Nombre)
	{
		for (int i =0 ; i <= pedido.size(); i++)
		{
			if(Nombre.equals(pedido.get(i).getNombre()))
			{
				cantidad++;
			}
		}
		
		return cantidad;
	}
}
