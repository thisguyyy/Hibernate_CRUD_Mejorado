package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import models.Vuelos;

public class VuelosHibernateController {
	
	public List<Vuelos> listarVuelos(){
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		List<Vuelos> lista_vuelos = new ArrayList<Vuelos>();
		
		Query qBuscar = s.createQuery("from Vuelos");
		List resultsBuscar = qBuscar.getResultList();
		Iterator empIteratorBuscar = resultsBuscar.iterator();
		while (empIteratorBuscar.hasNext()) {
			Vuelos vuelo = (Vuelos) empIteratorBuscar.next();			
			lista_vuelos.add(vuelo);
		}

		s.beginTransaction();
		s.getTransaction().commit();
		s.close();
		
		return lista_vuelos;
	}
	
	
	public void print_listarVuelos() {
		
		List<Vuelos> lista_vuelos = this.listarVuelos();

		Iterator<Vuelos> iterador = lista_vuelos.iterator();

		while (iterador.hasNext()) {
			Vuelos vuelos = new Vuelos();
			vuelos = iterador.next();

			System.out.println("ID:" + vuelos.getId());
			System.out.println("CÓDIGO: " + vuelos.getCodigo_vuelo());
			System.out.println("ORIGEN: " + vuelos.getOrigen());
			System.out.println("DESTINO: " + vuelos.getDestino());
			System.out.println("FECHA: " + vuelos.getFecha());
			System.out.println("PLAZAS TOTALES: " + vuelos.getPlazas_totales());
			System.out.println("PLAZAS DISPONIBLES:" + vuelos.getPlazas_disponibles());

			System.out.println(" **************************** ");

		}
	}
	
	public List<Vuelos> info_vuelo(int id){

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		List<Vuelos> lista_vuelos = new ArrayList<Vuelos>();
		
		Query qBuscar = s.createQuery("from Vuelos where ID = "+ id);
		List resultsBuscar = qBuscar.getResultList();
		Iterator empIteratorBuscar = resultsBuscar.iterator();
		while (empIteratorBuscar.hasNext()) {
			Vuelos vuelo = (Vuelos) empIteratorBuscar.next();			
			lista_vuelos.add(vuelo);
		}

		s.beginTransaction();
		s.getTransaction().commit();
		s.close();
		
		return lista_vuelos;
	}
	
	public List<Vuelos> existe_info_vuelo(String cod_vuelo){

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		List<Vuelos> lista_vuelos = new ArrayList<Vuelos>();
		
		Query qBuscar = s.createQuery("from Vuelos where ID = "+"'"+ cod_vuelo + "'");
		List resultsBuscar = qBuscar.getResultList();
		Iterator empIteratorBuscar = resultsBuscar.iterator();
		while (empIteratorBuscar.hasNext()) {
			Vuelos vuelo = (Vuelos) empIteratorBuscar.next();			
			lista_vuelos.add(vuelo);
		}

		s.beginTransaction();
		s.getTransaction().commit();
		s.close();
		
		return lista_vuelos;
	}
	
	public List<Vuelos> existe_info_vuelo_por_ID(int id){

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		List<Vuelos> lista_vuelos = new ArrayList<Vuelos>();
		
		Query qBuscar = s.createQuery("from Vuelos where ID = "+id);
		List resultsBuscar = qBuscar.getResultList();
		Iterator empIteratorBuscar = resultsBuscar.iterator();
		while (empIteratorBuscar.hasNext()) {
			Vuelos vuelo = (Vuelos) empIteratorBuscar.next();			
			lista_vuelos.add(vuelo);
		}

		s.beginTransaction();
		s.getTransaction().commit();
		s.close();
		
		return lista_vuelos;
	}
	
