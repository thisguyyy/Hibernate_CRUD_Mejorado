package controller;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import config.ConexionBD;
import models.Vuelos;

public class VuelosController {
	
	// M�todo que devuelve todos los vuelos
	public List<Vuelos> listarVuelos1(){
		
		// Variable conexion que accede al m�todo de nuetsra clase Conexi�n
		ConexionBD conexion = new ConexionBD();
		
		// Variable que llama al m�todo get_conexion()
		Connection con = conexion.get_conexion();
		
		//Variable que se inicializa para guardar la preparaci�n de la consulta o query
		PreparedStatement stm = null;
		
		//Variable que se inicializa para guradra la ejecuci�n dela consulta o query
		ResultSet rs = null;		
		
		// Lista donde se guardar� el listaod de vuelos de la tabla Vuelos en la BD
		List<Vuelos> lista_vuelos = new ArrayList<Vuelos>();
		
		try {
			// Consulta a la BD para listar los vuelos [Listar Vuelos]
			String query = "SELECT * from vuelos ORDER BY id ASC";
			
			// Hace la llamada al m�tododo prepareStatement y este prepara la ejecuci�n de la consulta
			stm = con.prepareStatement(query);
			
			// Hace la llamda al m�todo executeQuery ejecuta la consulta y la guardamos en una variable iteradora 
			rs = stm.executeQuery();
			
			while (rs.next()) {
				
				Vuelos vuelos = new Vuelos();
				vuelos.setId(rs.getInt("ID"));
				vuelos.setCodigo_vuelo(rs.getString("CODIGO_VUELO"));
				vuelos.setOrigen(rs.getString("ORIGEN"));
				vuelos.setDestino(rs.getString("DESTINO"));
				vuelos.setFecha(rs.getString("FECHA"));
				vuelos.setPlazas_totales(rs.getInt("PLAZAS_TOTALES"));
				vuelos.setPlazas_disponibles(rs.getInt("PLAZAS_DISPONIBLES"));
				
				lista_vuelos.add(vuelos);	
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar los vuelos");
		}
		
		return lista_vuelos;
	}

	public List<Vuelos> info_vuelo(String codigo_vuelo) {

		
		ConexionBD conexion = new ConexionBD();
		Connection con = conexion.get_conexion();
		PreparedStatement stm = null;
		ResultSet rs = null;	
		
		List<Vuelos> lista_vuelos = new ArrayList<Vuelos>();
		
		try {
			String query = "SELECT * from vuelos WHERE CODIGO_VUELO = " + "'" + codigo_vuelo + "'";
			
			stm = con.prepareStatement(query); 
			rs = stm.executeQuery();
			
			while (rs.next()) {
				
				Vuelos vuelos = new Vuelos();
								
				vuelos.setId(rs.getInt("ID"));
				vuelos.setCodigo_vuelo(rs.getString("CODIGO_VUELO"));
				vuelos.setOrigen(rs.getString("ORIGEN"));
				vuelos.setDestino(rs.getString("DESTINO"));
				vuelos.setFecha(rs.getString("FECHA"));
				vuelos.setPlazas_totales(rs.getInt("PLAZAS_TOTALES"));
				vuelos.setPlazas_disponibles(rs.getInt("PLAZAS_DISPONIBLES"));
				
				lista_vuelos.add(vuelos);	
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar los vuelos");
		}
		
		return lista_vuelos;
	}
	
	public List<Vuelos> info_vuelo_by_ID(int id_vuelo) {

		
		ConexionBD conexion = new ConexionBD();
		Connection con = conexion.get_conexion();
		PreparedStatement stm = null;
		ResultSet rs = null;	
		
		List<Vuelos> lista_vuelos = new ArrayList<Vuelos>();
		
		try {
			String query = "SELECT * from vuelos WHERE ID = " + "'" + id_vuelo + "'";
			
			stm = con.prepareStatement(query); 
			rs = stm.executeQuery();
			
			while (rs.next()) {
				
				Vuelos vuelos = new Vuelos();
								
				vuelos.setId(rs.getInt("ID"));
				vuelos.setCodigo_vuelo(rs.getString("CODIGO_VUELO"));
				vuelos.setOrigen(rs.getString("ORIGEN"));
				vuelos.setDestino(rs.getString("DESTINO"));
				vuelos.setFecha(rs.getString("FECHA"));
				vuelos.setPlazas_totales(rs.getInt("PLAZAS_TOTALES"));
				vuelos.setPlazas_disponibles(rs.getInt("PLAZAS_DISPONIBLES"));
				
				lista_vuelos.add(vuelos);	
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar los vuelos");
		}
		
		return lista_vuelos;
	}
	
	public boolean insertar_vuelo(String codigo_vuelo, String origen, String destino, String fecha, int plazas_totales, int plazas_disponibles) {
		
		ConexionBD conexion = new ConexionBD();
		Connection con = conexion.get_conexion();
		
		PreparedStatement stm = null;
		
		boolean insercion;
		 
		try {
			String query = "INSERT into vuelos (CODIGO_VUELO, ORIGEN, DESTINO, FECHA, PLAZAS_TOTALES, PLAZAS_DISPONIBLES) values (?,?,?,?,?,?)";
			stm = con.prepareStatement(query);
			
			stm.setString(1, codigo_vuelo);
			stm.setString(2, origen);
			stm.setString(3, destino);
			stm.setString(4, fecha);
			stm.setInt(5, plazas_totales);
			stm.setInt(6, plazas_disponibles);
			
			stm.executeUpdate();
			
			insercion = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al insertar el libro");
			insercion = false;
		}
		
		return insercion;
		
	}
	
	public boolean eliminar_vuelo(int id) {
		ConexionBD conexion = new ConexionBD();
		Connection con = conexion.get_conexion();
		
		PreparedStatement stm = null;
		
		boolean eliminar = false;
		
		try {
			String query = "DELETE FROM vuelos WHERE ID = " + "'" + id + "'";
			stm = con.prepareStatement(query);
			stm.executeUpdate();			
			eliminar = true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return eliminar;
	}
		
	public boolean editar_vuelo(int id,String codigo_vuelo, String origen, String destino, String fecha, int plazas_totales, int plazas_disponibles) {
		
		ConexionBD conexion = new ConexionBD();
		Connection con = conexion.get_conexion();
		
		PreparedStatement stm = null;
		
		boolean editar;
		 
		try {
			String query = "UPDATE vuelos SET CODIGO_VUELO=?,ORIGEN=?,DESTINO=?,FECHA=?,PLAZAS_TOTALES=?,PLAZAS_DISPONIBLES=? WHERE ID = ?";
			
			stm = con.prepareStatement(query);
			
			stm.setString(1, codigo_vuelo);
			stm.setString(2, origen);
			stm.setString(3, destino);
			stm.setString(4, fecha);
			stm.setInt(5, plazas_totales);
			stm.setInt(6, plazas_disponibles);
			stm.setInt(7, id);
			
			stm.executeUpdate();
			
			editar = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al editar el vuelo");
			editar = false;
		}
		
		return editar;
		
	}
	


	public static void listarVuelos() {

		VuelosController lista = new VuelosController();

		List<Vuelos> lista_vuelos = lista.listarVuelos1();

		Iterator<Vuelos> iterador = lista_vuelos.iterator();

		while (iterador.hasNext()) {
			Vuelos vuelos = new Vuelos();
			vuelos = iterador.next();

			System.out.println("ID:" + vuelos.getId());
			System.out.println("C�DIGO: " + vuelos.getCodigo_vuelo());
			System.out.println("ORIGEN: " + vuelos.getOrigen());
			System.out.println("DESTINO: " + vuelos.getDestino());
			System.out.println("FECHA: " + vuelos.getFecha());
			System.out.println("PLAZAS TOTALES: " + vuelos.getPlazas_totales());
			System.out.println("PLAZAS DISPONIBLES:" + vuelos.getPlazas_disponibles());

			System.out.println(" **************************** ");

		}
	}

	public static void mostrarInfoVuelo() {

		VuelosController lista = new VuelosController();

		System.out.println("Entre el C�digo del Vuelo");

		Scanner entradaEscaner = new Scanner(System.in);

		List<Vuelos> lista_vuelos = lista.info_vuelo(entradaEscaner.nextLine());

		Iterator<Vuelos> iterador = lista_vuelos.iterator();

		while (iterador.hasNext()) {
			Vuelos vuelos = new Vuelos();
			vuelos = iterador.next();

			System.out.println("ID:" + vuelos.getId());
			System.out.println("C�DIGO: " + vuelos.getCodigo_vuelo());
			System.out.println("ORIGEN: " + vuelos.getOrigen());
			System.out.println("DESTINO: " + vuelos.getDestino());
			System.out.println("FECHA: " + vuelos.getFecha());
			System.out.println("PLAZAS TOTALES: " + vuelos.getPlazas_totales());
			System.out.println("PLAZAS DISPONIBLES:" + vuelos.getPlazas_disponibles());

			System.out.println(" **************************** ");

		}
	}

	public static void insertarVuelos() {

		VuelosController lista = new VuelosController();

		String cod_vuelo = "";
		String org_vuelo = "";
		String des_vuelo = "";
		String fec_vuelo = "";
		int pzt_vuelo = 0;
		int pzd_vuelo = 0;

		System.out.println("Entre el C�digo del Vuelo (TIENE QUE TENER 5 CARACTERES)");
		Scanner scanner = new Scanner(System.in);

		cod_vuelo = scanner.nextLine();

		if (cod_vuelo.length() == 5) {

			List<Vuelos> lista_tamano = lista.info_vuelo(cod_vuelo);

			if (lista_tamano.size() == 0) {

				System.out.println("Entre el Origen del Vuelo");

				org_vuelo = scanner.nextLine();

				System.out.println("Entre el Destino del Vuelo");
				des_vuelo = scanner.nextLine();

				System.out.println("Entre la Fecha del Vuelo(YYYY-MM-DD HH:MM:SS)");

				fec_vuelo = scanner.nextLine();

				System.out.println("Entre la cantidad de plazas totales del Vuelo");
				String next_scan_plazas_totales = scanner.next();
				int plazas_totales = Integer.parseInt(next_scan_plazas_totales);
				pzt_vuelo = plazas_totales;

				System.out.println("Entre la cantidad de plazas disponibles del Vuelo");
				String next_scan_plazas_disponibles = scanner.next();
				int plazas_disponibles = Integer.parseInt(next_scan_plazas_disponibles);
				pzd_vuelo = plazas_disponibles;

				boolean insercion = lista.insertar_vuelo(cod_vuelo, org_vuelo, des_vuelo, fec_vuelo, pzt_vuelo,
						pzd_vuelo);

				if (insercion == true) {
					System.out.println("Vuelo insertado correctamente");
				} else {
					System.out.println("Error al insertar el vuelo. Revise sus datos por favor");
				}

			} else {
				System.out.println(
						"El vuelo ya existe, no se puede crear un vuelo con el mismo c�digo. Revise sus datos por favor !!!");
			}
		} else {
			System.out.println("El c�digo de vuelo debe de tener 5 Caracteres obligatoriamente !!!");
		}

	}

	public static void eliminarVuelo() {

		System.out.println("Entre el ID del Vuelo");
		Scanner scan = new Scanner(System.in);
		String next_scan = scan.next();
		int id = Integer.parseInt(next_scan);

		VuelosController lista = new VuelosController();
		boolean eliminar = lista.eliminar_vuelo(id);

		if (eliminar == true) {
			System.out.println("Vuelo eliminado correctamente");
		} else {
			System.out.println("Error al eliminado el vuelo. Revise sus datos por favor");
		}

	}

	public static void editarVuelo() {

		System.out.println("Entre el ID del Vuelo");
		Scanner scanner = new Scanner(System.in);
		int id_vuelo = Integer.parseInt(scanner.nextLine());

		VuelosController lista = new VuelosController();
		List<Vuelos> lista_tamano = lista.info_vuelo_by_ID(id_vuelo);

		if (lista_tamano.size() == 1) {

			System.out.println("Entre el C�digo del Vuelo a modificar (5 CARACTERES)");
			String cod_vuelo = scanner.nextLine();

			System.out.println("Entre el Origen del Vuelo a modificar");
			String org_vuelo = scanner.nextLine();

			System.out.println("Entre el Destino del Vuelo a modificar");
			String des_vuelo = scanner.nextLine();

			System.out.println("Entre la Fecha del Vuelo a modificar (YYYY-MM-DD HH:MM:SS)");
			String fec_vuelo = scanner.nextLine();

			System.out.println("Entre la cantidad de plazas totales del Vuelo a modificar");
			String next_scan_plazas_totales = scanner.next();
			int plazas_totales = Integer.parseInt(next_scan_plazas_totales);
			int pzt_vuelo = plazas_totales;

			System.out.println("Entre la cantidad de plazas disponibles del Vuelo a modificar");
			String next_scan_plazas_disponibles = scanner.next();
			int plazas_disponibles = Integer.parseInt(next_scan_plazas_disponibles);
			int pzd_vuelo = plazas_disponibles;

			boolean editar = lista.editar_vuelo(id_vuelo, cod_vuelo, org_vuelo, des_vuelo, fec_vuelo, pzt_vuelo,
					pzd_vuelo);

			if (editar == true) {
				System.out.println("Vuelo editado correctamente");
			} else {
				System.out.println("Error al editar el vuelo. Revise sus datos por favor");
			}

		} else {
			System.out.println("No existe vuelo asociado para el ID");
		}

	}

	public static void leerFichero() {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File("./src/archivo.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null)
				System.out.println(linea);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}


	

	public static void insertarFichero() {

		VuelosController lista = new VuelosController();

		String cod_vuelo = "";
		String org_vuelo = "";
		String des_vuelo = "";
		String fec_vuelo = "";
		int pzt_vuelo = 0;
		int pzd_vuelo = 0;

		System.out.println("Entre el C�digo del Vuelo (5 CARACTERES)");
		Scanner scanner = new Scanner(System.in);

		cod_vuelo = scanner.nextLine();

		if (cod_vuelo.length() == 5) {

			List<Vuelos> lista_tamano = lista.info_vuelo(cod_vuelo);

			if (lista_tamano.size() == 0) {

				System.out.println("Entre el Origen del Vuelo");

				org_vuelo = scanner.nextLine();

				System.out.println("Entre el Destino del Vuelo");
				des_vuelo = scanner.nextLine();

				System.out.println("Entre la Fecha del Vuelo (YYYY-MMMM-DDDD HH:MM:SS");

				fec_vuelo = scanner.nextLine();

				System.out.println("Entre la cantidad de plazas totales del Vuelo");
				String next_scan_plazas_totales = scanner.next();
				int plazas_totales = Integer.parseInt(next_scan_plazas_totales);
				pzt_vuelo = plazas_totales;

				System.out.println("Entre la cantidad de plazas disponibles del Vuelo");
				String next_scan_plazas_disponibles = scanner.next();
				int plazas_disponibles = Integer.parseInt(next_scan_plazas_disponibles);
				pzd_vuelo = plazas_disponibles;

				FileWriter fichero = null;
				PrintWriter pw = null;

				try {
					fichero = new FileWriter("./src/archivo.txt", true);
					pw = new PrintWriter(fichero);

					BufferedReader input = new BufferedReader(new FileReader("./src/archivo.txt"));
					String last = "";
					String line = "";

					while ((line = input.readLine()) != null) {
						last = line;
					}

					String[] parts = last.split("/");

					int id_vuelo = 1;

					if (parts[0] != "") {
						id_vuelo = Integer.parseInt(parts[0]) + 1;
					}

					pw.println(id_vuelo + "/" + cod_vuelo + "/" + org_vuelo + "/" + des_vuelo + "/" + fec_vuelo + "/"
							+ pzt_vuelo + "/" + pzd_vuelo);

					System.out.println("Vuelo insertado correctamente");

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (null != fichero)
							fichero.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}

			} else {
				System.out.println(
						"El vuelo ya existe, no se puede crear un vuelo con el mismo c�digo. Revise sus datos por favor !!!");
			}
		} else {
			System.out.println("El c�digo de vuelo debe de tener 5 Caracteres obligatoriamente !!!");
		}

	}

	public static void insertar_valores_fichero_id(String id) {

		VuelosController lista = new VuelosController();

		String cod_vuelo = "";
		String org_vuelo = "";
		String des_vuelo = "";
		String fec_vuelo = "";
		int pzt_vuelo = 0;
		int pzd_vuelo = 0;

		System.out.println("Entre el C�digo del Vuelo");
		Scanner scanner = new Scanner(System.in);

		cod_vuelo = scanner.nextLine();

		if (cod_vuelo.length() == 5) {

			List<Vuelos> lista_tamano = lista.info_vuelo(cod_vuelo);

			if (lista_tamano.size() == 0) {

				System.out.println("Entre el Origen del Vuelo");

				org_vuelo = scanner.nextLine();

				System.out.println("Entre el Destino del Vuelo");
				des_vuelo = scanner.nextLine();

				System.out.println("Entre la Fecha del Vuelo");

				fec_vuelo = scanner.nextLine();

				System.out.println("Entre la cantidad de plazas totales del Vuelo");
				String next_scan_plazas_totales = scanner.next();
				int plazas_totales = Integer.parseInt(next_scan_plazas_totales);
				pzt_vuelo = plazas_totales;

				System.out.println("Entre la cantidad de plazas disponibles del Vuelo");
				String next_scan_plazas_disponibles = scanner.next();
				int plazas_disponibles = Integer.parseInt(next_scan_plazas_disponibles);
				pzd_vuelo = plazas_disponibles;

				FileWriter fichero = null;
				PrintWriter pw = null;

				try {
					fichero = new FileWriter("./src/archivo.txt", true);
					pw = new PrintWriter(fichero);

					pw.println(id + "/" + cod_vuelo + "/" + org_vuelo + "/" + des_vuelo + "/" + fec_vuelo + "/"
							+ pzt_vuelo + "/" + pzd_vuelo);

					System.out.println("Vuelo insertado correctamente");

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (null != fichero)
							fichero.close();
						System.out.println("Base de datos exportada correctamente");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}

			} else {
				System.out.println(
						"El vuelo ya existe, no se puede crear un vuelo con el mismo c�digo. Revise sus datos por favor !!!");
			}
		} else {
			System.out.println("El c�digo de vuelo debe de tener 5 Caracteres obligatoriamente !!!");
		}

	}

	public static void editarFichero() {

		System.out.println("Entre el ID del Vuelo");
		Scanner scanner = new Scanner(System.in);
		int id_vuelo = Integer.parseInt(scanner.nextLine());

		String rutaAlFichero = "./src/archivo.txt";
		String cadena = id_vuelo + "/";

		Path path = Paths.get(rutaAlFichero);

		try {

			List<String> lineas = Files.readAllLines(path);
			lineas = lineas.stream().filter(linea -> !linea.contains(cadena)).collect(Collectors.toList());
			Files.write(path, lineas);

			insertar_valores_fichero_id(cadena);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void eliminarVueloFichero() {

		System.out.println("Entre el ID del Vuelo");
		Scanner scanner = new Scanner(System.in);
		int id_vuelo = Integer.parseInt(scanner.nextLine());

		String rutaAlFichero = "./src/archivo.txt";
		String cadena = id_vuelo + "/";

		Path path = Paths.get(rutaAlFichero);

		try {

			List<String> lineas = Files.readAllLines(path);
			lineas = lineas.stream().filter(linea -> !linea.contains(cadena)).collect(Collectors.toList());
			Files.write(path, lineas);

			System.out.println("Vuelo de ID: " + id_vuelo + " ha sido eliminado");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void buscarVueloFichero() {
		System.out.println("Entre el ID del Vuelo");
		Scanner scanner = new Scanner(System.in);
		int id_vuelo = Integer.parseInt(scanner.nextLine());

		String rutaAlFichero = "./src/archivo.txt";
		String cadena = id_vuelo + "/";

		Path path = Paths.get(rutaAlFichero);

		try {

			List<String> lineas = Files.readAllLines(path);
			lineas = lineas.stream().filter(linea -> linea.contains(cadena)).collect(Collectors.toList());

			System.out.println("El vuelo buscado es : " + lineas);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
}
