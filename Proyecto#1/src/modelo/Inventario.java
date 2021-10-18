package modelo;

import java.util.HashMap;

public class Inventario {
	
	private HashMap<Integer, Producto> inventario = new HashMap<>();
	
	private int cantidadProductosTotales=0;

	public Inventario(HashMap<Integer, Producto> pInventario)
	{
		inventario=pInventario;
	}
	
	public int getCantidadProductosTotales()
	{
		cantidadProductosTotales=inventario.size();
		return cantidadProductosTotales;
	}
	
	public int getCantidadDeUnProducto(Producto producto)
	{
		int cantidadPorProducto=0;
		for(int i=0; i<=inventario.size();i++)
		{
			if(inventario.get(i).equals(producto))
			{
				cantidadPorProducto++;
			}
		}
		return cantidadPorProducto;
	}
}
