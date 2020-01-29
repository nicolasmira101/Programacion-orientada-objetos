package co.edu.javeriana.vuelos.persistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;
import java.util.StringTokenizer;

import co.edu.javeriana.vuelos.negocio.Aerolinea;
import co.edu.javeriana.vuelos.negocio.Agente;
import co.edu.javeriana.vuelos.negocio.DiaSemana;
import co.edu.javeriana.vuelos.negocio.ISistemaViajes;
import co.edu.javeriana.vuelos.negocio.Itinerario;
import co.edu.javeriana.vuelos.negocio.VueloPlaneado;
import co.edu.javeriana.vuelos.negocio.VueloEspecifico;
import co.edu.javeriana.vuelos.negocio.Trayecto;
import co.edu.javeriana.vuelos.negocio.Silla;
import co.edu.javeriana.vuelos.negocio.Pasajero;
import co.edu.javeriana.vuelos.negocio.Menor;
import co.edu.javeriana.vuelos.negocio.Mayor;

/**
 * Esta clase contiene todos los metodos relacionado con la lectura y escritura
 * de archivos
 * @author Sebastian Valderrama y Nicolas Miranda
 *
 */
public class ManejoArchivos 
{	
	/**
	 * Metodo que agrega las ciudades a la lista de ciudades en sistemaVuelos
	 * @param sistema
	 * @param archivo
	 * @throws FileNotFoundException
	 */
	public static void cargarArchivoCiudades( ISistemaViajes sistema, File archivo ) throws FileNotFoundException
	{
		InputStream flujo = new FileInputStream( archivo );
		Scanner scanner = new Scanner( flujo );
		boolean esFinArchivo = false;
		while ( scanner.hasNext() &&  !esFinArchivo ) 
		{
			String linea = scanner.nextLine().trim();
			if( linea.startsWith( "0" ) )
				esFinArchivo = true;
			else
			{
				if( linea.startsWith( "#" ) || linea.isEmpty() )
					continue;
				else
				{
					StringTokenizer tokenizer = new StringTokenizer( linea, "*" );
					long codigo = Long.parseLong( tokenizer.nextToken().trim() );
					String nombre = tokenizer.nextToken().trim();
					sistema.crearCiudad( codigo, nombre);
				}
			}			
		}	
		scanner.close();
	}

	/**
	 * Metodo que agrega las aerolineas a la lista de aerolineas en sistemaVuelos
	 * @param sistema
	 * @param archivo
	 * @throws FileNotFoundException
	 */
	public static void cargarArchivoAerolineas( ISistemaViajes sistema, File archivo ) throws FileNotFoundException
	{
		InputStream flujo = new FileInputStream( archivo );
		Scanner scanner = new Scanner( flujo );
		while ( scanner.hasNext() ) 
		{
			String linea = scanner.nextLine().trim();
			while( linea.startsWith( "#" ) || linea.isEmpty() )
			{
				linea = scanner.nextLine().trim();
			}
			StringTokenizer tokenizer = new StringTokenizer( linea, "*" );
			long codigoAerolinea = Long.parseLong( tokenizer.nextToken().trim() );
			String nombreAerolinea = tokenizer.nextToken().trim();
			String cuentaBanco = tokenizer.nextToken().trim();
			sistema.crearAerolinea(codigoAerolinea, nombreAerolinea, cuentaBanco);
			linea = scanner.nextLine().trim();
			while( linea.startsWith( "#" ) || linea.isEmpty() )
			{
				linea = scanner.nextLine().trim();
			}
			while( !linea.equals("0") )
			{
				StringTokenizer tokenizerDos = new StringTokenizer( linea, "*" );
				long codigoVueloPlaneado = Long.parseLong( tokenizerDos.nextToken().trim() );
				String numeroVuelo = tokenizerDos.nextToken().trim();
				String diaSemana = tokenizerDos.nextToken().trim();
				DiaSemana diaSemanaEnumeracion = null;
				for (DiaSemana diaSemanaEnum : DiaSemana.values())
				{
					if( diaSemanaEnum.toString().equalsIgnoreCase( diaSemana ) )
						diaSemanaEnumeracion = diaSemanaEnum;			
				}
				String horaSalida = tokenizerDos.nextToken().trim();
				String horaLlegada = tokenizerDos.nextToken().trim();
				int codigoCiudadOrigen = Integer.parseInt( tokenizerDos.nextToken().trim() );
				int codigoCiudadDestino = Integer.parseInt( tokenizerDos.nextToken().trim() );
				sistema.crearVueloPlaneado( codigoAerolinea, codigoVueloPlaneado, numeroVuelo, diaSemanaEnumeracion, horaSalida, horaLlegada, codigoCiudadOrigen, codigoCiudadDestino ); 
				linea = scanner.nextLine().trim();
			}
			linea = scanner.nextLine().trim();
		}	
		scanner.close();
	}

