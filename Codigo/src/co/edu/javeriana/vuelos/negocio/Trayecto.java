package co.edu.javeriana.vuelos.negocio;

import java.io.Serializable;
import java.util.*;

/**
 * Clase que modela un trayecto en el sistema
 * @author nicolasmiranda
 *
 */
public class Trayecto implements Serializable 
{ 
	private static final long serialVersionUID = 1L;
	private static int CONSECUTIVO = 0;
	private int id;
	private List< Silla > sillas;
	private VueloEspecifico vueloEspecifico;

	/**
	 * Constructor explicito donde se inicializan todos sus atributos
	 */
	public Trayecto( VueloEspecifico vueloEspecifico )
	{
		this.id = CONSECUTIVO++ ;
		this.sillas = new ArrayList< Silla >();
		this.vueloEspecifico = vueloEspecifico;
	}

	public int getCONSECUTIVO() 
	{
		return CONSECUTIVO;
	}

	public void setCONSECUTIVO( int cONSECUTIVO ) 
	{
		CONSECUTIVO = cONSECUTIVO;
	}

	public int getId() 
	{
		return id;
	}

	public void setId( int id )
	{
		this.id = id;
	}

	public List< Silla > getSillas() 
	{
		return sillas;
	}

	public void setSillas( List< Silla > sillas)
	{
		this.sillas = sillas;
	}
	
	public VueloEspecifico getVueloEspecifico()
	{
		return vueloEspecifico;
	}

	public void setVueloEspecifico( VueloEspecifico vueloEspecifico )
	{
		this.vueloEspecifico = vueloEspecifico;
	}

	public int tarifa()
	{
		return (int) this.vueloEspecifico.getTarifa();
	}
	
	/**
	 * Este metodo verifica que hayan mas cupos libres en el avion que el numero
	 * de pasajes que se desean agregar
	 * @param numeroPasajeros
	 * @return
	 */
	public boolean verificarCupo( int numeroPasajeros )
	{
		boolean flag = false;
		if( this.vueloEspecifico.getCuposLibres() > numeroPasajeros )
			flag = true;
		return flag;
	}

	@Override
	public String toString()
	{
		return " " + id;
	}
}
