package Interface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import modelo.Producto;
import logic.Pedido;

public class Tienda {

	private Pedido pedido1;
	
	private ArrayList<Pedido> pedidos= new ArrayList<>();
	
	private Producto productos;
	
	public void ejecutarAplicacion() throws ParseException
	{
		System.out.println("Bienvenido a la tienda");
		
		boolean continuar = true;
		while (continuar)
		{
			mostrarMenu();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion "));
			if (opcion_seleccionada == 1)
				añadirProductos();
//			else if (opcion_seleccionada == 2 && restaurante != null)
//				iniciarPedido();
//			else if (opcion_seleccionada == 3 && restaurante != null)
//				agregarElementoAlPedido();
//			else if (opcion_seleccionada == 4 && restaurante != null)
//				CerrarPedido();
//			else if (opcion_seleccionada == 5 && restaurante != null)
//				consultarInfoPedido();
		}
	}

	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la tienda\n");
		System.out.println("1. Añadir productos a la base de datos");
		System.out.println("1. Realizar pedido");
		System.out.println("2. Realizar pedido a proveedor");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guargar la factura");
		System.out.println("5. Consultar la informacion del pedido");
		System.out.println("6. Salir de la aplicación\n");
	}
	
	public void añadirProductos() throws ParseException 
	{
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String nombre = input("Introduzca el nombre del producto");
		String id="";
//		if(pedido1.getListaProductos()==null)
//		{
//			id = ""+1;
//		}
//		else  id = ""+pedido1.getListaProductos().size()+1;
		int precio = Integer.parseInt(input("Introduzca el precio que tendra el producto"));
		double peso = Double.parseDouble(input("Introduzca el peso del producto en g"));
		Date fecha = formato.parse(input(("Introduzca la fecha de vencimiento con el siguiente formato: dd/MM/yyyy")));
		String descripcion = input("Introduzca la descripcion del producto");
		pedido1.añadirProductoNuevo(nombre, id, precio, peso, fecha, descripcion);
	}
	
	public void realizarPedido()
	{
		System.out.println("");
	}
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws ParseException
	{
		Tienda consola = new Tienda();
		consola.ejecutarAplicacion();
	}
}
