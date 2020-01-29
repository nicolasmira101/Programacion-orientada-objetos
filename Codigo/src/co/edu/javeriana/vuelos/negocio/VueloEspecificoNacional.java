package co.edu.javeriana.vuelos.negocio;

import java.io.Serializable;
import java.time.LocalDate;
 
/**
 * Clase que herada de vuelo especifico y modela un vuelo especifico
 * nacional
 * @author nicolasmiranda
 *
 */
public final class VueloEspecificoNacional extends VueloEspecifico implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int iva;
	
	public VueloEspecificoNacional( int iva,LocalDate fecha, TipoAvion tipoAvion, int capacidad, int cuposLibres, long tarifa ) 
	{
		super( fecha, tipoAvion, capacidad, cuposLibres, tarifa);
		this.iva = iva;
	}

	public int getIva()
	{
		return iva;
	}

	public void setIva(int iva) 
	{
		this.iva = iva;
	}
	
	@Override
	public float calcularValorPasaje( LocalDate fecha, long tarifaBasica)
	{
		float tarifaTotal = 0;
		float porciento = 100f;
		
		float tarifaReal = ( float ) tarifaBasica;
		float ivaReal = this.iva / porciento;
		
		boolean esTemporadaAlta = verificarFechaTemporadaAlta( fecha );
		
		if ( esTemporadaAlta )
			tarifaTotal = (float) ( tarifaReal + ( tarifaReal * 0.2) + ( tarifaReal * ( ivaReal ) ) );
		else
			tarifaTotal = (float) ( tarifaReal + ( tarifaReal * ( ivaReal ) )  );
		
		return tarifaTotal;
	}

}
