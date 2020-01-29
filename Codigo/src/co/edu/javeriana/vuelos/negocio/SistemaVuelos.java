package co.edu.javeriana.vuelos.negocio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import co.edu.javeriana.vuelos.negocio.Aerolinea;

/**
 * Clase que contiene todos los metodos que modelan el comportamiento
 * general del sistema
 * @author nicolasmiranda
 *
 */
public class SistemaVuelos implements ISistemaViajes, Serializable
{
	private static final long serialVersionUID = 1L;
	private Map< Long, Agente > agentes;
	private Map< Long, Aerolinea > aerolineas;
	private List< Ciudad > ciudades;

	/**
	 * Constructor que inicializa las listas tanto de agentes, aerolineas
	 * como un mapa, en el cual sus llaves son los codigo que son de tipo
	 * long, y las ciudades que son un arrayList
	 */
	public SistemaVuelos() 
	{
		this.agentes = new HashMap< Long, Agente >();
		this.aerolineas = new HashMap< Long, Aerolinea >();
		this.ciudades = new ArrayList< Ciudad >();
	}	

	@Override
	public Map< Long, Agente > getAgentes() 
	{
		return agentes;
	}

	public void setAgentes( Map< Long, Agente > agentes ) 
	{
		this.agentes = agentes;
	}

	@Override
	public Map< Long, Aerolinea > getAerolineas()
	{
		return aerolineas;
	}

	public void setAerolineas( Map< Long, Aerolinea > aerolineas )
	{
		this.aerolineas = aerolineas;
	}

	@Override
	public List< Ciudad > getCiudades()
	{
		return ciudades;
	}

	public void setCiudades( List< Ciudad > ciudades )
	{
		this.ciudades = ciudades;
	}

	/**
	 * Metodo que crear una ciudad y la agrega a su lista de ciudades
	 */
	@Override
	public void crearCiudad( long codigo, String nombre ) 
	{
		Ciudad nuevaCiudad = new Ciudad( codigo, nombre );
		boolean estaCiudad = buscarCiudadPorNombre(nombre);
		if( !estaCiudad )
			this.ciudades.add( nuevaCiudad );
		else
			throw new IllegalArgumentException(" La ciduad ya esta ");
	}

	/**
	 * Metodo que nos permite buscar una ciudad mediante su codigo 
	 * y nos retorna toda la ciudad
	 * @param codigoCiudad
	 * @return
	 */
	public Ciudad buscarCiudadPorCodigo( long codigoCiudad )
	{
		for ( Ciudad ciudad : ciudades )
		{
			if( ciudad.getCodigo() == codigoCiudad )
				return ciudad;
		}
		return null;
	}
	
	/**
	 * Método que nos permite buscar una ciudad por el nombre y nos
	 * retorna si la encontró o no
	 * @param nombre
	 * @return
	 */
	public boolean buscarCiudadPorNombre( String nombre )
	{
		boolean flag = false;
		for (Ciudad ciudad : ciudades)
		{
			if( ciudad.getNombre().equals( nombre ) )
				flag = true;
		}
		return flag;
	}

	/**
	 * Método que crea una aerolinea y la agrega a su lista 
	 */
	@Override
	public void crearAerolinea( long codigo, String nombre, String cuentaBanco )
	{
		Aerolinea nuevaAerolinea = new Aerolinea(codigo, nombre, cuentaBanco);
		boolean estaAerolinea = buscarAerolineaPorNombre(nombre);
		if( !estaAerolinea )
			this.aerolineas.put( codigo, nuevaAerolinea );
		else
			throw new IllegalArgumentException(" La aerolinea ya esta ");
	}

	/**
	 * Metodo que busca una aerolinea en la lista de aerolineas
	 * dado el nombre
	 * @param nombre
	 * @return
	 */
	public boolean buscarAerolineaPorNombre( String nombre )
	{
		boolean flag = false;
		Iterator< Long > iterator = this.aerolineas.keySet().iterator();
		while ( iterator.hasNext() ) 
		{
			long key = iterator.next();
			if( this.aerolineas.get(key).getNombre().equals( nombre ) )
				flag = true;
		}
		return flag;
	}
	
	/**
	 * Metodo que retorna una aerolinea la aerolinea que concuerde con
	 * el nombre que el usuario haya pasado por parametro
	 */
	@Override
	public Aerolinea buscarAerolinea( String nombre )
	{
		Aerolinea nuevaAerolinea = null;
		Iterator< Long > iterator = this.aerolineas.keySet().iterator();
		while ( iterator.hasNext() ) 
		{
			long key = iterator.next();
			if( this.aerolineas.get(key).getNombre().equals( nombre ) )
				nuevaAerolinea = this.aerolineas.get(key);
		}
		return nuevaAerolinea;
	}
	/**
	 * Metodo que crea un vuelo planeado en el cual para el atributo de ciudad de origen y destino
	 * utilizamos el método buscarCiudadPorCodigo() para que la podamos isntaciar allí
	 */
	@Override
	public void crearVueloPlaneado( long codigoAerolinea, long codigo, String numeroVuelo, DiaSemana diaSemana, String horaSalida, String horaLlegada, int codigoOrigen, int codigoDestino ) 
	{
		Ciudad ciudadOrigen = buscarCiudadPorCodigo( codigoOrigen);
		Ciudad ciudadDestino = buscarCiudadPorCodigo( codigoDestino );
		this.aerolineas.get( codigoAerolinea ).crearVueloPlaneado( codigo, numeroVuelo, diaSemana, horaSalida, horaLlegada, ciudadOrigen, ciudadDestino );
	}

