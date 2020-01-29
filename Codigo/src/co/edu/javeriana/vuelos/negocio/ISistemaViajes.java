package co.edu.javeriana.vuelos.negocio;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Interfaz del sistema que provee todos los servicios al sistema
 * @author nicolasmiranda
 *
 */
public interface ISistemaViajes 
{
	public void crearCiudad( long codigo, String nombre );
	public List< Ciudad > getCiudades();
	public void crearAerolinea( long codigo, String nombre, String cuentaBanco );
	public Map< Long, Aerolinea > getAerolineas();
	public Aerolinea buscarAerolinea( String nombre );
	public void crearVueloPlaneado( long codigoAerolinea, long codigo, String numeroVuelo, DiaSemana diaSemana, String horaSalida, String horaLlegada, int codigoOrigen, int codigoDestino );
	public void crearVueloEspecificoNacional( long codigoAerolinea, int indiceVueloPlaneado, int iva, LocalDate fecha, TipoAvion tipoAvion, int capacidad, long tarifaBasica );
	public void crearVueloEspecificoInternacional( long codigoAerolinea, int indiceVueloPlaneado, int impuestoSalida, LocalDate fecha, TipoAvion tipoAvion, int capacidad, long tarifaBasica );
	public void crearAgente( long codigo, String nombre, String email );
	public Map< Long, Agente > getAgentes();
	public void crearItinerario( long codigoAgente, String nombre );
	public void crearTrayecto( long codigoAgente, int indiceItinerario, VueloEspecifico vueloEspecifico );
	public void comprarItinerarioMayor( long codigoAgente,int indiceItinerario,String numeroIdentifiacionPasajero,String nombrePasajero,LocalDate fechaNacimiento,boolean asistencia );
	public void comprarItinerarioMenor( long codigoAgente,int indiceItinerario,String numeroIdentifiacionPasajero,String nombrePasajero,LocalDate fechaNacimiento,boolean viajaSolo );
	public void tiqueteElectronico( long codigoAgente,int indiceItinerario );
	public void asignarSilla( int codAgente,int indiceItinerario,String codSilla,int posicionPasajero );
	public boolean verificarTipoVueloEspecificoNacional( VueloEspecifico vuelo );
}
