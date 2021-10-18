package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import Interface.Tienda;
import modelo.Producto;

public class Pedido {
	
	private int id=0;
	
	private int cantidad = 0;

	private HashMap<Integer, Producto > productosDelPedido = new HashMap<>();
	
	private ArrayList<Producto> pedido = new ArrayList<>();
	
	public Pedido (int pId, HashMap<Integer, Producto > productosPedido)
	{
		id=pId;
		productosDelPedido= productosPedido;
	}
	
	public HashMap<Integer, Producto> getListaProductos()
	{
		return productosDelPedido;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void añadirProductoAPedido(String Nombre, HashMap<Integer, Producto > mapa) throws Exception
	{
		Tienda tienda = new Tienda();
		HashMap<Integer, Producto> productos= tienda.getProductos();
		try
		{
			for(int i =0; i<=productos.size(); i++)
			{
				if(productos.get(i)!=null)
				{
					mapa.put(i, productos.get(i));
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("No se encuentra el producto en el sistema.");
		}
	}
	
	
//	public void añadirProductoPedido(String Nombre) throws Exception
//	{
//		try
//		{
//			for(int i =0; i<=productos.size(); i++)
//			{
//				if(productos.get(i)!=null)
//				{
//					pedido.add(productos.get(i));
//				}
//			}
//		}
//		catch (Exception e)
//		{
//			System.out.println("No se encuentra el producto en el sistema.");
//		}
//	}
	
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
