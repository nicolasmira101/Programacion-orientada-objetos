package co.edu.javeriana.vuelos.negocio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que modela una aerolinea y contiene todos los metodos relacionados
 * con el comportamiento que realiza esta
 * @author nicolasmiranda
 *
 */
public class Aerolinea implements Serializable
{
	private static final long serialVersionUID = 1L;
	private long codigo;
	private String nombre;
	private String cuentaBanco;
	private List< VueloPlaneado > vuelosPlaneados;

	/**
	 * Constructor explicito de aerolinea donde se inicializan sus atributos
	 * @param codigo
	 * @param nombre
	 * @param cuentaBanco
	 */
	public Aerolinea( long codigo, String nombre, String cuentaBanco ) 
	{
		this.codigo = codigo;
		this.nombre = nombre;
		this.cuentaBanco = cuentaBanco;
		this.vuelosPlaneados = new ArrayList< VueloPlaneado >();
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

	public String getCuentaBanco() 
	{
		return cuentaBanco;
	}

	public void setCuentaBanco( String cuentaBanco ) 
	{
		this.cuentaBanco = cuentaBanco;
	}

	public List< VueloPlaneado > getVuelosPlaneados() 
	{
		return vuelosPlaneados;
	}

	public void setVuelosPlaneados( List< VueloPlaneado > vuelosPlaneados ) 
	{
		this.vuelosPlaneados = vuelosPlaneados;
	}
	
	/**
	 * Metodo crearVueloPlaneado el cual dado todo los atributos de un vuelo planeado
	 * instacia un nuevoVueloPlaneado y lo agrega a la lista
	 * @param codigo
	 * @param numeroVuelo
	 * @param diaSemana
	 * @param horaSalida
	 * @param horaLlegada
	 * @param origen
	 * @param destino
	 */
	public void crearVueloPlaneado( long codigo, String numeroVuelo, DiaSemana diaSemana, String horaSalida, String horaLlegada, Ciudad origen, Ciudad destino )
	{
		VueloPlaneado nuevoVueloPlaneado = new VueloPlaneado( codigo, numeroVuelo, diaSemana, horaSalida, horaLlegada, origen, destino );
		this.vuelosPlaneados.add( nuevoVueloPlaneado );
	}
	
	/**
	 * Método que crear un vuelo especifico nacional con todos sus atributos
	 * @param indiceVueloPlaneado
	 * @param iva
	 * @param fecha
	 * @param tipoAvion
	 * @param capacidad
	 * @param tarifaBasica
	 */
	public void crearVueloEspecificoNacional( int indiceVueloPlaneado, int iva, LocalDate fecha, TipoAvion tipoAvion, int capacidad, long tarifaBasica ) 
	{
		this.vuelosPlaneados.get( indiceVueloPlaneado ).crearVueloEspecificoNacional( iva, fecha, tipoAvion, capacidad, tarifaBasica );
	}

	/**
	 * Método que crea un vuelo especifico internacional con todos sus atributos
	 * @param indiceVueloPlaneado
	 * @param impuestoSalida
	 * @param fecha
	 * @param tipoAvion
	 * @param capacidad
	 * @param tarifaBasica
	 */
	public void crearVueloEspecificoInternacional( int indiceVueloPlaneado, long impuestoSalida, LocalDate fecha, TipoAvion tipoAvion, int capacidad, long tarifaBasica ) 
	{
		this.vuelosPlaneados.get( indiceVueloPlaneado ).crearVueloEspecificoInternacional( impuestoSalida, fecha, tipoAvion, capacidad, tarifaBasica );
	}

	/**
	 * Dado el codigo del vuelo planeado, el metodo busca en la lista de vuelos
	 * pleados el vuelo que concuerde y este lo retorna
	 * @param codigo
	 * @return
	 */
	public VueloPlaneado buscarVueloPlaneado( long codigo )
	{
		VueloPlaneado nuevoVueloPlaneado = null;
		for (VueloPlaneado vueloPlaneado : vuelosPlaneados)
		{
			if( vueloPlaneado.getCodigo() == codigo )
				nuevoVueloPlaneado = vueloPlaneado;
		}
		return nuevoVueloPlaneado ;
	}
	
	@Override
	public String toString()
	{
		return nombre;
	}
}
