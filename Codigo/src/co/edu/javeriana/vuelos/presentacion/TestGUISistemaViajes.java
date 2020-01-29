package co.edu.javeriana.vuelos.presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import co.edu.javeriana.vuelos.negocio.Aerolinea;
import co.edu.javeriana.vuelos.negocio.Agente;
import co.edu.javeriana.vuelos.negocio.Ciudad;
import co.edu.javeriana.vuelos.negocio.ISistemaViajes;
import co.edu.javeriana.vuelos.negocio.Itinerario;
import co.edu.javeriana.vuelos.negocio.Pasajero;
import co.edu.javeriana.vuelos.negocio.Silla;
import co.edu.javeriana.vuelos.negocio.SistemaVuelos;
import co.edu.javeriana.vuelos.negocio.TipoAvion;
import co.edu.javeriana.vuelos.negocio.Trayecto;
import co.edu.javeriana.vuelos.negocio.VueloEspecifico;
import co.edu.javeriana.vuelos.negocio.VueloEspecificoInternacional;
import co.edu.javeriana.vuelos.negocio.VueloEspecificoNacional;
import co.edu.javeriana.vuelos.negocio.VueloPlaneado;
import co.edu.javeriana.vuelos.persistencia.ManejoArchivos;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.Color;

/**
 * Clase principal que contiene toda la interfaz grafica del programa
 * @author Sebastian Valderrama & Nicolas Miranda
 *
 */
public class TestGUISistemaViajes 
{
	private ISistemaViajes sistema = new SistemaVuelos();
	private Utils utilidades = new Utils();
	private JFrame frmFrameprincipal;
	private JTextField textFieldCapacidad;
	private JTextField textFieldTarifa;
	private JTextField textFieldImpuestoIva;
	private JTextField textFieldNombreItinerario;
	private JTextField textFieldIdentificacionPasajero;
	private JTextField textFieldNombrePasajero;
	private JTable tableAerolineas;
	private JTable tableVuelosPlaneados1;
	private JTable tableVuelosPlaneados2;
	private JTable tableVuelosEspecificos;
	private JTable tableTrayectos1;
	private JTable tableTrayectos2;
	private JTable tableVuelosRequerimientos;
	private JPanel tab_servicios;
	private JPanel tab_ingresarDatos;
	private JTabbedPane tabbedPane;
	private JComboBox< Aerolinea > comboBoxAerolineas;
	private JComboBox< Agente > comboBoxAgentes;
	private JComboBox< Ciudad > comboBoxCiudadOrigen;
	private JComboBox< Ciudad > comboBoxCiudadDestino;
	private JComboBox< Agente > comboBoxSeleccionarAgente;
	private JComboBox< Agente > comboBoxAgentes2;
	private JComboBox< Agente > comboBoxAgentes3;
	private JComboBox comboBoxTipoVuelo;
	private JComboBox comboBoxAnio1;
	private JComboBox comboBoxMes1;
	private JComboBox comboBoxDia1;
	private JComboBox comboBoxTipoAvion;
	private JComboBox comboBoxAnio2;
	private JComboBox comboBoxMes2;
	private JComboBox comboBoxDia2;
	private JComboBox comboBoxSoloAsistencia;
	private JComboBox comboBoxAnio3;
	private JComboBox comboBoxMes3;
	private JComboBox comboBoxDia3;
	private JComboBox comboBoxSeleccionarItinerario;
	private JComboBox comboBoxItinerarios;
	private JComboBox comboBoxAgentes4;
	private JComboBox comboBoxItinerarios3;
	private JComboBox comboBoxFila;
	private JComboBox comboBoxPosicion;
	private JComboBox comboBoxItinerarios2;
	private JComboBox comboBoxPasajeros;
	private JScrollPane scrollPaneVuelosPlaneados1;
	private String[] columName = { "codigo", "numVuelo", "diaSemana", "hora salida/llegada", "origen", "destino" };
	private String[] columName2 = { "codigo", "aerolinea", "numeroVuelo", "hora salida/llegada", "cuposLibres", "tarifa", "tipo", "IVA/impto salida" };
	private String[] columName3 = { "nombre", "codigo", "cuentaBanco" };
	private String[] columName4 = { "codigo", "aerolinea", "numeroVuelo", "hora salida/llegada", "cuposLibres", "tarifa", "tipo", "IVA/impto salida", "valor pasaje" };
	private String[] columName5 = { "codigo trayecto", "aerolinea", "numeroVuelo", "fecha", "hora salida/llegada", "tarifa", "tipo", "IVA/impto salida"};
	private Vector columNameV;
	private Vector columNameV2;
	private Vector columNameV3;
	private Vector columNameV4;
	private Vector columNameV5;
	private Vector rowData;
	private Vector rowData2;
	private Vector rowData3;
	private Vector rowData4;
	private Vector rowData5;
	private Vector rowData6;
	private Vector rowData7;
	private JScrollPane scrollPaneVueloRequerimientos;
	private JScrollPane scrollPaneAerolinea;
	private JScrollPane scrollPaneVuelosPlaneados2;
	private JScrollPane scrollPaneVuelosEspecificos;
	private JScrollPane scrollPaneTrayectos;
	private JScrollPane scrollPaneTrayectos2;
	private JButton btnMostrarTrayectos;
	private JButton btnMostrarTrayectos2;
	private JButton btnMostrarSillasDisponibles;


	public JTabbedPane getTabbedPane() 
	{
		return tabbedPane;
	}

	public void setTabbedPane( JTabbedPane tabbedPane )
	{
		this.tabbedPane = tabbedPane;
	}

	public JTable getTableVuelosPlaneados1()
	{
		return tableVuelosPlaneados1;
	}

	public void setTableVuelosPlaneados1(JTable tableVuelosPlaneados1)
	{
		this.tableVuelosPlaneados1 = tableVuelosPlaneados1;
	}

	public JTable getTableVuelosPlaneados2() 
	{
		return tableVuelosPlaneados2;
	}

	public void setTableVuelosPlaneados2( JTable tableVuelosPlaneados2 )
	{
		this.tableVuelosPlaneados2 = tableVuelosPlaneados2;
	}

	public JTable getTableVuelosRequerimientos() 
	{
		return tableVuelosRequerimientos;
	}

	public void setTableVuelosRequerimientos( JTable tableVuelosRequerimientos)
	{
		this.tableVuelosRequerimientos = tableVuelosRequerimientos;
	}

	public JTable getTableAerolineas()
	{
		return tableAerolineas;
	}

	public void setTableAerolineas( JTable tableAerolineas )
	{
		this.tableAerolineas = tableAerolineas;
	}

	public JTable getTableVuelosEspecificos() 
	{
		return tableVuelosEspecificos;
	}

	public void setTableVuelosEspecificos( JTable tableVuelosEspecificos )
	{
		this.tableVuelosEspecificos = tableVuelosEspecificos;
	}

	public JTable getTableTrayectos1()
	{
		return tableTrayectos1;
	}

	public void setTableTrayectos1( JTable tableTrayectos1 )
	{
		this.tableTrayectos1 = tableTrayectos1;
	}

	public JTable getTableTrayectos2() 
	{
		return tableTrayectos2;
	}

