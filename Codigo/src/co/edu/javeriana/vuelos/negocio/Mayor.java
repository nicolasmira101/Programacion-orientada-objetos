package co.edu.javeriana.vuelos.negocio;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase que hereda de un pasajero y modela el comportamiento de un pasajero
 * que en este caso es mayor de edad
 * @author nicolasmiranda
 *
 */
public class Mayor extends Pasajero implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private boolean requiereAsistencia;

	/**
	 * Constructor explicito que herada del constructor de Pasajero
	 * @param requiereAsistencia
	 * @param identificacion
	 * @param nombre
	 * @param fechaNacimiento
	 */
	public Mayor( boolean requiereAsistencia, String identificacion, String nombre, LocalDate fechaNacimiento ) 
	{
		super( nombre, nombre, fechaNacimiento );
		this.requiereAsistencia = requiereAsistencia;
	}

	public boolean isRequiereAsistencia() 
	{
		return requiereAsistencia;
	}

	public void setRequiereAsistencia( boolean requiereAsistencia ) 
	{
		this.requiereAsistencia = requiereAsistencia;
	}

	/**
	 * Metodo polimorfico para calvular el valor del itinerario de un Mayor
	 */
	@Override
	public float calcularValorItinerario( float sumaTarifas )
	{
		if( requiereAsistencia )
		{
			float totalCosto=sumaTarifas+50;
			return totalCosto;
		}
		else
			return sumaTarifas;
	}
	

}