	public void print_info_vuelo() {
		
		System.out.println("Entre el ID del Vuelo");

		Scanner entradaEscaner = new Scanner(System.in);
		
		List<Vuelos> lista_vuelos = info_vuelo(entradaEscaner.nextInt());

		Iterator<Vuelos> iterador = lista_vuelos.iterator();

		while (iterador.hasNext()) {
			Vuelos vuelos = new Vuelos();
			vuelos = iterador.next();

			System.out.println("ID:" + vuelos.getId());
			System.out.println("CÓDIGO: " + vuelos.getCodigo_vuelo());
			System.out.println("ORIGEN: " + vuelos.getOrigen());
			System.out.println("DESTINO: " + vuelos.getDestino());
			System.out.println("FECHA: " + vuelos.getFecha());
			System.out.println("PLAZAS TOTALES: " + vuelos.getPlazas_totales());
			System.out.println("PLAZAS DISPONIBLES:" + vuelos.getPlazas_disponibles());

			System.out.println(" **************************** ");

		}
	}
	
	
	public void insertar_vuelo(String codigo_vuelo, String origen,String destino, String fecha, int plazas_totales,int plazas_disponibles){
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();	
		
		Vuelos vuelo = new Vuelos();
		vuelo.setCodigo_vuelo(codigo_vuelo);
		vuelo.setOrigen(origen);
		vuelo.setDestino(destino);
		vuelo.setFecha(fecha);
		vuelo.setPlazas_totales(plazas_totales);
		vuelo.setPlazas_disponibles(plazas_disponibles);
		
		s.save(vuelo);
		s.beginTransaction().commit();
		s.close();
		
	}
	
	public void pedir_valores_insertar_vuelo() {

		String cod_vuelo = "";
		String org_vuelo = "";
		String des_vuelo = "";
		String fec_vuelo = "";
		int pzt_vuelo = 0;
		int pzd_vuelo = 0;

		System.out.println("Entre el Código del Vuelo (TIENE QUE TENER 5 CARACTERES)");
		Scanner scanner = new Scanner(System.in);

		cod_vuelo = scanner.nextLine();

		if (cod_vuelo.length() == 5) {

			List<Vuelos> lista_tamano = existe_info_vuelo(cod_vuelo);

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

				insertar_vuelo(cod_vuelo, org_vuelo, des_vuelo, fec_vuelo, pzt_vuelo, pzd_vuelo);

				System.out.println("Vuelo insertado correctamente");
				

			} else {
				System.out.println(
						"El vuelo ya existe, no se puede crear un vuelo con el mismo código. Revise sus datos por favor !!!");
			}
		} else {
			System.out.println("El código de vuelo debe de tener 5 Caracteres obligatoriamente !!!");
		}

	}


	public void eliminarVuelo(String codigo) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();	
		
		s.beginTransaction();
		
		Query q = s.createQuery("delete Vuelos where CODIGO_VUELO = :codigo");
		
		q.setParameter("codigo", codigo);
		q.executeUpdate();
		s.getTransaction().commit();
		
	}

	public void pedir_id_eliminarVuelo() {
		
		System.out.println("Entre el Código del Vuelo");
		Scanner scan = new Scanner(System.in);
		String next_scan = scan.nextLine();
		String codigo_vuelo = next_scan;
		
		eliminarVuelo(codigo_vuelo);
		System.out.println("Vuelo eliminado correctamente");
		

	}	
	
	public void pedir_valores_editar_vuelo(){
		
		System.out.println("Entre el ID del Vuelo");
		Scanner scanner = new Scanner(System.in);
		int id_vuelo = Integer.parseInt(scanner.nextLine());

		List<Vuelos> lista_tamano = existe_info_vuelo_por_ID(id_vuelo);

		if (lista_tamano.size() == 1) {

			System.out.println("Entre el Código del Vuelo a modificar (5 CARACTERES)");
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

			editar_vuelo(id_vuelo, cod_vuelo, org_vuelo, des_vuelo, fec_vuelo, pzt_vuelo,pzd_vuelo);
			
			System.out.println("Vuelo editado correctamente");			

		} else {
			System.out.println("No existe vuelo asociado para el ID");
		}
				
	}
	
	public void editar_vuelo(int id_vuelo,String codigo_vuelo, String origen,String destino, String fecha, int plazas_totales,int plazas_disponibles) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();	
		
		s.beginTransaction();
		Query q = s.createQuery("update Vuelos set CODIGO_VUELO = :codigo_vuelo, ORIGEN = :origen, DESTINO = :destino, FECHA = :fecha, "
				+ "PLAZAS_TOTALES =:plazas_totales, PLAZAS_DISPONIBLES =:plazas_disponibles where ID = :id_vuelo");
		
		q.setParameter("id_vuelo", id_vuelo);
		q.setParameter("codigo_vuelo", codigo_vuelo);
		q.setParameter("origen", origen);
		q.setParameter("destino", destino);
		q.setParameter("fecha", fecha);
		q.setParameter("plazas_totales", plazas_totales);
		q.setParameter("plazas_disponibles", plazas_disponibles);
		
		q.executeUpdate();
		s.getTransaction().commit();
	}

	
	
	
}