	/**
	 * Metodo que agrega los agentes a la lista de agentes en sistemaVuelos
	 * @param sistema
	 * @param archivo
	 * @throws FileNotFoundException
	 */
	public static void cargarArchivoAgentes( ISistemaViajes sistema, File archivo ) throws FileNotFoundException
	{
		InputStream flujo = new FileInputStream( archivo );
		Scanner scanner = new Scanner( flujo );
		boolean esFinArchivo = false;
		while ( scanner.hasNext() && !esFinArchivo ) 
		{
			String linea = scanner.nextLine().trim();
			if( linea.startsWith( "0" ) )
				esFinArchivo = true;
			else
			{
				if( linea.startsWith( "#" ) || linea.isEmpty() )
					continue;
				else
				{
					StringTokenizer tokenizer = new StringTokenizer( linea, "*" );
					long codigo = Long.parseLong( tokenizer.nextToken().trim() );
					String nombre = tokenizer.nextToken().trim();
					String email= tokenizer.nextToken().trim();
					sistema.crearAgente( codigo, nombre, email) ;
				}		
			}
		}
		scanner.close();
	}

	/**
	 * Metodo que ayuda a guardar todos los datos del sistema
	 * @param negocio
	 * @param archivo
	 * @throws IOException
	 */
	public static void serializarSistemaViajes( ISistemaViajes negocio, File archivo) throws IOException
	{
		OutputStream flujo = new FileOutputStream( archivo );
		ObjectOutputStream flujoObjetos = new ObjectOutputStream(flujo);
		flujoObjetos.writeObject( negocio );
		flujoObjetos.close();
	}	

