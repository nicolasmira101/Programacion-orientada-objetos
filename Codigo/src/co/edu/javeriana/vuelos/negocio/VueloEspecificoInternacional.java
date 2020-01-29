package co.edu.javeriana.vuelos.negocio;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase que herada de vuelo especifico y modela un vuelo especifico
 * internacional
 * @author nicolasmiranda
 *
 */
public final class VueloEspecificoInternacional extends VueloEspecifico implements Serializable
{
	private static final long serialVersionUID = 1L;
	private long impuestoSalida;

	public VueloEspecificoInternacional( long impuestoSalida,LocalDate fecha, TipoAvion tipoAvion, int capacidad, int cuposLibres,long tarifa )
	{
		super( fecha, tipoAvion, capacidad, cuposLibres, tarifa);
		this.impuestoSalida = impuestoSalida;
	}
	
	public long getImpuestoSalida() 
	{
		return impuestoSalida;
	}

	public void setImpuestoSalida(long impuestoSalida) 
	{
		this.impuestoSalida = impuestoSalida;
	}
	
	/**
	 * Metodo sobre escrito de vuelo especifico
	 */
	@Override
	public float calcularValorPasaje( LocalDate fecha, long tarifaBasica )
	{
		float tarifaTotal = 0;
		
		boolean esTemporadaAlta = verificarFechaTemporadaAlta( fecha );
		
		if ( esTemporadaAlta)
			tarifaTotal = (float) ( tarifaBasica + ( tarifaBasica * 0.2) + this.impuestoSalida );
		else
			tarifaTotal = (float) ( tarifaBasica + this.impuestoSalida );
		
		return tarifaTotal;
	}

}
