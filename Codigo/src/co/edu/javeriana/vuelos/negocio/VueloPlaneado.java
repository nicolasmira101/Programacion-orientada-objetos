package co.edu.javeriana.vuelos.negocio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que modela un vueloPlaneado en el sistema 
 * @author nicolasmiranda
 *
 */
public class VueloPlaneado implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String numeroVuelo;
	private DiaSemana diaSemana;
	private String horaSalida;
	private String horaLlegada;
	private long codigo;
	private Ciudad ciudadOrigen;
	private Ciudad ciudadDestino;
	private Aerolinea aerolinea;
	private List< VueloEspecifico > vuelosEspecificos;

	/**
	 * Constructor explico que inicializa todos sus atributos
	 * @param codigo
	 * @param numeroVuelo
	 * @param diaSemana
	 * @param horaSalida
	 * @param horaLlegada
	 * @param ciudadOrigen
	 * @param ciudadDestino
	 */
	public VueloPlaneado( long codigo, String numeroVuelo, DiaSemana diaSemana, String horaSalida, String horaLlegada, Ciudad ciudadOrigen, Ciudad ciudadDestino ) 
	{
		this.codigo = codigo;
		this.numeroVuelo = numeroVuelo;
		this.diaSemana = diaSemana;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.ciudadOrigen=ciudadOrigen;
		this.ciudadDestino=ciudadDestino;
		this.vuelosEspecificos = new ArrayList< VueloEspecifico >();
	}

	public long getCodigo()
	{
		return codigo;
	}

	public void setCodigo( long codigo ) 
	{
		this.codigo = codigo;
	}

	public String getNumeroVuelo() 
	{
		return numeroVuelo;
	}

	public void setNumeroVuelo( String numeroVuelo )
	{
		this.numeroVuelo = numeroVuelo;
	}

	public DiaSemana getDiaSemana() 
	{
		return diaSemana;
	}

	public void setDiaSemana( DiaSemana diaSemana ) 
	{
		this.diaSemana = diaSemana;
	}

	public String getHoraSalida() 
	{
		return horaSalida;
	}

	public void setHoraSalida( String horaSalida )
	{
		this.horaSalida = horaSalida;
	}

	public String getHoraLlegada() 
	{
		return horaLlegada;
	}

	public void setHoraLlegada( String horaLlegada )
	{
		this.horaLlegada = horaLlegada;
	}

	public Ciudad getCiudadOrigen() {
		return ciudadOrigen;
	}

	public void setCiudadOrigen( Ciudad ciudadOrigen )
	{
		this.ciudadOrigen = ciudadOrigen;
	}

	public Ciudad getCiudadDestino() 
	{
		return ciudadDestino;
	}

	public void setCiudadDestino( Ciudad ciudadDestino )
	{
		this.ciudadDestino = ciudadDestino;
	}

	public Aerolinea getAerolinea()
	{
		return aerolinea;
	}

	public List< VueloEspecifico > getVuelosEspecificos() 
	{
		return vuelosEspecificos;
	}

	public void setVuelosEspecificos( List< VueloEspecifico > vuelosEspecificos )
	{
		this.vuelosEspecificos = vuelosEspecificos;
	}
	
	/**
	 * Este metodo dados los parametros de un vuelo especifico nacional agrega uno de estos
	 * y ademas inicializa la variable cupoLibres en 150 para decir que todas las sillas estan
	 * desocupadas
	 * @param iva
	 * @param fecha
	 * @param tipoAvion
	 * @param capacidad
	 * @param tarifa
	 * @return
	 */
	public void crearVueloEspecificoNacional( int iva, LocalDate fecha, TipoAvion tipoAvion, int capacidad, long tarifaBasica ) 
	{
		int cuposLibres = 150;
		VueloEspecifico nuevoVueloEspecificoNacional= new VueloEspecificoNacional( iva,fecha, tipoAvion, capacidad, cuposLibres, tarifaBasica );
		this.vuelosEspecificos.add(nuevoVueloEspecificoNacional);
	}

	/**
	 * Este metodo dados los parametros de un vuelo especifico internacional agrega uno de estos
	 * y ademas inicializa la variable cupoLibres en 150 para decir que todas las sillas estan
	 * desocupadas
	 * @param impuestoSalida
	 * @param fecha
	 * @param tipoAvion
	 * @param capacidad
	 * @param tarifa
	 * @return
	 */
	public void crearVueloEspecificoInternacional( long impuestoSalida, LocalDate fecha, TipoAvion tipoAvion, int capacidad, long tarifaBasica ) 
	{
		int cuposLibres = 150;
		VueloEspecifico nuevoVueloEspecificoInternacional = new VueloEspecificoInternacional( impuestoSalida, fecha, tipoAvion, capacidad, cuposLibres, tarifaBasica );
		this.vuelosEspecificos.add( nuevoVueloEspecificoInternacional );
	}
}