	/**
	 * Método que nos permite crear un vuelo especifico nacional
	 */
	@Override
	public void crearVueloEspecificoNacional( long codigoAerolinea, int indiceVueloPlaneado, int iva, LocalDate fecha, TipoAvion tipoAvion, int capacidad, long tarifaBasica ) 
	{
		this.aerolineas.get( codigoAerolinea ).crearVueloEspecificoNacional( indiceVueloPlaneado, iva, fecha, tipoAvion, capacidad, tarifaBasica );
	}

	/**
	 * Método que nos permite crear un vuelo especifico internacional
	 */
	@Override
	public void crearVueloEspecificoInternacional( long codigoAerolinea, int indiceVueloPlaneado, int impuestoSalida, LocalDate fecha, TipoAvion tipoAvion, int capacidad, long tarifaBasica ) 
	{
		this.aerolineas.get( codigoAerolinea ).crearVueloEspecificoInternacional( indiceVueloPlaneado, impuestoSalida, fecha, tipoAvion, capacidad, tarifaBasica );
	}
	
	/**
	 * Metodo que nos permite crear un agente y lo agrega a su lista
	 */
	@Override
	public void crearAgente( long codigo, String nombre, String email ) 
	{
		Agente nuevoAgente = new Agente(codigo, nombre, email);
		boolean estaAgente = buscarAgentePorNombre(nombre);
		if( !estaAgente )
			this.agentes.put( codigo, nuevoAgente );
		else
			throw new IllegalArgumentException(" El agente ya esta ");
		
	}

	public boolean buscarAgentePorNombre( String nombre )
	{
		boolean flag = false;
		Iterator< Long > iterator = this.agentes.keySet().iterator();
		while ( iterator.hasNext() ) 
		{
			long key = iterator.next();
			if( this.agentes.get(key).getNombre().equals( nombre ) )
				flag = true;
		}
		return flag;
	}
	
	/**
	 * Metodo que crear un itinerario para un agente en especifico
	 */
	@Override
	public void crearItinerario( long codigoAgente, String nombre ) 
	{
		this.agentes.get( codigoAgente ).crearItinerario( nombre );
		
	}
	
	/**
	 * 
	 * @param codigoAerolinea
	 * @param indiceVueloPlaneado
	 * @param indiceVueloEspecifico
	 * @return
	 */
	@Override
	public boolean verificarTipoVueloEspecificoNacional( VueloEspecifico vuelo )
	{
		boolean esNacional = false;
		
		if( vuelo instanceof VueloEspecificoNacional )
			esNacional = true;
		
		return esNacional;
	}
	
	/**
	 * Metodo que nos permite crear un trayecto para un agente y un itinerario en
	 * especifico y además, asocia un vuelo especifico
	 */
	public void crearTrayecto( long codigoAgente, int indiceItinerario, VueloEspecifico vueloEspecifico )
	{
		this.agentes.get( codigoAgente ).crearTrayecto( indiceItinerario, vueloEspecifico );
	}

	/**
	 * Metodo que permite comprar un itinerario para un pasajero Mayor
	 */
	@Override
	public void comprarItinerarioMayor( long codigoAgente, int indiceItinerario, String noIdentifiacionPasajero, String nombrePasajero, LocalDate fechaNacimiento, boolean asistencia )
	{
		this.agentes.get( codigoAgente ).comprarItinerarioMayor( indiceItinerario, noIdentifiacionPasajero, nombrePasajero, fechaNacimiento, asistencia );
	}

	/**
	 * Metodo que permite comprar un itinerario para un pasajero Mayor
	 */
	@Override
	public void comprarItinerarioMenor(long codigoAgente, int indiceItinerario, String noIdentifiacionPasajero, String nombrePasajero, LocalDate fechaNacimiento, boolean viajaSolo )
	{
		this.agentes.get( codigoAgente ).comprarItinearioMenor( indiceItinerario, noIdentifiacionPasajero, nombrePasajero, fechaNacimiento, viajaSolo );
	}

	/**
	 * Metodo que asigna una silla a un pasajero en especifico
	 */
	@Override
	public void asignarSilla(int codAgente, int indiceItinerario, String codSilla, int posicionPasajero) 
	{
		this.agentes.get(codAgente).asignarSilla(codSilla, posicionPasajero, indiceItinerario);
	}
	
	@Override
	public void tiqueteElectronico(long codigoAgente, int indiceItinerario) 
	{
		
	}
}

