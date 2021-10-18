package Interface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import modelo.Caja;
import modelo.Cliente;
import modelo.Inventario;
import modelo.Producto;
import modelo.Proveedor;
import logic.Pedido;

public class Tienda {

	private Pedido pedido1;
	
	private ArrayList<Pedido> pedidos= new ArrayList<>();
	
	private ArrayList<Pedido> pedidosProveedores= new ArrayList<>();
	
	private Producto producto;
	
	private static HashMap<Integer, Producto > productos = new HashMap<>();
	
	private static HashMap<Integer, Producto > productosPedido = new HashMap<>();
	
	private static HashMap<Integer, Producto > productosPedidoProveedores = new HashMap<>();
	
	private static HashMap<Integer, Producto> productosEnInventario = new HashMap<>();
	
	private static HashMap<Integer, Producto> productosVencidos = new HashMap<>();
	
	private ArrayList<Cliente> clientes = new ArrayList<>();
	
	public void ejecutarAplicacion() throws Exception
	{
		System.out.println("Bienvenido a la tienda");
		
		boolean continuar = true;
		while (continuar)
		{
			mostrarMenu();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion "));
			if (opcion_seleccionada == 1)
				añadirProductos();
			else if (opcion_seleccionada == 2)
				realizarPedido();
			else if (opcion_seleccionada == 3)
				realizarPedidoPorveedor();
			else if (opcion_seleccionada == 4)
				agregarProductosAlPedido();
			else if (opcion_seleccionada == 5)
				cerrarPedido();
			else if (opcion_seleccionada == 6)
				productosTotalesInventario();
			else {
				continuar=false;
			}
		}
	}

	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la tienda\n");
		System.out.println("1. Añadir productos a la base de datos");
		System.out.println("2. Realizar pedido");
		System.out.println("3. Realizar pedido a proveedor");
		System.out.println("4. Agregar un elemento a un pedido");
		System.out.println("5. Cerrar un pedido y guargar la factura");
		System.out.println("6. Consultar la informacion del inventario");
		System.out.println("7. Salir de la aplicación\n");
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
		añadirProductoNuevo(nombre, id, precio, peso, fecha, descripcion);
		
		System.out.println("\nEl producto fue añadido.");
	}
	
	public void añadirProductoNuevo(String Nombre, String Id, int Precio, double Peso, Date Date, String Descripcion)
	{
		Producto productoNuevo = new Producto(Nombre, Id, Precio, Peso, Date, Descripcion);
		productos.put(productos.size(), productoNuevo);
	}
	
	public void realizarPedido() throws Exception
	{
		System.out.println("");
		String nombreCliente = input("Introduzca su nombre ");
		Cliente cliente = new Cliente(nombreCliente);
		clientes.add(cliente);
		String nombre = input("Introduzca el nombre del producto ");
		for(int i=0; i<=productos.size();i++)
		{
			if (productos.get(i).getNombre().equals(nombre))
			{
				int cantidad = Integer.parseInt(input("Introduzca la cantidad "));
				Pedido pedidoNuevo= new Pedido(pedidos.size(), productosPedido);
				for(int j=1; j<=cantidad; j++) 
				{
				productosPedido.put(i, productos.get(i));
//				pedidoNuevo.añadirProductoAPedido(nombre, productosPedido);
				System.out.println("" +productosPedido.get(0));
				}
				
				pedidos.add(pedidoNuevo);
				
				System.out.println("\nPedido realizado - id: "+i);
			}
		}
		
	}
	
	public void realizarPedidoPorveedor() throws Exception
	{
		System.out.println("");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String nombre = input("Introduzca el nombre del producto ");
		int cantidad = Integer.parseInt(input("Introduzca la cantidad "));
		Date fecha = formato.parse(input(("Introduzca la fecha de hoy: dd/MM/yyyy")));
		Pedido pedidoNuevo= new Pedido(pedidosProveedores.size(), productosPedidoProveedores);
		
		for(int i=1; i<=cantidad; i++) 
		{
		for(int j =0; i<=productos.size(); i++)
		{
			if(productos.containsValue(pedidoNuevo))
			{
				productosPedidoProveedores.put(i, productos.get(i));
			}
		}
		pedidoNuevo.añadirProductoAPedido(nombre, productosPedidoProveedores);

		}
		pedidosProveedores.add(pedidoNuevo);
		
		Proveedor proveedor = new Proveedor(pedidosProveedores.size(), productosPedidoProveedores, fecha);
		proveedor.precioProductos(productosPedidoProveedores);
		
		
		System.out.println("\nPedido realizado - id:"+ pedidosProveedores.size());
	}
	
	public void agregarProductosAlInventerio()
	{
		for(int i = 0; i<=productosPedidoProveedores.size(); i++)
		{
			productosEnInventario.put(i, productosPedidoProveedores.get(i));
		}
	}
	
	public void eliminarProductosAlInventerio()
	{
		for(int i = 0; i<=productosPedidoProveedores.size(); i++)
		{
			productosEnInventario.remove(i, productosPedidoProveedores.get(i));
		}
	}
	
	public void cerrarPedido()
	{
		Caja caja = new Caja(pedido1);
		
		caja.CerrarPedido(productosPedido);
	}
	
	public void productosTotalesInventario()
	{
		Inventario inventario= new Inventario(productosEnInventario);
		String nombre = input("Introduzca el nombre del producto ");
		for (int i =0; i<=productosEnInventario.size(); i++)
		{
			if(productosEnInventario.get(i).getNombre().equals(nombre))
			{
				inventario.getCantidadDeUnProducto(productosEnInventario.get(i));
			}
		}
	}
	
	public void agregarProductosAlPedido() throws Exception
	{
		int key = Integer.parseInt(input("Introduzca el id del pedido "));
		String nombre = input("Introduzca el nombre del producto ");
		pedidos.get(key).añadirProductoAPedido(nombre, productosPedido);
	}
	
	public Producto buscarProducto(int key)
	{
		return productos.get(key);
	}
	
	public Pedido buscarPedido(int key)
	{
		return pedidos.get(key);
	}
	
	public HashMap<Integer, Producto > getProductos()
	{
		return productos;
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
	
	public static void main(String[] args) throws Exception
	{
		Tienda consola = new Tienda();
		consola.ejecutarAplicacion();
	}
}
