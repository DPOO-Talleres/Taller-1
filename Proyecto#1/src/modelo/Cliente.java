package modelo;

public class Cliente {

	private String Nombre="";
	
	public Cliente (String pNombre)
	{
		Nombre=pNombre;
	}
	
	public String getNombreCliente()
	{
		return Nombre;
	}
}
