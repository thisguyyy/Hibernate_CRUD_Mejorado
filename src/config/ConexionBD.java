package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import controller.VuelosController;
import models.Vuelos;

public class ConexionBD {

	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/adat_vuelos";
	private static final String USUARIO = "root";
	private static final String PASS = "";

	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}

	public Connection get_conexion() {

		Connection conexion = null;

		try {

			conexion = (Connection) DriverManager.getConnection(URL, USUARIO, PASS);
			System.out.println("Conexión OK");

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}

		return conexion;

	}
	
	public static void volverMenuPrincipal() {
		System.out.println("Introduce una letra o número para volver al menú principal");
		Scanner scan = new Scanner(System.in);
		String next_scan = scan.next();
		
	}
}
