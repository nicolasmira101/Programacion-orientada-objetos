package co.edu.javeriana.vuelos.negocio;

import java.io.Serializable;

/**
 * Clase que modela una ciudad y ademas es serializable para que se 
 * puedan guardar y cargar datos del sistema
 * @author nicolasmiranda
 *
 */
public class Ciudad implements Serializable
{
	private static final long serialVersionUID = 1L;
	private long codigo;
	private String nombre;

	public Ciudad( long codigo, String nombre ) 
	{
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public long getCodigo() 
	{
		return codigo;
	}

	public void setCodigo( long codigo )
	{
		this.codigo = codigo;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre( String nombre )
	{
		this.nombre = nombre;
	}

	@Override
	public String toString()
	{
		return nombre;
	}
}
