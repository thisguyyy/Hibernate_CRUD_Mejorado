package main;

import java.util.Iterator;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import config.ConexionBD;
import controller.FicherosBDController;
import controller.FicherosHibernateController;
import controller.VuelosController;
import controller.VuelosHibernateController;
import models.Vuelos;

public class main {

	public static void main(String[] args) {

		menu_principal();		
		
	}
	
	public static void menu_principal() {
		
		System.out.println("");

		System.out.println("====== SELECCIONE TIPO CONEXIÓN ======");
		System.out.println("");
		System.out.println("1- Por BD");
		System.out.println("2- Hibernate");
		System.out.println("3- Ficheros");
		System.out.println("4- Exportar");
		System.out.println("");

		System.out.println("Elija la opción del tipo de conexión");
		Scanner scan = new Scanner(System.in);
		String next_scan = scan.next();
		int opcion = Integer.parseInt(next_scan);

		seleccionarConexion(opcion);
	}

	public static void seleccionarConexion(int opcion) {
		
		boolean volver = false;
		
		while (!volver) {
			switch (opcion) {
				case 1: {
	
					System.out.println("====== BASE DE DATOS ======");
					System.out.println("");
					System.out.println("1- Listar Vuelos");
					System.out.println("2- Mostrar Información de Vuelo");
					System.out.println("3- Insertar Vuelo");
					System.out.println("4- Eliminar Vuelo");
					System.out.println("5- Modificar Vuelo");	
					
					System.out.println("13- FINALIZAR EL PROGRAMA");
	
					System.out.println("Entre el Número de Método a Ejecutar");
					Scanner scan = new Scanner(System.in);
					String next_scan = scan.next();
					int metodo = Integer.parseInt(next_scan);
	
					seleccionarMetodo(metodo);
	
				}
			
				case 2: {
					System.out.println("====== HIBERNATE ======");
					System.out.println("");
					System.out.println("14- Listar Vuelos");
					System.out.println("15- Mostrar Información de Vuelo");
					System.out.println("16- Insertar Vuelo");
					System.out.println("17- Eliminar Vuelo");
					System.out.println("18- Modificar Vuelo");
					System.out.println("");
	
					System.out.println("13- FINALIZAR EL PROGRAMA");
	
					System.out.println("Entre el Número de Método a Ejecutar");
					Scanner scan = new Scanner(System.in);
					String next_scan = scan.next();
					int metodo = Integer.parseInt(next_scan);
	
					seleccionarMetodo(metodo);	
				}
				case 3: {
					
					System.out.println("====== FICHEROS ======");
					System.out.println("");
					System.out.println("6- Leer fichero");
					System.out.println("7- Eliminar Valores Fichero");
					System.out.println("8- Buscar Vuelo en Fichero");
					System.out.println("9- Insertar Valores Fichero");
					System.out.println("10- Editar Valores Fichero");
					System.out.println("");
					
					System.out.println("13- FINALIZAR EL PROGRAMA");
					
					System.out.println("Entre el Número de Método a Ejecutar");
					Scanner scan = new Scanner(System.in);
					String next_scan = scan.next();
					int metodo = Integer.parseInt(next_scan);
	
					seleccionarMetodo(metodo);	
				}
				
				case 4:{
					
					System.out.println("====== EXPORTAR (BD + Ficheros) ======");
					System.out.println("");
					System.out.println("11- Exportar BD a Fichero");
					System.out.println("12- Exportar de fichero a BD");
					System.out.println("");
	
					System.out.println("====== EXPORTAR (BD Hibernate + Ficheros) ======");
					System.out.println("");
					System.out.println("19- Exportar BD a Fichero Hibernate");
					System.out.println("20- Exportar de fichero Hibernate a BD");
					System.out.println("21- Exportar de bdnormal a Hibernate");
					System.out.println("22- Exportar de Hibernate a bd");
					System.out.println("");System.out.println("13- FINALIZAR EL PROGRAMA");
	
					System.out.println("Entre el Número de Método a Ejecutar");
					Scanner scan = new Scanner(System.in);
					String next_scan = scan.next();
					int metodo = Integer.parseInt(next_scan);
	
					seleccionarMetodo(metodo);	
	
				}
				
			}
		}

	}

	public static void seleccionarMetodo(int metodo) {

		VuelosHibernateController metodos = new VuelosHibernateController();
		FicherosHibernateController ficheros = new FicherosHibernateController();
		VuelosController metodos1 = new VuelosController();
		FicherosBDController ficheroBD = new FicherosBDController();

		switch (metodo) {
		case 1: {
			metodos1.listarVuelos();

			volverMenuPrincipal();
			break;

		}
		case 2: {
			metodos1.mostrarInfoVuelo();

			volverMenuPrincipal();
			break;
		}
		case 3: {
			metodos1.insertarVuelos();

			volverMenuPrincipal();
			break;
		}
		case 4: {
			metodos1.eliminarVuelo();

			volverMenuPrincipal();
			break;
		}
		case 5: {
			metodos1.editarVuelo();

			volverMenuPrincipal();
			break;
		}
		case 6: {
			metodos1.leerFichero();

			volverMenuPrincipal();
			break;
		}
		case 7: {
			metodos1.eliminarVueloFichero();

			volverMenuPrincipal();
			break;
		}
		case 8: {
			metodos1.buscarVueloFichero();

			volverMenuPrincipal();
			break;
		}
		case 9: {
			metodos1.insertarFichero();

			volverMenuPrincipal();
			break;
		}
		case 10: {
			metodos1.editarFichero();

			volverMenuPrincipal();
			break;
		}
		case 11: {
			ficheroBD.bd_a_fichero();

			volverMenuPrincipal();
			break;
		}
		case 12: {
			ficheroBD.fichero_a_bd();

			volverMenuPrincipal();
			break;
		}
		case 13: {
			System.exit(0);
			break;
		}
		case 14: {
			metodos.print_listarVuelos();

			volverMenuPrincipal();
			break;

		}
		case 15: {

			metodos.print_info_vuelo();

			volverMenuPrincipal();
			break;

		}
		case 16: {

			metodos.pedir_valores_insertar_vuelo();

			volverMenuPrincipal();
			break;

		}
		case 17: {

			metodos.pedir_id_eliminarVuelo();

			volverMenuPrincipal();
			break;

		}

		case 18: {

			metodos.pedir_valores_editar_vuelo();

			volverMenuPrincipal();
			break;

		}

		case 19: {
			ficheros.bd_a_fichero();
			volverMenuPrincipal();
			break;
		}

		case 20: {

			ficheros.fichero_a_bd();
			volverMenuPrincipal();
			break;

		}

		case 21: {

			ficheros.bd_a_bd_hibernate();
			volverMenuPrincipal();
			break;

		}

		case 22: {

			ficheros.bd_hibernate_a_bd();
			volverMenuPrincipal();
			break;

		}
		}
	}

	public static void volverMenuPrincipal() {
		
		System.out.println("");
		System.out.println(" ********************************* ");
		
		System.out.println("Introduce una letra para volver al menú Principal");
		
		Scanner scan = new Scanner(System.in);
		String next_scan = scan.nextLine();
		
		menu_principal();
				

	}

}