	public void setTableTrayectos2( JTable tableTrayectos2 ) 
	{
		this.tableTrayectos2 = tableTrayectos2;
	}

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) 
	{
		EventQueue.invokeLater( new Runnable() 
		{
			public void run() 
			{
				try 
				{
					TestGUISistemaViajes window = new TestGUISistemaViajes();
					window.frmFrameprincipal.setVisible( true );
				}
				catch ( Exception e ) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestGUISistemaViajes() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmFrameprincipal = new JFrame();
		frmFrameprincipal.setTitle("SistemaViajes");
		this.sistema = new SistemaVuelos();
		frmFrameprincipal.setBounds( 100, 100, 800, 600 );
		frmFrameprincipal.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frmFrameprincipal.getContentPane().setLayout( new CardLayout( 0, 0 ) );

		tabbedPane = new JTabbedPane( JTabbedPane.TOP );
		frmFrameprincipal.getContentPane().add(tabbedPane, "sistemaViajes");

		JPanel tab_inicio = new JPanel();
		tabbedPane.addTab( "Inicio", null, tab_inicio, null );
		tab_inicio.setLayout( null );

		JButton btnServicios = new JButton( "Servicios" );
		btnServicios.addActionListener(new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				comboBoxTipoVuelo.addItem( "Internacional" );
				comboBoxTipoVuelo.addItem( "Nacional" );

				for ( int i = 2017 ; i < 2027 ; i++ )
				{
					comboBoxAnio1.addItem( i );	
					comboBoxAnio3.addItem( i );	
				}
				for ( int j = 1 ; j < 13 ; j++ )
				{
					comboBoxMes1.addItem( j );
					comboBoxMes2.addItem( j );
					comboBoxMes3.addItem( j );
				}
				for (int k = 1 ; k < 32 ; k++)
				{
					comboBoxDia1.addItem( k );
					comboBoxDia2.addItem( k );
					comboBoxDia3.addItem( k );
				}
				for (int l = 1900 ; l < 2017 ; l++)
				{
					comboBoxAnio2.addItem( l );
				}
				comboBoxTipoAvion.addItem( TipoAvion.AIRBUS );
				comboBoxTipoAvion.addItem( TipoAvion.BOEING );
				comboBoxTipoAvion.addItem( TipoAvion.CESSNA );
				comboBoxTipoAvion.addItem( TipoAvion.DOUGLAS );

				comboBoxSoloAsistencia.addItem( "SI" );
				comboBoxSoloAsistencia.addItem( "NO" );

				getTabbedPane().setSelectedIndex( 1 );
			}
		});
		btnServicios.setBounds( 287, 377, 240, 84 );
		tab_inicio.add( btnServicios );

		JLabel imagen_fondo = new JLabel( "" );
		imagen_fondo.setIcon( new ImageIcon(TestGUISistemaViajes.class.getResource( "/imagenes/PantallaPrincipal.png" ) ) );
		imagen_fondo.setBounds( 0, 0, 800, 517 );
		tab_inicio.add( imagen_fondo );

		tab_servicios = new JPanel();
		tabbedPane.addTab( "Menu de Servicios", null, tab_servicios, null );
		tab_servicios.setLayout( null );

		JButton btnIngresarArchivos = new JButton( "Ingresar ciudades,aerolineas,vuelos planeados y agentes" );
		btnIngresarArchivos.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e ) 
			{
				getTabbedPane().setSelectedIndex( 2 );
			}
		});
		btnIngresarArchivos.setBounds(36, 79, 309, 23);
		tab_servicios.add( btnIngresarArchivos );

		JButton btnAgregarVueloEspecifico = new JButton( "Agregar vuelo especifico" );
		btnAgregarVueloEspecifico.addActionListener(new ActionListener() 
		{
			public void actionPerformed( ActionEvent e )
			{
				getTabbedPane().setSelectedIndex( 3 ); 
			}
		});
		btnAgregarVueloEspecifico.setBounds(36, 123, 309, 23);
		tab_servicios.add( btnAgregarVueloEspecifico );

		JButton btnAgregarItinerario = new JButton( "Agregar itinerario" );
		btnAgregarItinerario.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e)
			{
				getTabbedPane().setSelectedIndex( 4 ); 
			}
		});
		btnAgregarItinerario.setBounds(36, 168, 309, 23);
		tab_servicios.add( btnAgregarItinerario );

		JButton btnAgregarTrayecto = new JButton( "Agregar trayecto a un itinerario" );
		btnAgregarTrayecto.addActionListener(new ActionListener() 
		{
			public void actionPerformed( ActionEvent e )
			{
				getTabbedPane().setSelectedIndex( 5 ); 
			}
		});
		btnAgregarTrayecto.setBounds(36, 215, 309, 23);
		tab_servicios.add( btnAgregarTrayecto );

		JButton btnMostrarAerolineas = new JButton( "Mostrar aerolineas, vuelos planeados y vuelos especif");
		btnMostrarAerolineas.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e ) 
			{
				getTabbedPane().setSelectedIndex( 6 ); 
				mostrarAerolineas( e );
			}
		});
		btnMostrarAerolineas.setBounds( 429, 79, 328, 23 );
		tab_servicios.add( btnMostrarAerolineas );

		JButton btnMostrarAgentes = new JButton( "Mostrar agentes, itineararios, y trayectos" );
		btnMostrarAgentes.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				getTabbedPane().setSelectedIndex( 7 );

			}
		});
		btnMostrarAgentes.setBounds(429, 123, 328, 23);
		tab_servicios.add( btnMostrarAgentes );

		JButton btnComprarItinerario = new JButton( "Comprar un itinerario" );
		btnComprarItinerario.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				getTabbedPane().setSelectedIndex( 8 );
			}
		});
		btnComprarItinerario.setBounds( 429, 168, 328, 23 );
		tab_servicios.add( btnComprarItinerario );

		JButton btnTiqueteElectronico = new JButton( "Generar tiquete electronico" );
		btnTiqueteElectronico.addActionListener( new ActionListener() 
		{
			public void actionPerformed( ActionEvent e )
			{
				getTabbedPane().setSelectedIndex( 9 );
			}
		});
		btnTiqueteElectronico.setBounds( 429, 215, 328, 23 );
		tab_servicios.add( btnTiqueteElectronico );

		JButton btnSalvarDatos = new JButton( "Salvar los datos del sistema" );
		btnSalvarDatos.addActionListener( new ActionListener() 
		{
			public void actionPerformed( ActionEvent e )
			{
				guardarDatos( e );
			}
		});
		btnSalvarDatos.setBounds( 296, 301, 246, 23 );
		tab_servicios.add( btnSalvarDatos );

		JButton btnCargarDatos = new JButton( "Carga los datos del sistema" );
		btnCargarDatos.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				cargarDatos( e );
			}
		});
		btnCargarDatos.setBounds( 296, 361, 246, 23 );
		tab_servicios.add( btnCargarDatos );

		tab_ingresarDatos = new JPanel();
		tabbedPane.addTab("Ingresar datos", null, tab_ingresarDatos, null);
		tab_ingresarDatos.setLayout(null);

		JLabel lblIngresarDatos = new JLabel("INGRESAR DATOS");
		lblIngresarDatos.setBounds(72, 31, 108, 53);
		tab_ingresarDatos.add(lblIngresarDatos);

		JButton btnArchivoCiudades = new JButton( "Seleccionar archivo de ciudades" );
		btnArchivoCiudades.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ingresarCiudades( e );
			}
		});
		btnArchivoCiudades.setBounds(187, 103, 328, 23);
		tab_ingresarDatos.add( btnArchivoCiudades );

		JButton btnArchivoAerolineas = new JButton( "Seleccionar archivos de aerolineas y vuelos planeados" );
		btnArchivoAerolineas.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ingresarAerolineasYVuelosPlaneados( e );
			}
		});
		btnArchivoAerolineas.setBounds(187, 155, 328, 23);
		tab_ingresarDatos.add( btnArchivoAerolineas );

		JButton btnArchivoAgentes = new JButton( "Seleccionar archivo de agentes" );
		btnArchivoAgentes.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				ingresarAgentes( e );
			}
		});
		btnArchivoAgentes.setBounds( 187, 204, 328, 23 );
		tab_ingresarDatos.add( btnArchivoAgentes );

		JButton btnRegresar1 = new JButton("Regresar");
		btnRegresar1.addActionListener(new ActionListener() 
		{
			public void actionPerformed( ActionEvent e ) 
			{
				getTabbedPane().setSelectedIndex(1);
			}
		});
		btnRegresar1.setBounds(668, 451, 89, 23);
		tab_ingresarDatos.add(btnRegresar1);

		JPanel tab_agregarVueloEspecifico = new JPanel();
		tabbedPane.addTab("Agregar vuelo especifico", null, tab_agregarVueloEspecifico, null);
		tab_agregarVueloEspecifico.setLayout(null);

		scrollPaneVuelosPlaneados1 = new JScrollPane();
		scrollPaneVuelosPlaneados1.setBounds( 160, 163, 417, 99 );
		tab_agregarVueloEspecifico.add( scrollPaneVuelosPlaneados1 );
		tableVuelosPlaneados1 = new JTable();
		scrollPaneVuelosPlaneados1.setViewportView( tableVuelosPlaneados1 );

		JLabel lblVuelosPlaneados1 = new JLabel( "Vuelos planeados de la aerolinea" );
		lblVuelosPlaneados1.setBounds( 160, 117, 172, 35 );
		tab_agregarVueloEspecifico.add( lblVuelosPlaneados1 );

		JLabel lblAerolineas1 = new JLabel( "Aerolineas" );
		lblAerolineas1.setBounds( 160, 26, 58, 22 );
		tab_agregarVueloEspecifico.add( lblAerolineas1 );

		JLabel lblDatosVueloEspecifico = new JLabel( "Datos del nuevo vuelo especifico" );
		lblDatosVueloEspecifico.setBounds( 160, 273, 172, 22 );
		tab_agregarVueloEspecifico.add( lblDatosVueloEspecifico );

		JLabel lblTipoVuelo = new JLabel( "tipo de vuelo" );
		lblTipoVuelo.setBounds( 160, 306, 90, 14 );
		tab_agregarVueloEspecifico.add( lblTipoVuelo );

		JLabel lblFechaVuelo = new JLabel( "fecha del vuelo" );
		lblFechaVuelo.setBounds( 160, 331, 90, 14 );
		tab_agregarVueloEspecifico.add( lblFechaVuelo );

		JLabel lblTipoAvion = new JLabel( "tipo de avion" );
		lblTipoAvion.setBounds( 160, 356, 76, 14 );
		tab_agregarVueloEspecifico.add( lblTipoAvion );

		JLabel lblCapacidad = new JLabel( "capacidad" );
		lblCapacidad.setBounds( 160, 381, 76, 14 );
		tab_agregarVueloEspecifico.add( lblCapacidad );

		JLabel lblTarifa = new JLabel( "tarifa basica" );
		lblTarifa.setBounds( 160, 406, 90, 14 );
		tab_agregarVueloEspecifico.add( lblTarifa );

		JLabel lblImpuestoIva = new JLabel( "impuesto salida/IVA" );
		lblImpuestoIva.setBounds( 160, 431, 106, 14 );
		tab_agregarVueloEspecifico.add( lblImpuestoIva );

		JButton btnMostrarVuelosPlaneados = new JButton("Mostrar Vuelos Planeados");
		btnMostrarVuelosPlaneados.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				mostrarVuelosPlaneados( e );
			}
		});
		btnMostrarVuelosPlaneados.setBounds(267, 66, 172, 35);
		tab_agregarVueloEspecifico.add(btnMostrarVuelosPlaneados);

		JButton btnRegistrarVueloEspecifico = new JButton( "Registrar vuelo especifico" );
		btnRegistrarVueloEspecifico.addActionListener( new ActionListener() 
		{
			public void actionPerformed( ActionEvent e )
			{
				regitrarVuelosEspecificos( e );

			}
		});
		btnRegistrarVueloEspecifico.setBounds(570, 406, 188, 61);
		tab_agregarVueloEspecifico.add(btnRegistrarVueloEspecifico);

		JButton btnRegresar2 = new JButton("Regresar");
		btnRegresar2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				getTabbedPane().setSelectedIndex(1);
			}
		});
		btnRegresar2.setBounds(633, 478, 89, 23);
		tab_agregarVueloEspecifico.add(btnRegresar2);

		comboBoxAerolineas = new JComboBox< Aerolinea >( );

		comboBoxAerolineas.setBounds(267, 20, 172, 35);
		tab_agregarVueloEspecifico.add(comboBoxAerolineas);

		comboBoxTipoVuelo = new JComboBox();
		comboBoxTipoVuelo.setBounds(293, 303, 172, 17);
		tab_agregarVueloEspecifico.add(comboBoxTipoVuelo);

		comboBoxAnio1 = new JComboBox();
		comboBoxAnio1.setBounds(293, 328, 58, 22);
		tab_agregarVueloEspecifico.add(comboBoxAnio1);

		comboBoxMes1 = new JComboBox();
		comboBoxMes1.setBounds(361, 328, 43, 22);
		tab_agregarVueloEspecifico.add(comboBoxMes1);

		comboBoxDia1 = new JComboBox();
		comboBoxDia1.setBounds(414, 328, 43, 22);
		tab_agregarVueloEspecifico.add(comboBoxDia1);

		comboBoxTipoAvion = new JComboBox();
		comboBoxTipoAvion.setBounds(294, 356, 171, 22);
		tab_agregarVueloEspecifico.add(comboBoxTipoAvion);

		textFieldCapacidad = new JTextField();
		textFieldCapacidad.setBounds(293, 381, 172, 20);
		tab_agregarVueloEspecifico.add(textFieldCapacidad);
		textFieldCapacidad.setColumns(10);

		textFieldTarifa = new JTextField();
		textFieldTarifa.setBounds(293, 403, 172, 20);
		tab_agregarVueloEspecifico.add(textFieldTarifa);
		textFieldTarifa.setColumns(10);

		textFieldImpuestoIva = new JTextField();
		textFieldImpuestoIva.setBounds(293, 428, 172, 20);
		tab_agregarVueloEspecifico.add(textFieldImpuestoIva);
		textFieldImpuestoIva.setColumns(10);

		JPanel tab_agregarItinerario = new JPanel();
		tabbedPane.addTab("Agregar itinerario", null, tab_agregarItinerario, null);
		tab_agregarItinerario.setLayout(null);

		JLabel lblAgentes = new JLabel("Agentes");
		lblAgentes.setBounds(94, 35, 46, 14);
		tab_agregarItinerario.add(lblAgentes);

		JButton btnRegistrarItinerario = new JButton( "Registrar itinerario" );
		btnRegistrarItinerario.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e ) 
			{
				registrarItinerario( e );
			}
		});
		btnRegistrarItinerario.setBounds(283, 130, 132, 23);
		tab_agregarItinerario.add( btnRegistrarItinerario );

		JLabel lblNombreItinerario = new JLabel("nombre del nuevo itinerario");
		lblNombreItinerario.setBounds(94, 102, 142, 14);
		tab_agregarItinerario.add(lblNombreItinerario);

		JLabel lblDatosPasajero = new JLabel("Datos de un pasajero del itinerario");
		lblDatosPasajero.setBounds(94, 147, 241, 31);
		tab_agregarItinerario.add(lblDatosPasajero);

		JLabel lblIdentificacion = new JLabel("Identificacion");
		lblIdentificacion.setBounds(94, 189, 89, 14);
		tab_agregarItinerario.add(lblIdentificacion);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(94, 227, 46, 14);
		tab_agregarItinerario.add(lblNombre);

		JLabel lblFecha = new JLabel("fecha de nacimiento");
		lblFecha.setBounds(94, 271, 106, 14);
		tab_agregarItinerario.add(lblFecha);

		JLabel lblSoloAsistencia = new JLabel("viaja solo/requiere asistencia");
		lblSoloAsistencia.setBounds(94, 310, 154, 14);
		tab_agregarItinerario.add(lblSoloAsistencia);

		JButton btnRegistrarPasajero = new JButton( "Registrar pasajero" );
		btnRegistrarPasajero.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				registrarPasajero( e );
			}
		});
		btnRegistrarPasajero.setBounds(277, 368, 154, 23);
		tab_agregarItinerario.add(btnRegistrarPasajero);

		JButton btnRegresar3 = new JButton("Regresar");
		btnRegresar3.addActionListener(new ActionListener()
		{
			public void actionPerformed( ActionEvent e ) 
			{
				getTabbedPane().setSelectedIndex( 1);
			}
		});
		btnRegresar3.setBounds( 513, 470, 89, 23 );
		tab_agregarItinerario.add( btnRegresar3 );

		comboBoxAgentes = new JComboBox();
		comboBoxAgentes.setBounds(178, 32, 253, 31);
		tab_agregarItinerario.add(comboBoxAgentes);

		comboBoxAnio2 = new JComboBox();
		comboBoxAnio2.setBounds(249, 268, 61, 20);
		tab_agregarItinerario.add(comboBoxAnio2);

		comboBoxMes2 = new JComboBox();
		comboBoxMes2.setBounds(320, 268, 57, 20);
		tab_agregarItinerario.add(comboBoxMes2);

		comboBoxDia2 = new JComboBox();
		comboBoxDia2.setBounds(387, 268, 60, 20);
		tab_agregarItinerario.add(comboBoxDia2);

		comboBoxSoloAsistencia = new JComboBox();
		comboBoxSoloAsistencia.setBounds(252, 307, 130, 20);
		tab_agregarItinerario.add(comboBoxSoloAsistencia);

		textFieldNombreItinerario = new JTextField();
		textFieldNombreItinerario.setBounds(273, 99, 142, 20);
		tab_agregarItinerario.add(textFieldNombreItinerario);
		textFieldNombreItinerario.setColumns(10);

		textFieldIdentificacionPasajero = new JTextField();
		textFieldIdentificacionPasajero.setBounds(249, 186, 133, 20);
		tab_agregarItinerario.add(textFieldIdentificacionPasajero);
		textFieldIdentificacionPasajero.setColumns(10);

		textFieldNombrePasajero = new JTextField();
		textFieldNombrePasajero.setBounds(249, 224, 133, 20);
		tab_agregarItinerario.add(textFieldNombrePasajero);
		textFieldNombrePasajero.setColumns(10);

		JPanel tab_agregarTrayectoItinerario = new JPanel();
		tabbedPane.addTab("Agregar trayecto a un itinerario", null, tab_agregarTrayectoItinerario, null);
		tab_agregarTrayectoItinerario.setLayout(null);

		scrollPaneVueloRequerimientos = new JScrollPane();
		scrollPaneVueloRequerimientos.setBounds(63, 207, 649, 109);
		tab_agregarTrayectoItinerario.add(scrollPaneVueloRequerimientos);
		tableVuelosRequerimientos = new JTable();
		scrollPaneVueloRequerimientos.setViewportView( tableVuelosRequerimientos );

		tableVuelosRequerimientos = new JTable();
		rowData2 = new Vector();
		columNameV2 = new Vector( Arrays.asList( this.columName2 ) );
		DefaultTableModel dtm2 = new DefaultTableModel( rowData2, columNameV2 );

		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setBounds(172, 23, 46, 14);
		tab_agregarTrayectoItinerario.add(lblOrigen);

		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setBounds(172, 62, 46, 14);
		tab_agregarTrayectoItinerario.add(lblDestino);

		JLabel lblFechaSalida = new JLabel("Fecha Salida");
		lblFechaSalida.setBounds(172, 98, 66, 14);
		tab_agregarTrayectoItinerario.add(lblFechaSalida);

		JLabel lblVuelosRequerimientos = new JLabel("Vuelos que cumplen requerimientos");
		lblVuelosRequerimientos.setBounds(172, 172, 199, 14);
		tab_agregarTrayectoItinerario.add(lblVuelosRequerimientos);

		JLabel lblSeleccionarAgente = new JLabel("Seleccionar Agente");
		lblSeleccionarAgente.setBounds(172, 342, 117, 14);
		tab_agregarTrayectoItinerario.add(lblSeleccionarAgente);

		JLabel lblSeleccionarItinerario = new JLabel("Seleccionar Itinerario");
		lblSeleccionarItinerario.setBounds(172, 384, 101, 14);
		tab_agregarTrayectoItinerario.add(lblSeleccionarItinerario);

		JButton btnMostrarAlternativas = new JButton("Mostrar Alternativas");
		btnMostrarAlternativas.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				mostrarAlternativas( e );
			}
		});
		btnMostrarAlternativas.setBounds(255, 138, 146, 23);
		tab_agregarTrayectoItinerario.add(btnMostrarAlternativas);

		JButton btnRegistrarTrayecto = new JButton("Registrar Trayecto");
		btnRegistrarTrayecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarTrayectoParaUnItinerario();
			}
		});
		btnRegistrarTrayecto.setBounds(172, 435, 134, 23);
		tab_agregarTrayectoItinerario.add(btnRegistrarTrayecto);

		JButton btnRegresar4 = new JButton("Regresar");
		btnRegresar4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getTabbedPane().setSelectedIndex(1);
			}
		});
		btnRegresar4.setBounds(473, 435, 89, 23);
		tab_agregarTrayectoItinerario.add(btnRegresar4);

		comboBoxCiudadOrigen = new JComboBox();
		comboBoxCiudadOrigen.setBounds(278, 22, 134, 17);
		tab_agregarTrayectoItinerario.add(comboBoxCiudadOrigen);

		comboBoxCiudadDestino = new JComboBox();
		comboBoxCiudadDestino.setBounds(278, 59, 134, 20);
		tab_agregarTrayectoItinerario.add(comboBoxCiudadDestino);

		comboBoxAnio3 = new JComboBox();
		comboBoxAnio3.setBounds(278, 97, 66, 17);
		tab_agregarTrayectoItinerario.add(comboBoxAnio3);

		comboBoxMes3 = new JComboBox();
		comboBoxMes3.setBounds(366, 97, 35, 17);
		tab_agregarTrayectoItinerario.add(comboBoxMes3);

		comboBoxDia3 = new JComboBox();
		comboBoxDia3.setBounds(421, 97, 46, 17);
		tab_agregarTrayectoItinerario.add(comboBoxDia3);

		comboBoxSeleccionarAgente = new JComboBox();
		comboBoxSeleccionarAgente.setBounds(299, 339, 186, 17);
		tab_agregarTrayectoItinerario.add(comboBoxSeleccionarAgente);
		comboBoxSeleccionarAgente.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				rellenarcomboBoxItinerario((Agente)comboBoxSeleccionarAgente.getSelectedItem());
			}
		});

		comboBoxSeleccionarItinerario = new JComboBox();
		comboBoxSeleccionarItinerario.setBounds(299, 381, 186, 17);
		tab_agregarTrayectoItinerario.add(comboBoxSeleccionarItinerario);

		tableVuelosPlaneados1 = new JTable();
		rowData=new Vector();
		columNameV=new Vector(Arrays.asList(this.columName));
		DefaultTableModel dtm1 = new DefaultTableModel(rowData, columNameV);

		JPanel tab_reporteAerolinea = new JPanel();
		tabbedPane.addTab("Reporte aerolineas", null, tab_reporteAerolinea, null);
		tabbedPane.setBackgroundAt(6, Color.WHITE);
		tab_reporteAerolinea.setLayout(null);

		scrollPaneAerolinea = new JScrollPane();
		scrollPaneAerolinea.setBounds(70, 36, 637, 82);
		tab_reporteAerolinea.add(scrollPaneAerolinea);

		tableAerolineas = new JTable();
		rowData3 = new Vector();
		columNameV3 = new Vector(Arrays.asList( this.columName3 ));
		DefaultTableModel dtm3 = new DefaultTableModel( rowData3, columNameV3 );
		scrollPaneAerolinea.setViewportView( tableAerolineas );

		scrollPaneVuelosPlaneados2 = new JScrollPane();
		scrollPaneVuelosPlaneados2.setBounds(70, 192, 637, 82);
		tab_reporteAerolinea.add( scrollPaneVuelosPlaneados2 );

		tableVuelosPlaneados2 = new JTable();
		rowData4 = new Vector();
		columNameV = new Vector(Arrays.asList( this.columName ));
		DefaultTableModel dtm4 = new DefaultTableModel( rowData4, columNameV );
		scrollPaneVuelosPlaneados2.setViewportView( tableVuelosPlaneados2 );

		scrollPaneVuelosEspecificos = new JScrollPane();
		scrollPaneVuelosEspecificos.setBounds(70, 347, 637, 112);
		tab_reporteAerolinea.add(scrollPaneVuelosEspecificos);

		tableVuelosEspecificos = new JTable();
		rowData5 = new Vector();
		columNameV4 = new Vector( Arrays.asList( this.columName4 ) );
		DefaultTableModel dtm5 = new DefaultTableModel( rowData5, columNameV4 );
		scrollPaneVuelosEspecificos.setViewportView( tableVuelosEspecificos );

		JLabel lblAerolineas2 = new JLabel("Aerolineas");
		lblAerolineas2.setBounds(70, 11, 63, 14);
		tab_reporteAerolinea.add(lblAerolineas2);

		JLabel lblVuelosPlaneados2 = new JLabel("Vuelos Planeados de la Aerolinea");
		lblVuelosPlaneados2.setBounds(70, 157, 178, 14);
		tab_reporteAerolinea.add(lblVuelosPlaneados2);

		JLabel lblVuelosEspecificos = new JLabel("Vuelos Espec\u00EDficos");
		lblVuelosEspecificos.setBounds(70, 322, 109, 14);
		tab_reporteAerolinea.add(lblVuelosEspecificos);

		JButton btnMostrarVuelosPlaneados2 = new JButton("Mostrar Vuelos Planeados");
		btnMostrarVuelosPlaneados2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mostrarVuelosPlaneadosReporte( e );
			}
		});
		btnMostrarVuelosPlaneados2.setBounds(362, 129, 168, 23);
		tab_reporteAerolinea.add(btnMostrarVuelosPlaneados2);

		JButton btnMostrarVuelosEspecificos = new JButton("Mostrar Vuelos Especificos");
		btnMostrarVuelosEspecificos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				mostrarVuelosEspecificos( e );
			}
		});
		btnMostrarVuelosEspecificos.setBounds(362, 285, 168, 23);
		tab_reporteAerolinea.add(btnMostrarVuelosEspecificos);

		JButton btnRegresar5 = new JButton("Regresar");
		btnRegresar5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				DefaultTableModel dtm = new DefaultTableModel( rowData3, columNameV3 );
				for (int i = 0; i < rowData3.size(); i++) 
				{
					dtm.removeRow( i );
				}
				dtm = ( DefaultTableModel )tableAerolineas.getModel();
				dtm.setRowCount( 0 );

				DefaultTableModel dtm1 = new DefaultTableModel( rowData4, columNameV );
				for (int j = 0; j < rowData4.size(); j++) 
				{
					dtm1.removeRow( j );
				}
				dtm1 = ( DefaultTableModel )tableVuelosPlaneados2.getModel();
				dtm1.setRowCount( 0 );
				
				DefaultTableModel dt = new DefaultTableModel( rowData5, columNameV4 );
				for (int i = 0; i < rowData5.size(); i++) 
				{
					dt.removeRow(i);
				}
				dt = ( DefaultTableModel )tableVuelosEspecificos.getModel();
				dt.setRowCount( 0 );

				getTabbedPane().setSelectedIndex(1);
			}
		});
		btnRegresar5.setBounds(668, 483, 89, 23);
		tab_reporteAerolinea.add(btnRegresar5);

		JPanel tab_reporteAgentes = new JPanel();
		tabbedPane.addTab("Reporte agentes", null, tab_reporteAgentes, null);
		tab_reporteAgentes.setLayout(null);

		scrollPaneTrayectos = new JScrollPane();
		scrollPaneTrayectos.setBounds(47, 198, 675, 156);
		tab_reporteAgentes.add(scrollPaneTrayectos);

		tableTrayectos1 = new JTable();
		rowData6 = new Vector();
		columNameV5 = new Vector( Arrays.asList( this.columName5 ) );
		DefaultTableModel dtm6 = new DefaultTableModel( rowData6, columNameV5 );
		scrollPaneTrayectos.setViewportView( tableTrayectos1 );

		JLabel lblAgentes2 = new JLabel("Agentes");
		lblAgentes2.setBounds(226, 11, 46, 14);
		tab_reporteAgentes.add(lblAgentes2);

		JLabel lblItinerarios = new JLabel("Itinerarios");
		lblItinerarios.setBounds(226, 55, 65, 14);
		tab_reporteAgentes.add(lblItinerarios);

		JLabel lblTrayectos = new JLabel("Trayectos");
		lblTrayectos.setBounds(50, 166, 65, 14);
		tab_reporteAgentes.add(lblTrayectos);

		btnMostrarTrayectos = new JButton("Mostrar Trayectos");
		btnMostrarTrayectos.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				mostrarTrayectos( e );
			}
		});
		btnMostrarTrayectos.setBounds(320, 114, 212, 23);
		tab_reporteAgentes.add(btnMostrarTrayectos);

		JButton btnRegresar6 = new JButton("Regresar");
		btnRegresar6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				DefaultTableModel dtm = new DefaultTableModel( rowData7, columNameV5 );
				for (int i = 0; i < rowData7.size(); i++) 
				{
					dtm.removeRow(i);
				}
				dtm = ( DefaultTableModel )tableTrayectos1.getModel();
				dtm.setRowCount( 0 );
				getTabbedPane().setSelectedIndex(1);
			}
		});
		btnRegresar6.setBounds(633, 448, 89, 23);
		tab_reporteAgentes.add(btnRegresar6);

		comboBoxAgentes2 = new JComboBox();
		comboBoxAgentes2.setBounds(320, 11, 242, 20);
		tab_reporteAgentes.add(comboBoxAgentes2);
		comboBoxAgentes2.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				rellenarcomboBoxItinerario2((Agente)comboBoxAgentes2.getSelectedItem());
			}
		});

		comboBoxItinerarios = new JComboBox();
		comboBoxItinerarios.setBounds(320, 52, 242, 20);
		tab_reporteAgentes.add(comboBoxItinerarios);

		JPanel tab_comprarItinerario = new JPanel();
		tabbedPane.addTab("Comprar itinerario", null, tab_comprarItinerario, null);
		tab_comprarItinerario.setLayout(null);

		scrollPaneTrayectos2 = new JScrollPane();
		scrollPaneTrayectos2.setBounds(36, 212, 698, 108);
		tab_comprarItinerario.add(scrollPaneTrayectos2);

		tableTrayectos2 = new JTable();
		rowData7 = new Vector();
		columNameV5 = new Vector( Arrays.asList( this.columName5 ) );
		DefaultTableModel dtm7 = new DefaultTableModel( rowData7, columNameV5 );
		scrollPaneTrayectos2.setViewportView(tableTrayectos2);

		JLabel lblAgentes3 = new JLabel("Agentes");
		lblAgentes3.setBounds(158, 11, 66, 14);
		tab_comprarItinerario.add(lblAgentes3);

		JLabel lblItinerarios2 = new JLabel("Itinerarios");
		lblItinerarios2.setBounds(158, 55, 66, 14);
		tab_comprarItinerario.add(lblItinerarios2);

		JLabel lblPasajeros = new JLabel("Pasajeros");
		lblPasajeros.setBounds(158, 94, 66, 14);
		tab_comprarItinerario.add(lblPasajeros);

		JLabel lblTrayectos2 = new JLabel("Trayectos");
		lblTrayectos2.setBounds(36, 187, 66, 14);
		tab_comprarItinerario.add(lblTrayectos2);

		JLabel lblSeleccionarSilla = new JLabel("Seleccione una silla");
		lblSeleccionarSilla.setBounds(238, 384, 105, 14);
		tab_comprarItinerario.add(lblSeleccionarSilla);

		JLabel lblFila = new JLabel("Fila");
		lblFila.setBounds(353, 365, 46, 14);
		tab_comprarItinerario.add(lblFila);

		JLabel lblPosicion = new JLabel("Posicion");
		lblPosicion.setBounds(440, 365, 46, 14);
		tab_comprarItinerario.add(lblPosicion);

		btnMostrarTrayectos2 = new JButton("Mostrar trayectos");
		btnMostrarTrayectos2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				mostrarTrayectosComprarItinerario( e );
			}
		});
		btnMostrarTrayectos2.setBounds(255, 138, 164, 23);
		tab_comprarItinerario.add(btnMostrarTrayectos2);

		btnMostrarSillasDisponibles = new JButton("Mostrar sillas disponibles");
		btnMostrarSillasDisponibles.addActionListener(new ActionListener() 
		{
			public void actionPerformed( ActionEvent e ) 
			{
				mostrarSillasDisponibles( e );
			}
		});
		btnMostrarSillasDisponibles.setBounds(326, 331, 164, 23);
		tab_comprarItinerario.add(btnMostrarSillasDisponibles);

		JButton btnRegistrarSilla = new JButton("Registrar Silla");
		btnRegistrarSilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarSilla(e);
			}
		});
		btnRegistrarSilla.setBounds(279, 448, 120, 23);
		tab_comprarItinerario.add(btnRegistrarSilla);

		JButton btnRegresar7 = new JButton("Regresar");
		btnRegresar7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getTabbedPane().setSelectedIndex(1);
			}
		});
		btnRegresar7.setBounds(665, 448, 89, 23);
		tab_comprarItinerario.add(btnRegresar7);

		comboBoxAgentes3 = new JComboBox();
		comboBoxAgentes3.setBounds(248, 7, 193, 23);
		tab_comprarItinerario.add(comboBoxAgentes3);
		comboBoxAgentes3.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				rellenarcomboBoxItinerario3((Agente)comboBoxAgentes3.getSelectedItem());
			}
		});

		comboBoxItinerarios2 = new JComboBox();
		comboBoxItinerarios2.setBounds(248, 51, 193, 23);
		tab_comprarItinerario.add(comboBoxItinerarios2);
		comboBoxItinerarios2.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				rellenarcomboBoxPasajero((Itinerario)comboBoxItinerarios2.getSelectedItem());
			}
		});

		comboBoxPasajeros = new JComboBox();
		comboBoxPasajeros.setBounds(248, 90, 193, 23);
		tab_comprarItinerario.add(comboBoxPasajeros);

		comboBoxFila = new JComboBox();
		comboBoxFila.setBounds(353, 380, 66, 23);
		tab_comprarItinerario.add(comboBoxFila);
		comboBoxFila.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rellenarComboBoxPosicion();

			}
		});

		comboBoxPosicion = new JComboBox();
		comboBoxPosicion.setBounds(440, 380, 58, 23);
		tab_comprarItinerario.add(comboBoxPosicion);

		JPanel tab_generarTiqueteElectronico = new JPanel();
		tabbedPane.addTab("Generar tiquete electronico", null, tab_generarTiqueteElectronico, null);
		tab_generarTiqueteElectronico.setLayout(null);

		JLabel lblAgentes4 = new JLabel("Agentes");
		lblAgentes4.setBounds(163, 52, 46, 14);
		tab_generarTiqueteElectronico.add(lblAgentes4);

		JLabel lblItinerarios3 = new JLabel("Itinerarios");
		lblItinerarios3.setBounds(163, 96, 65, 14);
		tab_generarTiqueteElectronico.add(lblItinerarios3);

		JButton btnGenerarTiquete = new JButton("Generar Tiquete");
		btnGenerarTiquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarTiquete(e);
			}
		});
		btnGenerarTiquete.setBounds(254, 139, 161, 23);
		tab_generarTiqueteElectronico.add(btnGenerarTiquete);

		JButton btnRegresar8 = new JButton("Regresar");
		btnRegresar8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getTabbedPane().setSelectedIndex(1);
			}
		});
		btnRegresar8.setBounds(539, 448, 89, 23);
		tab_generarTiqueteElectronico.add(btnRegresar8);

		comboBoxAgentes4 = new JComboBox();
		comboBoxAgentes4.setBounds(244, 49, 171, 20);
		comboBoxAgentes4.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				rellenarcomboBoxItinerario4((Agente)comboBoxAgentes4.getSelectedItem());
			}
		});
		tab_generarTiqueteElectronico.add(comboBoxAgentes4);

		comboBoxItinerarios3 = new JComboBox();
		comboBoxItinerarios3.setBounds(244, 93, 172, 20);
		tab_generarTiqueteElectronico.add(comboBoxItinerarios3);
	}

	/**
	 *Metodo que sirve para ingresar las ciudades al sistema mediante GUI
	 *utilizando JfileChosoer, y en caso de ocurrir algo no deseado muestra
	 *su respectiva excepcion en un JDialog
	 * @param e
	 */
	private void ingresarCiudades( ActionEvent e )
	{
		try
		{
			JFileChooser chooser = new JFileChooser( new File(".").getCanonicalPath() );
			FileFilter filtroDeArchivos = new FileNameExtensionFilter( "Archivo Ciudades", "txt" ); 
			chooser.setFileFilter( filtroDeArchivos );
			chooser.setAcceptAllFileFilterUsed( false );
			int resultado = chooser.showOpenDialog( frmFrameprincipal );
			if (resultado == JFileChooser.APPROVE_OPTION) 
			{
				File archivo = chooser.getSelectedFile();					
				ManejoArchivos.cargarArchivoCiudades(sistema, archivo);
				JOptionPane.showMessageDialog(frmFrameprincipal, "Archivo de  ciudades cargado satisfactoriamente.");
				for ( Ciudad ciudad : sistema.getCiudades())
				{
					comboBoxCiudadOrigen.addItem( ciudad );
					comboBoxCiudadDestino.addItem( ciudad );
				}

			}
		}
		catch ( Exception exp )
		{
			JOptionPane.showMessageDialog(frmFrameprincipal, "Error cargando ciudades:\n" + exp, "Error", JOptionPane.ERROR_MESSAGE);
			exp.printStackTrace();
		}
	}

	/**
	 *Metodo que sirve para ingresar las aerolienas y vuelos planeados al sistema 
	 *mediante GUI, utilizando JfileChosoer, y en caso de ocurrir algo no deseado
	 * muestra su respectiva excepcion en un JDialog
	 * @param e
	 */
	private void ingresarAerolineasYVuelosPlaneados( ActionEvent e )
	{
		try
		{
			JFileChooser chooser = new JFileChooser(new File(".").getCanonicalPath());

			FileFilter filtroDeArchivos = new FileNameExtensionFilter( "Archivo Aerolineas", "txt" ); 
			chooser.setFileFilter(filtroDeArchivos);
			chooser.setAcceptAllFileFilterUsed(false);
			int resultado = chooser.showOpenDialog( frmFrameprincipal );
			if ( resultado == JFileChooser.APPROVE_OPTION ) 
			{
				File archivo = chooser.getSelectedFile();					
				ManejoArchivos.cargarArchivoAerolineas(sistema, archivo);
				JOptionPane.showMessageDialog( frmFrameprincipal, "archivo de  aerolineas cargado satisfactoriamente." );
				Collection< Aerolinea > collectionAerolinea = sistema.getAerolineas().values();
				for ( Aerolinea aerolinea : collectionAerolinea )
				{
					comboBoxAerolineas.addItem( aerolinea );
				}
			}
		}
		catch (Exception exp)
		{
			JOptionPane.showMessageDialog( frmFrameprincipal, "Error cargando aerolineas:\n"+exp, "Error", JOptionPane.ERROR_MESSAGE );
			exp.printStackTrace();
		}
	}

	/**
	 *Metodo que sirve para ingresar los agentes al sistema mediante GUI
	 *utilizando JfileChosoer, y en caso de ocurrir algo no deseado muestra
	 *su respectiva excepcion en un JDialog
	 * @param e
	 */
	private void ingresarAgentes( ActionEvent e )
	{
		try
		{
			JFileChooser chooser = new JFileChooser(new File(".").getCanonicalPath());
			FileFilter filtroDeArchivos = new FileNameExtensionFilter( "Archivo Agentes", "txt" ); 
			chooser.setFileFilter( filtroDeArchivos );
			chooser.setAcceptAllFileFilterUsed( false );
			int resultado = chooser.showOpenDialog( frmFrameprincipal );
			if (resultado == JFileChooser.APPROVE_OPTION) 
			{
				File archivo = chooser.getSelectedFile();					
				ManejoArchivos.cargarArchivoAgentes( sistema, archivo );
				JOptionPane.showMessageDialog( frmFrameprincipal, "archivo de  agentes cargado satisfactoriamente." );
				Collection< Agente > collectionAgente = sistema.getAgentes().values();
				for ( Agente agente : collectionAgente )
				{
					comboBoxAgentes.addItem( agente );
					comboBoxSeleccionarAgente.addItem( agente );
					comboBoxAgentes2.addItem( agente );
					comboBoxAgentes3.addItem( agente );
					comboBoxAgentes4.addItem( agente );
				}
			}
		}
		catch (Exception exp)
		{
			JOptionPane.showMessageDialog(frmFrameprincipal, "Error cargando agentes:\n"+exp, "Error", JOptionPane.ERROR_MESSAGE);
			exp.printStackTrace();
		}
	}

	/**
	 * Metodo que muestra los vuelos planeados que estan asociados
	 * a una aerolinea, estos, los muestra en un JTable que se va
	 * refrescando cada vez que el usuario seleccione una aerolinea
	 * diferente
	 * @param e
	 */
	private void mostrarVuelosPlaneados( ActionEvent e)
	{
		try {
			DefaultTableModel dt = new DefaultTableModel( rowData, columNameV );
			for (int i = 0; i < rowData.size(); i++) 
			{
				dt.removeRow(i);
			}
			dt = ( DefaultTableModel )tableVuelosPlaneados1.getModel();
			dt.setRowCount( 0 );
			Aerolinea nuevaAerolinea= (Aerolinea) this.comboBoxAerolineas.getSelectedItem();
			for(VueloPlaneado vuelo: nuevaAerolinea.getVuelosPlaneados())
			{
				Vector fila = new Vector();
				fila.add( vuelo.getCodigo() );
				fila.add( vuelo.getNumeroVuelo() );
				fila.add( vuelo.getDiaSemana() );
				fila.add( vuelo.getHoraSalida() + "/" + vuelo.getHoraLlegada() );
				fila.add( vuelo.getCiudadOrigen().getNombre() );
				fila.add( vuelo.getCiudadDestino().getNombre() );
				rowData.add( fila );
			}
			DefaultTableModel dtm = new DefaultTableModel( rowData, columNameV );
			this.tableVuelosPlaneados1=new JTable(dtm);
			scrollPaneVuelosPlaneados1.setViewportView( getTableVuelosPlaneados1() );
			
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(frmFrameprincipal, "Error refrescando tabla agentes:\n"+e2, "Error", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		
		}	
	}

	/**
	 * Metodo que registra un vuelo especifico 
	 * @param e
	 */
	private void regitrarVuelosEspecificos( ActionEvent e )
	{
		try 
		{
			Aerolinea nuevaAerolinea = (Aerolinea) this.comboBoxAerolineas.getSelectedItem();
			int codigoFila = this.tableVuelosPlaneados1.getSelectedRow();
			int anio = (int) this.comboBoxAnio1.getSelectedItem();
			int mes = (int) this.comboBoxMes1.getSelectedItem();
			int dia = (int) this.comboBoxDia1.getSelectedItem();
			LocalDate fecha = LocalDate.of( anio, mes, dia );
			TipoAvion tipoAvion = (TipoAvion) this.comboBoxTipoAvion.getSelectedItem();
			if ( comboBoxTipoVuelo.getSelectedItem().equals( "Nacional" )|| comboBoxTipoVuelo.getSelectedItem().equals( "nacional" ) )
			{
				sistema.crearVueloEspecificoNacional(nuevaAerolinea.getCodigo(), codigoFila, Integer.parseInt( this.textFieldImpuestoIva.getText() ), fecha, tipoAvion, Integer.parseInt( this.textFieldCapacidad.getText() ), Long.parseLong( this.textFieldTarifa.getText()));
				JOptionPane.showMessageDialog(frmFrameprincipal, "Vuelo especifico nacional creado con el codigo " +sistema.getAerolineas().get(nuevaAerolinea.getCodigo()).getVuelosPlaneados().get(codigoFila).getVuelosEspecificos().size() );
			}
			else if( comboBoxTipoVuelo.getSelectedItem().equals( "Internacional" ) || comboBoxTipoVuelo.getSelectedItem().equals( "internacional" ) )
			{
				sistema.crearVueloEspecificoInternacional(nuevaAerolinea.getCodigo(),codigoFila,Integer.parseInt( this.textFieldImpuestoIva.getText() ) , fecha, tipoAvion, Integer.parseInt( this.textFieldCapacidad.getText() ), Long.parseLong( this.textFieldTarifa.getText()));
				JOptionPane.showMessageDialog(frmFrameprincipal, "Vuelo especifico internacional creado con el codigo " +sistema.getAerolineas().get(nuevaAerolinea.getCodigo()).getVuelosPlaneados().get(codigoFila).getVuelosEspecificos().size() );
			}
		}
		catch ( Exception exp )
		{
			JOptionPane.showMessageDialog(frmFrameprincipal, " Error creando un vuelo especifico:\n " + exp, "Error", JOptionPane.ERROR_MESSAGE);
			exp.printStackTrace();
		}
		DefaultTableModel dtm = new DefaultTableModel( rowData, columNameV );
		for (int i = 0; i < rowData.size(); i++) 
		{
			dtm.removeRow(i);
		}
		dtm = ( DefaultTableModel )tableVuelosPlaneados1.getModel();
		dtm.setRowCount( 0 );
	}

	/**
	 * Metodo que crea un itinerario dado un agente el cual es seleccionado
	 * en el comboBox y esteblece el codigo y el nombre de este
	 * @param e
	 */
	private void registrarItinerario( ActionEvent e )
	{
		try 
		{
			String nombreItinerario = textFieldNombreItinerario.getText();
			Agente nuevoAgente = ( Agente ) this.comboBoxAgentes.getSelectedItem();
			nuevoAgente.crearItinerario( nombreItinerario );
			int tamanioItinerario = nuevoAgente.getItinerarios().size()-1;
			long codigo = ( long ) tamanioItinerario +1 ;
			nuevoAgente.getItinerarios().get( tamanioItinerario ).setCodigo( codigo );
			JOptionPane.showMessageDialog( frmFrameprincipal, "Itinerario creado con el codigo " + codigo  );
		} 
		catch ( Exception exp )
		{
			JOptionPane.showMessageDialog(frmFrameprincipal, " Error creando un itinerario:\n " + exp, "Error", JOptionPane.ERROR_MESSAGE);
			exp.printStackTrace();
		}
	}

	/**
	 * Metodo que registra un pasajero en un agente y en un itinerario
	 * dado
	 * @param e
	 */
	private void registrarPasajero( ActionEvent e )
	{
		try
		{
			String identificacion = textFieldIdentificacionPasajero.getText();
			String nombre = textFieldNombrePasajero.getText();
			int anio = (int) this.comboBoxAnio2.getSelectedItem();
			int mes = (int) this.comboBoxMes2.getSelectedItem();
			int dia = (int) this.comboBoxDia2.getSelectedItem();
			LocalDate fecha = LocalDate.of( anio, mes, dia );
			String apoyo = ( String ) this.comboBoxSoloAsistencia.getSelectedItem();
			boolean ayuda;
			if( apoyo.equals("SI") )
				ayuda = true;
			else
				ayuda = false;

			Agente nuevoAgente = ( Agente ) this.comboBoxAgentes.getSelectedItem();
			int tamanioItinerario = nuevoAgente.getItinerarios().size()-1;
			boolean esMenor = utilidades.verificarMenor( fecha );
			if( esMenor )
				nuevoAgente.getItinerarios().get( tamanioItinerario ).comprarItinerarioMenor(identificacion, nombre, fecha, ayuda);
			else
				nuevoAgente.getItinerarios().get( tamanioItinerario ).comprarItinerarioMayor(identificacion, nombre, fecha, ayuda);

			JOptionPane.showMessageDialog( frmFrameprincipal, "Pasajero creado exitosamente" );
		} 
		catch ( Exception exp ) 
		{
			JOptionPane.showMessageDialog(frmFrameprincipal, " Error creando el pasajero:\n " + exp, "Error", JOptionPane.ERROR_MESSAGE);
			exp.printStackTrace();
		}
		textFieldIdentificacionPasajero.setText( "" );
		textFieldNombrePasajero.setText( "" );
	}

	/**
	 * El sistema muestra en una tabla los datos de los vuelos especificos
	 * que cumplen con los requerimientos
	 * @param e
	 */
	private void mostrarAlternativas( ActionEvent e )
	{
		Ciudad nuevaCiudadOrigen = (Ciudad)this.comboBoxCiudadOrigen.getSelectedItem();
		Ciudad nuevaCiudadDestino = (Ciudad)this.comboBoxCiudadDestino.getSelectedItem();
		int annio = ( int )this.comboBoxAnio3.getSelectedItem();
		int mes = ( int ) this.comboBoxMes3.getSelectedItem();
		int dia = ( int ) this.comboBoxDia3.getSelectedItem();
		LocalDate fecha=LocalDate.of( annio, mes, dia );
		Collection< Aerolinea > collectionAerolinea = sistema.getAerolineas().values();
		for ( Aerolinea aerolinea : collectionAerolinea )
		{
			for( VueloPlaneado vuelo : aerolinea.getVuelosPlaneados() )
			{
				if ( ( nuevaCiudadOrigen.getNombre() == vuelo.getCiudadOrigen().getNombre() ) && ( nuevaCiudadDestino.getNombre() == vuelo.getCiudadDestino().getNombre() )  )
				{
					for( VueloEspecifico vueloE : vuelo.getVuelosEspecificos() )
					{
						if( fecha.equals( vueloE.getFecha() ) )
						{
							comboBoxSeleccionarAgente.setVisible( true );
							comboBoxSeleccionarItinerario.setVisible( true );
							Vector fila=new Vector();
							fila.add( vueloE.getCodigo() );
							fila.add( aerolinea.getNombre() );
							fila.add( vuelo.getNumeroVuelo() );
							fila.add( vuelo.getHoraSalida() + "/" + vuelo.getHoraLlegada() );
							fila.add( vueloE.getCuposLibres() );
							fila.add( vueloE.getTarifa() );
							boolean esNacional = sistema.verificarTipoVueloEspecificoNacional( vueloE );
							if( esNacional )
							{
								fila.add( "nacional" );
								VueloEspecificoNacional nacional = ( VueloEspecificoNacional ) vueloE;
								fila.add(nacional.getIva());
							}
							else
							{
								fila.add( "internacional" );
								VueloEspecificoInternacional internacional = ( VueloEspecificoInternacional ) vueloE;
								fila.add( internacional.getImpuestoSalida() );
							}
							rowData2.add( fila );
						}
					}
				}
			}
		}
		DefaultTableModel dtm2 = new DefaultTableModel( rowData2, columNameV2 );
		this.tableVuelosRequerimientos = new JTable( dtm2 );
		scrollPaneVueloRequerimientos.setViewportView( getTableVuelosRequerimientos() );
	}

	/**
	 * Muestra los itinerarios del agente seleccionado en el comboBox
	 * anterior
	 * @param agente
	 */
	public void rellenarcomboBoxItinerario( Agente agente )
	{
		comboBoxSeleccionarItinerario.removeAllItems();
		for( Itinerario itinerario:agente.getItinerarios() )
		{
			comboBoxSeleccionarItinerario.addItem( itinerario );
		}
	}

	/**
	 * Si por lo menos existe un vuelo específico que cumpla con los requerimientos se habilitan los
	 *elementos que aparecen debajo de la tabla, permitiendo que el usuario seleccione el agente y el
	 *itinerario
	 */
	private void registrarTrayectoParaUnItinerario()
	{
		try 
		{
			Agente agente=(Agente)comboBoxSeleccionarAgente.getSelectedItem();
			Itinerario itinerario = ( Itinerario )comboBoxSeleccionarItinerario.getSelectedItem();
			int fila = this.tableVuelosRequerimientos.getSelectedRow();
			String nombreAerolinea = (String) this.tableVuelosRequerimientos.getValueAt(fila, 1);
			String numVuelo = ( String ) this.tableVuelosRequerimientos.getValueAt(fila, 2);
			long codVueloEspecifico =( long )this.tableVuelosRequerimientos.getValueAt(fila, 0);
			Collection< Aerolinea > collectionAerolinea = sistema.getAerolineas().values();
			for( Aerolinea aerolinea : collectionAerolinea )
			{
				if(aerolinea.getNombre()==nombreAerolinea)
				{
					for(VueloPlaneado vuelo:aerolinea.getVuelosPlaneados())
					{
						if(vuelo.getNumeroVuelo()==numVuelo)
						{
							for(VueloEspecifico vueloE:vuelo.getVuelosEspecificos())
							{
								if(vueloE.getCodigo()==codVueloEspecifico)
								{
									int codigo = ( int )itinerario.getCodigo();
									itinerario.crearTrayecto(vueloE);
									itinerario.setVueloEspecifico( vueloE );
									break;
								}
							}
							break;
						}
					}
					break;
				}
			}
			JOptionPane.showMessageDialog( frmFrameprincipal, "Pasajero creado exitosamente" );
		} 
		catch ( Exception exp ) 
		{
			JOptionPane.showMessageDialog( frmFrameprincipal, " Error creando el pasajero:\n " + exp, "Error", JOptionPane.ERROR_MESSAGE );
			exp.printStackTrace();
		}
	}

	/**
	 * Metodo que muestra las aerolineas que estan cargadas en el sistema
	 * @param e
	 */
	private void mostrarAerolineas( ActionEvent e )
	{
		try 
		{
			Collection< Aerolinea > collectionAerolinea = sistema.getAerolineas().values();
			for( Aerolinea aerolinea : collectionAerolinea )
			{
				Vector fila = new Vector();
				fila.add( aerolinea.getNombre() );
				fila.add( aerolinea.getCodigo() );
				fila.add( aerolinea.getCuentaBanco() );
				rowData3.add( fila );	
			}
			DefaultTableModel dtm = new DefaultTableModel( rowData3, columNameV3 );
			this.tableAerolineas = new JTable( dtm );
			scrollPaneAerolinea.setViewportView( getTableAerolineas() );
			JOptionPane.showMessageDialog( frmFrameprincipal, "Aerolineas mostradas con exitos" );
		} 
		catch (Exception exp) 
		{
			JOptionPane.showMessageDialog( frmFrameprincipal, " Error mostrando las aerolineas:\n " + exp, "Error", JOptionPane.ERROR_MESSAGE );
			exp.printStackTrace();
		}

	}

	/**
	 * Metodo que muestra los vuelos planeados de la aerolinea que
	 * el usuario haya seleccionado en la tabla anterior
	 * @param e
	 */
	private void mostrarVuelosPlaneadosReporte( ActionEvent e )
	{
		try
		{
			int filaTablaAerolineas = tableAerolineas.getSelectedRow();
			String nombreAerolinea = ( String ) tableAerolineas.getValueAt( filaTablaAerolineas, 0 );
			Aerolinea nuevaAerolinea = sistema.buscarAerolinea( nombreAerolinea );
			for( VueloPlaneado vuelo: nuevaAerolinea.getVuelosPlaneados() )
			{
				Vector fila = new Vector();
				fila.add( vuelo.getCodigo()  );
				fila.add( vuelo.getNumeroVuelo() );
				fila.add( vuelo.getDiaSemana() );
				fila.add( vuelo.getHoraSalida() + "/" + vuelo.getHoraLlegada() );
				fila.add( vuelo.getCiudadOrigen().getNombre() );
				fila.add(vuelo.getCiudadDestino().getNombre() );
				rowData4.add( fila );
			}
			DefaultTableModel dtm = new DefaultTableModel( rowData4, columNameV );
			this.tableVuelosPlaneados2 = new JTable( dtm );
			scrollPaneVuelosPlaneados2.setViewportView( getTableVuelosPlaneados2() );
			JOptionPane.showMessageDialog( frmFrameprincipal, "Vuelos planeados mostrados con exitos" );
		} 
		catch (Exception exp)
		{
			JOptionPane.showMessageDialog( frmFrameprincipal, " Error mostrando los vuelos planeados:\n " + exp, "Error", JOptionPane.ERROR_MESSAGE );
			exp.printStackTrace();
		}

	}

	/**
	 * Metodo que muestra los vuelos especificos qeu estan en un vuelo
	 * planeado de una cierta aerolinea
	 * @param e
	 */
	private void mostrarVuelosEspecificos( ActionEvent e )
	{
		try 
		{
			int filaTablaAerolineas = tableAerolineas.getSelectedRow();
			int filaTablaVuelosPlaneados = tableVuelosPlaneados2.getSelectedRow();
			String nombreAerolinea = ( String ) tableAerolineas.getValueAt( filaTablaAerolineas, 0 );
			long codigoVueloPlaneado = ( long ) tableVuelosPlaneados2.getValueAt(filaTablaVuelosPlaneados, 0);
			Aerolinea nuevaAerolinea = sistema.buscarAerolinea( nombreAerolinea );
			VueloPlaneado nuevoVueloPlaneado = nuevaAerolinea.buscarVueloPlaneado( codigoVueloPlaneado );
			for ( VueloEspecifico vueloEspecifico : nuevoVueloPlaneado.getVuelosEspecificos() )
			{
				Vector fila = new Vector();
				fila.add( vueloEspecifico.getCodigo() );
				fila.add( vueloEspecifico.getFecha() );
				fila.add( vueloEspecifico.getTipoAvion() );
				fila.add( vueloEspecifico.getCapacidad() );
				fila.add( vueloEspecifico.getCuposLibres() );
				fila.add( vueloEspecifico.getTarifa() );
				boolean esNacional = sistema.verificarTipoVueloEspecificoNacional( vueloEspecifico );
				if( esNacional )
				{
					fila.add( "nacional" );
					VueloEspecificoNacional nacional = ( VueloEspecificoNacional ) vueloEspecifico;
					fila.add(nacional.getIva());
					fila.add( nacional.calcularValorPasaje(vueloEspecifico.getFecha(), vueloEspecifico.getTarifa()) );
				}
				else
				{
					fila.add( "internacional" );
					VueloEspecificoInternacional internacional = ( VueloEspecificoInternacional ) vueloEspecifico;
					fila.add( internacional.getImpuestoSalida() );
					fila.add( internacional.calcularValorPasaje(vueloEspecifico.getFecha(), vueloEspecifico.getTarifa()));
				}
				rowData5.add(fila);
			}
			DefaultTableModel dtm = new DefaultTableModel( rowData5, columNameV4 );
			this.tableVuelosEspecificos = new JTable( dtm );
			scrollPaneVuelosEspecificos.setViewportView( getTableVuelosEspecificos() );
			JOptionPane.showMessageDialog( frmFrameprincipal, "Vuelos especificos mostrados con exitos" );
		}
		catch (Exception exp)
		{
			JOptionPane.showMessageDialog( frmFrameprincipal, " Error mostrando los vuelos especificos:\n " + exp, "Error", JOptionPane.ERROR_MESSAGE );
			exp.printStackTrace();
		}
	}
	
	/**
	 * rellena el combo box de itinerarios dependiendo de la opcion escogida en el anterior combo Box
	 * @param agente
	 */
	private void rellenarcomboBoxItinerario2( Agente agente )
	{
		comboBoxItinerarios.removeAllItems();
		for( Itinerario itinerario : agente.getItinerarios() )
		{
			comboBoxItinerarios.addItem( itinerario );
		}
	}

	/**
	 * Metodo que muestra toda la informacion relacionada con el trayecto
	 * mostrando adicionalmente el nombre de la aerolinea y otros atributos
	 * del vuelo planeado al que esta asociado el vueloe especifico
	 * @param e
	 */
	private void mostrarTrayectos( ActionEvent e )
	{
		try 
		{
			DefaultTableModel dt = new DefaultTableModel( rowData6, columNameV5 );
			for (int i = 0; i < rowData6.size(); i++) 
			{
				dt.removeRow(i);
			}
			dt = ( DefaultTableModel )tableTrayectos1.getModel();
			dt.setRowCount( 0 );
			Agente agente = ( Agente )comboBoxAgentes2.getSelectedItem();
			Itinerario itinerario = ( Itinerario )comboBoxItinerarios.getSelectedItem();
			Collection< Aerolinea > collectionAerolinea = sistema.getAerolineas().values();
			for( Trayecto trayecto : itinerario.getTrayectos() )
			{
				Vector fila = new Vector();
				fila.add( trayecto.getId() );
				for( Aerolinea aerolinea : collectionAerolinea )
				{
					for( VueloPlaneado vuelo : aerolinea.getVuelosPlaneados() )
					{
						for( VueloEspecifico vueloE : vuelo.getVuelosEspecificos() )
						{
							if( itinerario.getVueloEspecifico().getCodigo() == vueloE.getCodigo() )
							{
								fila.add( aerolinea.getNombre() );
								fila.add( vuelo.getNumeroVuelo() );
								fila.add( itinerario.getVueloEspecifico().getFecha() );
								fila.add( vuelo.getHoraLlegada()+"/"+vuelo.getHoraLlegada() );
								fila.add( itinerario.getVueloEspecifico().getTarifa() );
								break;
							}
						}
						break;
					}
				}

				VueloEspecifico vueloEspecifico = itinerario.getVueloEspecifico();
				boolean esNacional = sistema.verificarTipoVueloEspecificoNacional( vueloEspecifico );
				if( esNacional )
				{
					fila.add( "nacional" );
					VueloEspecificoNacional nacional = ( VueloEspecificoNacional ) vueloEspecifico;
					fila.add(nacional.getIva());
				}
				else
				{
					fila.add( "internacional" );
					VueloEspecificoInternacional internacional = ( VueloEspecificoInternacional ) vueloEspecifico;
					fila.add( internacional.getImpuestoSalida() );
				}
				rowData6.add( fila );
			}
			DefaultTableModel dtm = new DefaultTableModel( rowData6, columNameV5 );
			this.tableTrayectos1 = new JTable( dtm );
			scrollPaneTrayectos.setViewportView( getTableTrayectos1() );
			JOptionPane.showMessageDialog( frmFrameprincipal, "trayectos mostrados con exito" );
		}
		catch (Exception exp)
		{
			JOptionPane.showMessageDialog( frmFrameprincipal, " Error mostrando los trayectos:\n " + exp, "Error", JOptionPane.ERROR_MESSAGE );
			exp.printStackTrace();
		}
	}
	
	/**
	 * se muestran los trayctos asociados a un itinerario
	 * @param e
	 */
	private void mostrarTrayectosComprarItinerario( ActionEvent e )
	{
		try 
		{
			Agente agente = ( Agente )comboBoxAgentes3.getSelectedItem();
			Itinerario itinerario = ( Itinerario )comboBoxItinerarios2.getSelectedItem();
			Collection< Aerolinea > collectionAerolinea = sistema.getAerolineas().values();
			int numeroPasajeros = comboBoxPasajeros.getItemCount();
			System.out.println(numeroPasajeros);
			for( Trayecto trayecto : itinerario.getTrayectos() )
			{
				Vector fila = new Vector();
				fila.add( trayecto.getId() );
				for( Aerolinea aerolinea : collectionAerolinea )
				{
					for( VueloPlaneado vuelo : aerolinea.getVuelosPlaneados() )
					{
						for( VueloEspecifico vueloE : vuelo.getVuelosEspecificos() )
						{
							if( itinerario.getVueloEspecifico().getCodigo() == vueloE.getCodigo() )
							{
								fila.add( aerolinea.getNombre() );
								fila.add( vuelo.getNumeroVuelo() );
								fila.add( itinerario.getVueloEspecifico().getFecha() );
								fila.add( vuelo.getHoraLlegada()+"/"+vuelo.getHoraLlegada() );
								fila.add( itinerario.getVueloEspecifico().getTarifa() );
								break;
							}
						}
						break;
					}
				}
				VueloEspecifico vueloEspecifico = itinerario.getVueloEspecifico();
				boolean esNacional = sistema.verificarTipoVueloEspecificoNacional( vueloEspecifico );
				if( esNacional )
				{
					fila.add( "nacional" );
					VueloEspecificoNacional nacional = ( VueloEspecificoNacional ) vueloEspecifico;
					fila.add(nacional.getIva());
				}
				else
				{
					fila.add( "internacional" );
					VueloEspecificoInternacional internacional = ( VueloEspecificoInternacional ) vueloEspecifico;
					fila.add( internacional.getImpuestoSalida() );
				}
				System.out.println(vueloEspecifico.getCuposLibres());
				boolean hayCupo = trayecto.verificarCupo(numeroPasajeros);
				if( hayCupo )
				{
					itinerario.setComprado( hayCupo );
					JOptionPane.showMessageDialog( frmFrameprincipal, "Si hay cupos disponibles" );
				}
				else
				{
					itinerario.setComprado( !hayCupo );
					JOptionPane.showMessageDialog( frmFrameprincipal, "No hay cupos disponibles" );
				}
				rowData7.add( fila );
			}
			DefaultTableModel dtm = new DefaultTableModel( rowData7, columNameV5 );
			this.tableTrayectos2 = new JTable( dtm );
			scrollPaneTrayectos2.setViewportView( getTableTrayectos2() );
			JOptionPane.showMessageDialog( frmFrameprincipal, "trayectos mostrados con exito" );
		}
		catch (Exception exp)
		{
			JOptionPane.showMessageDialog( frmFrameprincipal, " Error mostrando los trayectos:\n " + exp, "Error", JOptionPane.ERROR_MESSAGE );
			exp.printStackTrace();
		}
	}
	
	/**
	 * se llena el comboBox con los itinerarios relacionados al agente selecionado en el comboBox
	 * anterior
	 * @param agente
	 */
	private void rellenarcomboBoxItinerario3( Agente agente )
	{
		comboBoxItinerarios2.removeAllItems();
		for( Itinerario itinerario : agente.getItinerarios() )
		{
			comboBoxItinerarios2.addItem( itinerario );
		}
	}
	
	/**
	 * se llena el comboBox con el pasajero asociado al itinerario del comboBox anterior
	 * @param itinerario
	 */
	private void rellenarcomboBoxPasajero( Itinerario itinerario )
	{
		comboBoxPasajeros.removeAllItems();
		for( Pasajero pasajero : itinerario.getPasajeros() )
		{
			comboBoxPasajeros.addItem( pasajero );
		}
	}
	
	/**
	 * se muestran en el comboBox de 1 a 30
	 * @param e
	 */
	private void mostrarSillasDisponibles( ActionEvent e )
	{
		try 
		{
			for(int i=1;i<31;i++){
				comboBoxFila.addItem(i);
			}	
		}
		catch (Exception exp) 
		{
			JOptionPane.showMessageDialog( frmFrameprincipal, " Error mostrando los trayectos:\n " + exp, "Error", JOptionPane.ERROR_MESSAGE );
			exp.printStackTrace();
		}
	}
	
	/**
	 * llena el comboBox con los itinerarios asociados al agente del comboBox anterior
	 * @param agente
	 */
	private void rellenarcomboBoxItinerario4( Agente agente )
	{
		comboBoxItinerarios3.removeAllItems();
		for( Itinerario itinerario : agente.getItinerarios() )
		{
			comboBoxItinerarios3.addItem( itinerario );
		}
	}
	
	/**
	 *  permitir grabar la variable que
		representa todo el sistema como un objeto serializado. El sistema solicita al usuario que indique la
		localización y el nombre del archivo (a través de un JFileChooser). Debe haber manejo de
		excepciones mostrando los posibles errores. Los errores deben ser mostrados en cajas de diálogo
		(JDialog).
	 * @param e
	 */
	private void guardarDatos( ActionEvent e )
	{
		try
		{
			JFileChooser chooser = new JFileChooser(new File(".").getCanonicalPath());
			FileFilter filtroDeArchivos = new FileNameExtensionFilter("Archivo SistemaViajes", "obj"); 
			chooser.setFileFilter( filtroDeArchivos );
			chooser.setAcceptAllFileFilterUsed( false );
			int resultado = chooser.showSaveDialog( frmFrameprincipal );
			if (resultado == JFileChooser.APPROVE_OPTION) 
			{
				ManejoArchivos.serializarSistemaViajes( sistema, chooser.getSelectedFile() );
				JOptionPane.showMessageDialog( frmFrameprincipal, "Sistema guardado correctamente.");
			}
		}
		catch (Exception exp) 
		{
			JOptionPane.showMessageDialog( frmFrameprincipal, "Error guardando el sistema:\n"+exp, "Error", JOptionPane.ERROR_MESSAGE);
			exp.printStackTrace();
		}
	}
	
	/**
	 * debe permitir cargar un objeto
		serializado contenido en el archivo indicado por el usuario: se descarta entonces la versión de la
		variable que representa el sistema y se le asigna el objeto cargado. El archivo del que se quiere cargar
		el objeto debe ser seleccionado a través de un JFileChooser. Debe haber manejo de excepciones
		mostrando los posibles errores. Los errores deben ser mostrados en cajas de diálogo (JDialog)
	 * @param e
	 */
	private void cargarDatos( ActionEvent e )
	{
		try
		{
			JFileChooser chooser = new JFileChooser(new File(".").getCanonicalPath());
			FileFilter filtroDeArchivos = new FileNameExtensionFilter("Archivo SistemaViajes", "obj"); 
			chooser.setFileFilter( filtroDeArchivos );
			chooser.setAcceptAllFileFilterUsed( false );
			int resultado = chooser.showOpenDialog( frmFrameprincipal );
			if (resultado == JFileChooser.APPROVE_OPTION) 
			{
				sistema = ManejoArchivos.deserializarSistemaViajes( chooser.getSelectedFile() );
				JOptionPane.showMessageDialog( frmFrameprincipal, "Sistema guardado correctamente.");
			}
		}
		catch (Exception exp) 
		{
			JOptionPane.showMessageDialog( frmFrameprincipal, "Error guardando el sistema:\n"+exp, "Error", JOptionPane.ERROR_MESSAGE);
			exp.printStackTrace();
		}
	}
	
	/**
	 * llena las posiciones del comboBox de la A a la E segun el numero que se seleccione en el comboBox
	 * anterior, y muestra las sillas que estan disponibles. si no lo esta solo no lo agrega al comboBox
	 * 
	 */
	private void rellenarComboBoxPosicion()
	{
		comboBoxPosicion.removeAllItems();
		Itinerario itinerario1 = ( Itinerario ) this.comboBoxItinerarios2.getSelectedItem();
		int filaTablaTrayectos = tableTrayectos2.getSelectedRow();
		int codTrayecto = ( int ) tableTrayectos2.getValueAt(filaTablaTrayectos, 0);
		for(int i = 65 ; i < 70 ; i++ )
		{
				for( Silla silla : itinerario1.getTrayectos().get(codTrayecto).getVueloEspecifico().getSillas() )
				{
						
						if(silla.isComprada()==false)
						{
							comboBoxPosicion.addItem( (char)i );
							break;
						}
					}
				}
		}
	

	/**
	 * con la informacion obtenida registra la silla y se compra el itinerario asociando la silla al trayecto 
	 * y al pasajero respectivamente
	 * @param e
	 */
	private void registrarSilla( ActionEvent e )
	{
		try
		{
			int filaTablaTrayectos = tableTrayectos2.getSelectedRow();
			int codTrayecto = ( int ) tableTrayectos2.getValueAt( filaTablaTrayectos, 0);
			Itinerario itinerario1 = ( Itinerario ) this.comboBoxItinerarios2.getSelectedItem();
			int fila = ( int ) comboBoxFila.getSelectedItem();	
			char letra=( char ) comboBoxPosicion.getSelectedItem();
			String filaReal = String.valueOf( fila );
			filaReal += letra;
			for( Silla silla : itinerario1.getTrayectos().get(codTrayecto).getVueloEspecifico().getSillas())
			{
				if( silla.getId().equals(filaReal))
				{
					System.out.println(filaReal);
					silla.setComprada( true );
					itinerario1.setComprado( true );
					itinerario1.getTrayectos().get( codTrayecto ).getSillas().add( silla );
					//itinerario1.getPasajeros().get(0).asignarSilla( silla );
					break;
				}
			}
			JOptionPane.showMessageDialog( frmFrameprincipal, "Silla registrada correctamente.");
		}
		
		catch (Exception exp) 
		{
			JOptionPane.showMessageDialog( frmFrameprincipal, "Error registrando la silla el sistema:\n"+exp, "Error", JOptionPane.ERROR_MESSAGE);
			exp.printStackTrace();
		}	
	}
	
	/**
	 * Genera un archivo .txt  con toda la informacion del vuelo
	 * @param e
	 */
	private void generarTiquete( ActionEvent e )
	{
		try
		{
			Agente agente = ( Agente ) comboBoxAgentes4.getSelectedItem();
			Itinerario itinerario = ( Itinerario ) comboBoxItinerarios3.getSelectedItem();
			if( itinerario.isComprado() )
			{
				try
				{
					JFileChooser chooser = new JFileChooser(new File(".").getCanonicalPath());
					FileFilter filtroDeArchivos = new FileNameExtensionFilter("Archivo Reporte", "txt"); 
					chooser.setFileFilter( filtroDeArchivos );
					chooser.setAcceptAllFileFilterUsed( false );
					int resultado = chooser.showSaveDialog( frmFrameprincipal );
					if (resultado == JFileChooser.APPROVE_OPTION) 
					{
						ManejoArchivos.generarReporte( sistema, chooser.getSelectedFile(),agente,itinerario );
						JOptionPane.showMessageDialog( frmFrameprincipal, "Reporte generado con exito.");
					}
				}
				catch (Exception exp) 
				{
					JOptionPane.showMessageDialog( frmFrameprincipal, "Error al generar el reporte:\n"+exp, "Error", JOptionPane.ERROR_MESSAGE);
					exp.printStackTrace();
				}
			}
			else
				JOptionPane.showMessageDialog( frmFrameprincipal, " Aun no se ha comprado este itinerario.");
		}
		catch( Exception exp )
		{
			JOptionPane.showMessageDialog( frmFrameprincipal, "Error generando reporte:\n" + exp, "Error", JOptionPane.ERROR_MESSAGE);
			exp.printStackTrace();
		}	
	}
}
