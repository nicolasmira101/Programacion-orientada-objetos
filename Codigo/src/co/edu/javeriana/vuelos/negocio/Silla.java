package co.edu.javeriana.vuelos.negocio;

import java.io.Serializable;

/**
 * Clase que modela una silla en el sistema
 * @author nicolasmiranda
 *
 */
public class Silla  implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String id;
	private boolean comprada;
	private Pasajero pasajeroAvion;
	private VueloEspecifico vueloEspecifico;

	/**
	 * Constructor explicito donde se inicializan todos sus atributos
	 * @param id
	 * @param comprada
	 */
	public Silla( String id, boolean comprada, VueloEspecifico vueloEspecifico )
	{
		this.id = id;
		this.comprada = comprada;
		this.vueloEspecifico = vueloEspecifico;
	}

	public String getId() 
	{
		return id;
	}

	public void setId( String id )
	{
		this.id = id;
	}

	public boolean isComprada() 
	{
		return comprada;
	}

	public void setComprada( boolean comprada )
	{
		this.comprada = comprada;
	}

	public Pasajero getPasajeroAvion() 
	{
		return pasajeroAvion;
	}

	public void setPasajeroAvion( Pasajero pasajeroAvion )
	{
		this.pasajeroAvion = pasajeroAvion;
	}
	
	public VueloEspecifico getVueloEspecifico() 
	{
		return vueloEspecifico;
	}

	public void setVueloEspecifico( VueloEspecifico vueloEspecifico )
	{
		this.vueloEspecifico = vueloEspecifico;
	}

	@Override 
	public String toString() 
	{
		return id + "\t" + comprada;
	}

}
