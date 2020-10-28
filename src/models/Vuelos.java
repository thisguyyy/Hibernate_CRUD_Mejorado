package models;

import java.util.Date;

public class Vuelos {

	private int id;
	private String codigo_vuelo;
	private String origen;
	private String destino;
	private String fecha;
	private Integer plazas_totales;
	private Integer plazas_disponibles;
	
	public Vuelos() {
		super();		
	}

	public String getCodigo_vuelo() {
		return codigo_vuelo;
	}

	public void setCodigo_vuelo(String codigo_vuelo) {
		this.codigo_vuelo = codigo_vuelo;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}	

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getPlazas_totales() {
		return plazas_totales;
	}

	public void setPlazas_totales(Integer plazas_totales) {
		this.plazas_totales = plazas_totales;
	}

	public Integer getPlazas_disponibles() {
		return plazas_disponibles;
	}

	public void setPlazas_disponibles(Integer plazas_disponibles) {
		this.plazas_disponibles = plazas_disponibles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
