package co.edu.javeriana.vuelos.presentacion;

import java.time.LocalDate;
import java.util.StringTokenizer;

public class Utils 
{
	/**
	 * Metodo utilitario el cual dado un string que representa la fecha
	 * lo convierte a LocalDate para poder ser leido en los diferentes metodos
	 * @param fecha
	 * @return
	 */
	public LocalDate fechaVuelo(String fecha )
	{
		StringTokenizer token = new StringTokenizer (fecha, "-" );
		int ano = Integer.parseInt( token.nextToken().trim() );
		int mes = Integer.parseInt( token.nextToken().trim() );
		int dia = Integer.parseInt( token.nextToken().trim() );
		return LocalDate.of(ano, mes, dia);
	}
	
	/**
	 * Metodo utilitario el cual dada una fecha verificamos si es menor de edad
	 * @param fecha
	 * @return
	 */
	public boolean verificarMenor( LocalDate fecha )
	{
		boolean esMenor = false;
		LocalDate fechaActual = LocalDate.now();
		if( ( fechaActual.getYear()-fecha.getYear() ) < 18 )
		{
			esMenor = true;
		}
		return esMenor;
	}

	/**
	 * Metodo utilitario que compara dos fechas y nos dice si una es mayor que la otra
	 * o viceversa
	 * @param fecha1
	 * @param fecha2
	 * @return
	 */
	public int compararDosFechas( LocalDate fecha1, LocalDate fecha2 )
	{
		if ( fecha1.isBefore( fecha2 ) )
			return -1;
		else if ( fecha2.isBefore( fecha1 ) )
			return 1;
		else
			return 0;
	}

}
