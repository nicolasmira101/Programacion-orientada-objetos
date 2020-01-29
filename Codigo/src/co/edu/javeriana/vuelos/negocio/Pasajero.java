package co.edu.javeriana.vuelos.negocio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Clase que modela un pasajero, y que tiene dos tipos de pasajeros, menor
 * y mayor
 * @author nicolasmiranda
 *
 */
public abstract class Pasajero implements Serializable
{
	private static final long serialVersionUID = 1L;
	protected String identificacion;
	protected String nombre;
	protected LocalDate fechaNacimiento;
	private List <Silla> sillas;
	
	/**
	 * Constructor explicito del pasajero
	 * @param identificacion
	 * @param nombre
	 * @param fechaNacimiento
	 */
	public Pasajero( String identificacion, String nombre, LocalDate fechaNacimiento ) 
	{
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getIdentificacion()
	{
		return identificacion;
	}

	public void setIdentificacion( String identificacion ) 
	{
		this.identificacion = identificacion;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre( String nombre ) 
	{
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() 
	{
		return fechaNacimiento;
	}

	public void setFechaNacimiento( LocalDate fechaNacimiento ) 
	{
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public abstract float calcularValorItinerario( float sumaTarifas );
	
	/**
	 * Metodo que agrega una silla a su lista de sillas
	 * @param sillaAsignada
	 */
	public void asignarSilla( Silla sillaAsignada )
	{
		this.sillas.add( sillaAsignada );
	}

	@Override
	public String toString() 
	{
		return nombre;
	}
	
}
