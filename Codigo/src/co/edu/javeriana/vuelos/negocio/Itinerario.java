package co.edu.javeriana.vuelos.negocio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * Clase que modela un itinerario en el sistema
 * @author nicolasmiranda
 *
 */
public class Itinerario implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private static long CONSECUTIVO = 0;
	private long codigo;
	private String nombre;
	private boolean comprado;
	private VueloEspecifico vueloEspecifico;
	private List< Trayecto > trayectos;
	private List< Pasajero > pasajeros;
	
	/**
	 * Constructor explicito donde se inicializan sus atributos
	 * @param nombre
	 * @param comprado
	 */
	public Itinerario( String nombre, boolean comprado ) 
	{
		this.codigo = CONSECUTIVO++;
		this.nombre = nombre;
		this.comprado = comprado;
		this.trayectos = new ArrayList< Trayecto >();
		this.pasajeros = new ArrayList< Pasajero >();
	}

	public static long getCONSECUTIVO() 
	{
		return CONSECUTIVO;
	}

	public static void setCONSECUTIVO( long cONSECUTIVO ) 
	{
		CONSECUTIVO = cONSECUTIVO;
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

	public boolean isComprado() 
	{
		return comprado;
	}

	public void setComprado( boolean comprado ) 
	{
		this.comprado = comprado;
	}

	public List< Trayecto > getTrayectos()
	{
		return trayectos;
	}

	public void setTrayectos( List< Trayecto > trayectos ) 
	{
		this.trayectos = trayectos;
	}

	public List<Pasajero> getPasajeros() 
	{
		return pasajeros;
	}

	public void setPasajeros( List< Pasajero > pasajeros ) 
	{
		this.pasajeros = pasajeros;
	}
	
	public VueloEspecifico getVueloEspecifico() 
	{
		return vueloEspecifico;
	}

	public void setVueloEspecifico( VueloEspecifico vueloEspecifico )
	{
		this.vueloEspecifico = vueloEspecifico;
	}

	/**
	 * Metodo que crea un trayecto y lo agrega a su lista de trayectos
	 * @param vueloEspecifico
	 */
	public void crearTrayecto( VueloEspecifico vueloEspecifico )
	{
		Trayecto nuevoTrayecto= new Trayecto( vueloEspecifico );
		this.trayectos.add(nuevoTrayecto);
	}
	
	/**
	 * Metodo que permite comprar un itinerario en este caso Mayor, en el cual,
	 *  se instancia un pasajero y se agrega a su lista de pasajeros
	 * @param numeroIdentifiacionPasajero
	 * @param nombrePasajero
	 * @param fechaNacimiento
	 * @param asistencia
	 */
	public void comprarItinerarioMayor( String numeroIdentifiacionPasajero, String nombrePasajero, LocalDate fechaNacimiento, boolean asistencia )
	{
		Pasajero nuevoPasajero= new Mayor( asistencia, nombrePasajero, nombrePasajero, fechaNacimiento );
		this.pasajeros.add( nuevoPasajero );
		
	}
	
	/**
	 * Metodo que permite comprar un itinerario en este caso Menor , en el cual, 
	 * se instancia un pasajero y se agrega a su lista de pasajeros
	 * @param numeroIdentifiacionPasajero
	 * @param nombrePasajero
	 * @param fechaNacimiento
	 * @param viajaSolo
	 */
	public void comprarItinerarioMenor( String numeroIdentifiacionPasajero, String nombrePasajero, LocalDate fechaNacimiento, boolean viajaSolo )
	{
		Pasajero nuevoPasajero=new Menor( viajaSolo, nombrePasajero, nombrePasajero, fechaNacimiento );
		this.pasajeros.add(nuevoPasajero);
	}
	
	/**
	 * Metodo que asigna una silla a un pasajero qeu se encuentra en una posicion
	 * especifica
	 * @param codSilla
	 * @param posicionPasajero
	 */
	public void asignarSillas( String codSilla,int posicionPasajero )
	{
		int posicion = buscarSilla( codSilla );
		this.pasajeros.get( posicionPasajero ).asignarSilla( vueloEspecifico.getSillas().get(posicion) );
	}
	
	/**
	 * Metodo que nos permite buscar una silla dado el codigo y nos retorna la 
	 * posicion en que se encuentra
	 * @param codSilla
	 * @return
	 */
	public int buscarSilla( String codSilla )
	{
		int tamanio = vueloEspecifico.getSillas().size();
		for( int i = 0 ; i < tamanio ; i++ )
		{
			String id = vueloEspecifico.getSillas().get( i ).getId();
			if( id == codSilla )
			{
				vueloEspecifico.getSillas().get( i ).setComprada( true );
				return i;
			}
		}
		return 0;	
	}
	
	/**
	 * Metodo que recorre la lista de trayectos para ir calculado el valor del
	 * itinerario y ese valor asignarselo a un pasajero
	 * @param posicionPasajero
	 * @return
	 */
	public float calcularValorItinerario( int posicionPasajero )
	{
		float total = 0;
		for ( Trayecto trayecto : trayectos )
		{
			LocalDate fecha = trayecto.getVueloEspecifico().getFecha();
			Long tarifa = trayecto.getVueloEspecifico().getTarifa();
			total = total + trayecto.getVueloEspecifico().calcularValorPasaje( fecha, tarifa );
		}
		this.pasajeros.get( posicionPasajero ).calcularValorItinerario( total );
		return 0;
	}
	
	@Override
	public String toString() 
	{
		return nombre ;
	}
}
