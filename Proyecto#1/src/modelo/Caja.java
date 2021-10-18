package modelo;

import java.util.HashMap;

import logic.Pedido;

public class Caja {

	private int dineroCobrar=0;
	
	private int dineroPagar=0;
	
	private int cambio=0;
	
	private Pedido pedido;
	
	public Caja (Pedido pPedido)
	{
		pedido= pPedido;
	}
	
	public void CerrarPedido(HashMap<Integer, Producto> productosPedido)
	{
		int precioTotalDeLaOrden=0;
		
		for (int i = 1; i<= productosPedido.size(); i++)
		{
			Producto producto1= productosPedido.get(i);
			int precio=producto1.getPrecio();
			precioTotalDeLaOrden+= precio;
			System.out.println("" + producto1.getNombre() +" PRECIO: "+ producto1.getPrecio());	
		}
		System.out.println("El precio total del pedido es: " + precioTotalDeLaOrden);
		System.out.println("El precio total del pedido: $"+precioTotalDeLaOrden);
	}
}
