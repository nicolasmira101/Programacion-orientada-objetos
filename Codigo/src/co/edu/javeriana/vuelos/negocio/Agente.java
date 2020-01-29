package co.edu.javeriana.vuelos.negocio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que modela un agente en el sistema
 * @author nicolasmiranda
 *
 */
public class Agente implements Serializable
{
	private static final long serialVersionUID = 1L;
	private long codigo;
	private String nombre;
	private String email;
	private List< Itinerario > itinerarios;

	/**
	 * Constructor explicito de agente donde se inicializan sus atributos
	 * @param codigo
	 * @param nombre
	 * @param email
	 */
	public Agente( long codigo, String nombre, String email ) 
	{
		this.codigo = codigo;
		this.nombre = nombre;
		this.email = email;
		this.itinerarios = new ArrayList< Itinerario>();
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

	public String getEmail()
	{
		return email;
	}

	public void setEmail( String email ) 
	{
		this.email = email;
	}

	public List< Itinerario > getItinerarios()
	{
		return itinerarios;
	}

	public void setItinerarios( List< Itinerario > itinerarios )
	{
		this.itinerarios = itinerarios;
	}

	/**
	 * Metodo agregarItinerario el cual recibe como parametro el nombre del itinerario
	 * e instancia un nuevo itinerario para posteriormente agregarlo a la lista de itinerarios
	 * @param nombre
	 * @return
	 */
	public void crearItinerario( String nombre )
	{
		Itinerario nuevoItinerario= new Itinerario( nombre, false );
		this.itinerarios.add( nuevoItinerario  );
	}

	/**
	 * Metodo crear trayecto el cual recibo como parametro el indice del itinerario y un
	 * vuelo especifico
	 * @param indiceItinerario
	 * @param vueloEspecifico
	 */
	public void crearTrayecto( int indiceItinerario, VueloEspecifico vueloEspecifico )
	{
		this.itinerarios.get( indiceItinerario ).crearTrayecto( vueloEspecifico );

	}

	/**
	 * Método que permite comprar un itinerario y en este caso un itinerario para la clase Mayor
	 * @param indiceItinerario
	 * @param numeroIdentifiacionPasajero
	 * @param nombrePasajero
	 * @param fechaNacimiento
	 * @param asistencia
	 */
	public void comprarItinerarioMayor( int indiceItinerario, String numeroIdentifiacionPasajero, String nombrePasajero, LocalDate fechaNacimiento, boolean asistencia )
	{
		this.itinerarios.get( indiceItinerario ).comprarItinerarioMayor( numeroIdentifiacionPasajero, nombrePasajero, fechaNacimiento, asistencia );
	}

	/**
	 * Método que permite comprar un itinerario y en este caso un itinerario para la clase Menor
	 * @param indiceItinerario
	 * @param numeroIdentifiacionPasajero
	 * @param nombrePasajero
	 * @param fechaNacimiento
	 * @param viajaSolo
	 */
	public void comprarItinearioMenor( int indiceItinerario, String numeroIdentifiacionPasajero, String nombrePasajero, LocalDate fechaNacimiento, boolean viajaSolo )
	{
		this.itinerarios.get(indiceItinerario).comprarItinerarioMenor( nombrePasajero, nombrePasajero, fechaNacimiento, viajaSolo );

	}
	
	/**
	 * Método que asigna las sillas a un pasajero en un itinerario especifico
	 * @param codigoSilla
	 * @param posicionPasajero
	 * @param codItinerario
	 */
	public void asignarSilla( String codigoSilla,int posicionPasajero,int codItinerario )
	{
		this.itinerarios.get( codItinerario ).asignarSillas( codigoSilla, posicionPasajero );
	}

	@Override
	public String toString() 
	{
		return nombre;
	}
}
