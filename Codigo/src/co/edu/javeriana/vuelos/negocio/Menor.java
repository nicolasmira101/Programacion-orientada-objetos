package co.edu.javeriana.vuelos.negocio;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase que hereda de pasajero y contiene a toos los pasajeros que tienen
 * menos de 18 aniosos, es decir, que son menores de edad
 * @author Sebastian Valderrama y Nicolas Miranda
 *
 */
public class Menor extends Pasajero implements Serializable
{

	private static final long serialVersionUID = 1L;
	private boolean viajaSolo;

	/**
	 * Constructor explicito que herada del constructor de Pasajero
	 * @param viajaSolo
	 * @param identificacion
	 * @param nombre
	 * @param fechaNacimiento
	 */
	public Menor( boolean viajaSolo, String identificacion, String nombre, LocalDate fechaNacimiento ) 
	{
		super(nombre, nombre, fechaNacimiento);
		this.viajaSolo = viajaSolo;
	}

	public boolean isViajaSolo() 
	{
		return viajaSolo;
	}

	public void setViajaSolo( boolean viajaSolo ) 
	{
		this.viajaSolo = viajaSolo;
	}

	/**
	 * Metodo polimorfico para calvular el valor del itinerario de un Menor
	 */
	@Override
	public float calcularValorItinerario( float sumaTarifas ) 
	{
		if( viajaSolo )
		{
			float totalTarifa = sumaTarifas + 90;
			return totalTarifa;
		}
		float restar = (float) ( sumaTarifas * 0.35 );
		return sumaTarifas - restar;	
	}
}