	/**
	 * Metodo que sirve para cargar el archivo del sistema que se guardo con anterioriadd
	 * @param archivo
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static ISistemaViajes deserializarSistemaViajes( File archivo) throws ClassNotFoundException, IOException
	{
		ISistemaViajes negocio;
		InputStream flujo = new FileInputStream( archivo );
		ObjectInputStream flujoObjetos = new ObjectInputStream( flujo );
		negocio = ( ISistemaViajes ) flujoObjetos.readObject();
		flujoObjetos.close();
		return negocio;
	}	

	/**
	 * Metodo que genera el reporte final en un archivo de texto con todos los datos
	 * del sistema
	 * @param sistema
	 * @param archivoReporte
	 * @throws IOException
	 */
	public static void generarReporte( ISistemaViajes sistema, File archivoReporte,Agente agente,Itinerario itinerario ) throws IOException
	{
		Writer fileWriter = null;
		BufferedWriter bufferedWriter = null;
		String tipo, ayuda;
		try 
		{
			fileWriter = new FileWriter( archivoReporte );
			bufferedWriter = new BufferedWriter( fileWriter );
			bufferedWriter.write( "Codigo" + "\t" + "nombre" );
			bufferedWriter.newLine();
			long codigo = itinerario.getCodigo();
			String nombre = itinerario.getNombre();
			bufferedWriter.write( codigo + "\t" + nombre );
			bufferedWriter.newLine();
			bufferedWriter.write( "Trayecto" );
			bufferedWriter.newLine();
			for ( Trayecto trayecto : itinerario.getTrayectos() )
			{
				bufferedWriter.write( "Id" + "\t" + "codigo" + "\t" + "fecha" );	
				bufferedWriter.newLine();
				int id = trayecto.getId();
				int codigoTrayecto = trayecto.getId();
				LocalDate fecha = trayecto.getVueloEspecifico().getFecha();
				bufferedWriter.write( id + "\t" + codigoTrayecto + "\t" + fecha );
				bufferedWriter.newLine();
				bufferedWriter.write( "Vuelo Planeado" );
				bufferedWriter.newLine();
				bufferedWriter.write( "numVuelo" + "\t" + "diaSemana" + "\t" + "horaSalida" + "\t" + "horaLlegada" + "\t" + "ciudadOrigen" + "\t" + "ciudadDestino" + "nombreAerolinea" );
				bufferedWriter.newLine();
				long codigoVueloEspecifico = trayecto.getVueloEspecifico().getCodigo();
				Collection< Aerolinea > collectionAerolinea = sistema.getAerolineas().values();
				for ( Aerolinea aerolinea : collectionAerolinea )
				{
					for ( VueloPlaneado vueloPlaneado : aerolinea.getVuelosPlaneados() )
					{
						for( VueloEspecifico vueloEspecifico : vueloPlaneado.getVuelosEspecificos() )
						{
							if( vueloEspecifico.getCodigo() == codigoVueloEspecifico )
							{
								String numVuelo = vueloPlaneado.getNumeroVuelo();
								DiaSemana diaSemana = vueloPlaneado.getDiaSemana();
								String horaSalida = vueloPlaneado.getHoraSalida();
								String horaLlegada = vueloPlaneado.getHoraLlegada();
								String ciudadOrigen = vueloPlaneado.getCiudadOrigen().getNombre();
								String ciudadDestino = vueloPlaneado.getCiudadDestino().getNombre();
								String nombreAerolinea = aerolinea.getNombre();
								bufferedWriter.write( numVuelo + "\t" + diaSemana + "\t" + horaSalida + "\t" + horaLlegada + "\t" + ciudadOrigen + "\t" + ciudadDestino + "\t" + nombreAerolinea );
								bufferedWriter.newLine();
							}
						}
					}
				}
				bufferedWriter.write( "Sillas" );
				bufferedWriter.newLine();
				bufferedWriter.write( "Id" );
				bufferedWriter.newLine();
				for ( Silla silla : trayecto.getSillas() )
				{
					String idSilla = silla.getId();
					bufferedWriter.write( idSilla );
					bufferedWriter.newLine();
				}
			}
			bufferedWriter.write( "Pasajero" );
			bufferedWriter.newLine();
			bufferedWriter.write( "Identificacion" + "\t" + "nombre" + "\t" + "fechaNacimiento" + "tipo" + "viajaSolo / asistencia" );
			bufferedWriter.newLine();
			for ( Pasajero pasajero : itinerario.getPasajeros() )
			{
				String identificacion = pasajero.getIdentificacion();
				String nombrePasajero = pasajero.getNombre();
				LocalDate fechaNacimiento = pasajero.getFechaNacimiento();
				if( pasajero instanceof Menor )
				{
					tipo = " Menor ";
					Menor pasajeroMenor = ( Menor ) pasajero;
					boolean viajaSolo = pasajeroMenor.isViajaSolo();
					if( viajaSolo )
						ayuda = "SI";
					else
						ayuda = "NO";
				}
				else
				{
					tipo = " Mayor ";
					Mayor pasajeroMayor = ( Mayor ) pasajero;
					boolean requiereAsistencia = pasajeroMayor.isRequiereAsistencia();
					if( requiereAsistencia )
						ayuda = "SI";
					else
						ayuda = "NO";
				}
				bufferedWriter.write( identificacion + "\t" + nombrePasajero + "\t" + fechaNacimiento + tipo + ayuda );
				bufferedWriter.newLine();
			}		
		}
		catch (IOException e) 
		{
			System.err.println("Error escribiendo el archivo : ");
			e.printStackTrace();
		}	
		finally 
		{
			if (bufferedWriter != null && fileWriter != null) 
			{
				try
				{
					bufferedWriter.close();
					fileWriter.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}

	}	

}
