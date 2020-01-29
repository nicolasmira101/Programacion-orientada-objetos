package co.edu.javeriana.vuelos.negocio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que modela un vuelo especifico en el sitema
 * @author nicolasmiranda
 *
 */
public abstract class VueloEspecifico implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private static long CONSECUTIVO = 0;
	protected long codigo;
	protected long tarifa;
	protected LocalDate fecha;
	protected TipoAvion tipoAvion;
	protected int capacidad;
	protected int cuposLibres;
	private VueloPlaneado vueloPlaneado;
	private List< Trayecto > trayectos;
	private List< Silla > sillas;

	/**
	 * Constructor explicito donde se inicializan todos sus atributos
	 * @param fecha
	 * @param tipoAvion
	 * @param capacidad
	 * @param cuposLibres
	 * @param tarifa
	 */
	public VueloEspecifico( LocalDate fecha, TipoAvion tipoAvion, int capacidad, int cuposLibres, long tarifa ) 
	{
		this.codigo = CONSECUTIVO++;
		this.fecha = fecha;
		this.tipoAvion = tipoAvion;
		this.capacidad = capacidad;
		this.cuposLibres = cuposLibres;
		this.tarifa = tarifa;
		this.trayectos = new ArrayList< Trayecto >();
		this.sillas = new ArrayList< Silla >();
		crearSillas();
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

	public LocalDate getFecha() 
	{
		return fecha;
	}

	public void setFecha( LocalDate fecha ) 
	{
		this.fecha = fecha;
	}

	public TipoAvion getTipoAvion() 
	{
		return tipoAvion;
	}

	public void setTipoAvion( TipoAvion tipoAvion ) 
	{
		this.tipoAvion = tipoAvion;
	}

	public int getCapacidad() 
	{
		return capacidad;
	}

	public void setCapacidad( int capacidad ) 
	{
		this.capacidad = capacidad;
	}

	public int getCuposLibres() 
	{
		return cuposLibres;
	}

	public void setCuposLibres( int cuposLibres ) 
	{
		this.cuposLibres = cuposLibres;
	}

	public long getTarifa()
	{
		return tarifa;
	}

	public void setTarifa(long tarifa) 
	{
		this.tarifa = tarifa;
	}

	public VueloPlaneado getVueloPlaneado() 
	{
		return vueloPlaneado;
	}

	public List< Trayecto > getTrayectos() 
	{
		return trayectos;
	}

	public void setTrayectos( List< Trayecto > trayectos )
	{
		this.trayectos = trayectos;
	}

	public List< Silla > getSillas()
	{
		return sillas;
	}

	public void setSillas( List< Silla > sillas )
	{
		this.sillas = sillas;
	}

	public long calcularNumPasajesMes( int mes )
	{
		return mes;
		
	}
	
	/**
	 * Metodo que calcula el valor del pasaje dada una fecha y la tarifa
	 * @param fecha
	 * @param tarifaBasica
	 * @return
	 */
	public abstract float calcularValorPasaje( LocalDate fecha, long tarifaBasica );
	
	/**
	 * Metodo que dada una fecha verifica si el mes es junio o diciembre para determinar
	 * que es temporada alta
	 * @param fecha
	 * @return
	 */
	public boolean verificarFechaTemporadaAlta ( LocalDate fecha )
	{
		if( fecha.getMonthValue() == 6 || fecha.getMonthValue() == 12)
			return true;
		return false;
	}

	/**
	 * Este metodo genera la sillas de manera que estan marcadas de la 1A - 30E
	 * y ademas estan marcadas como no compradas en un principio
	 * @return
	 */
	private void crearSillas()
	{
		
		for ( int i = 0; i < 30; i++ )
		{
			for ( int j = 65; j < 70; j++ ) 
			{
				String id = String.valueOf( i + 1 ) + ( ( char ) j );
				boolean comprada = false;
				Silla nuevaSilla = new Silla( id,  comprada, this );
				this.sillas.add( nuevaSilla );
			}
		}
	}	
	
	@Override
	public String toString() 
	{
		return codigo + "\t" + fecha + "\t" + tipoAvion + "\t" + capacidad + "\t" + cuposLibres + "\t" + tarifa;
	}
}
