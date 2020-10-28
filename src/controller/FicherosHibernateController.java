package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.Vuelos;

public class FicherosHibernateController {
	
	
	public static void fichero_a_bd() {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		ArrayList<String> lista_vuelos_fichero = new ArrayList();

		try {
			archivo = new File("./src/archivo.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null)
				lista_vuelos_fichero.add(linea);
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

		for (int i = 0; i < lista_vuelos_fichero.size(); i++) {

			String[] parts = lista_vuelos_fichero.get(i).split("/");
			String id_vuelo = parts[0]; // id
			String codigo_vuelo = parts[1]; // cod_vuelo
			String origen_vuelo = parts[2]; // origen
			String destino_vuelo = parts[3]; // destino
			String fecha_vuelo = parts[4]; // fecha
			int plazas_totales = Integer.parseInt(parts[5]); // plazas totales
			int plazas_disponibles = Integer.parseInt(parts[6]); // plazas disponibles

			VuelosHibernateController insertarVuelo = new VuelosHibernateController();
			insertarVuelo.insertar_vuelo(codigo_vuelo, origen_vuelo, destino_vuelo, fecha_vuelo, plazas_totales,plazas_disponibles);

		}
		System.out.println("Nuevos vuelos insertados en la BD");
	}
	
	public static void bd_a_fichero() {

		VuelosHibernateController lista = new VuelosHibernateController();
		List<Vuelos> lista_vuelos = lista.listarVuelos();

		Iterator<Vuelos> iterador = lista_vuelos.iterator();

		FileWriter fichero = null;
		PrintWriter pw = null;

		try {
			fichero = new FileWriter("./src/archivo.txt");
			pw = new PrintWriter(fichero);

			while (iterador.hasNext()) {
				Vuelos vuelos = new Vuelos();
				vuelos = iterador.next();
				pw.println(vuelos.getId() + "/" + vuelos.getCodigo_vuelo() + "/" + vuelos.getOrigen() + "/"
						+ vuelos.getDestino() + "/" + vuelos.getFecha() + "/" + vuelos.getPlazas_totales() + "/"
						+ vuelos.getPlazas_disponibles());
			}
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

	}
	
	public static void bd_a_bd_hibernate(){
		
		VuelosController vueloBD = new VuelosController();
		VuelosHibernateController vueloHB = new VuelosHibernateController();
				
		List<Vuelos> lista_vuelos = vueloBD.listarVuelos1();
		
		Iterator<Vuelos> iterador = lista_vuelos.iterator();

		while (iterador.hasNext()) {
			Vuelos vuelos = new Vuelos();
			vuelos = iterador.next();
			
			vueloHB.insertar_vuelo(vuelos.getCodigo_vuelo(), vuelos.getOrigen(), vuelos.getDestino(), vuelos.getFecha(), vuelos.getPlazas_totales(), vuelos.getPlazas_disponibles());

			System.out.println("Vuelo: "+vuelos.getCodigo_vuelo()+ " insertado en BD Hibernate");

		}
		
	}
	
	public static void bd_hibernate_a_bd() {

		VuelosController vueloBD = new VuelosController();
		VuelosHibernateController vueloHB = new VuelosHibernateController();
				
		List<Vuelos> lista_vuelos = vueloHB.listarVuelos();
		
		Iterator<Vuelos> iterador = lista_vuelos.iterator();

		while (iterador.hasNext()) {
			Vuelos vuelos = new Vuelos();
			vuelos = iterador.next();
			
			vueloBD.insertar_vuelo(vuelos.getCodigo_vuelo(), vuelos.getOrigen(), vuelos.getDestino(), vuelos.getFecha(), vuelos.getPlazas_totales(), vuelos.getPlazas_disponibles());

			System.out.println("Vuelo: "+vuelos.getCodigo_vuelo()+ " insertado en BD Normal");

		}
		
	}
	

}
