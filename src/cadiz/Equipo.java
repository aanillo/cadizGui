package cadiz;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	private int codigo;
	private String nombre;
	private String estadio;
	private int fundacion;
	private String divisionActual;
	private int temporadasEnPrimera;
	private String leyenda;
	private Entrenador entrenador;
	private static List<Jugador> plantilla = new ArrayList<Jugador>();
	
	public Equipo() {
		
	}
	


	public Equipo(int codigo, String nombre, String estadio, int fundacion, String divisionActual, int temporadasEnPrimera, String leyenda) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.estadio = estadio;
		this.fundacion = fundacion;
		this.divisionActual = divisionActual;
		this.temporadasEnPrimera = temporadasEnPrimera;
		this.leyenda = leyenda;
	}


	

	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getEstadio() {
		return estadio;
	}




	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}




	public int getFundacion() {
		return fundacion;
	}



	public void setFundacion(int fundacion) {
		this.fundacion = fundacion;
	}

	

	public Entrenador getEntrenador() {
		return entrenador;
	}



	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}



	public String getDivisionActual() {
		return divisionActual;
	}



	public void setDivisionActual(String divisionActual) {
		this.divisionActual = divisionActual;
	}


	

	public int getTemporadasEnPrimera() {
		return temporadasEnPrimera;
	}



	public void setTemporadasEnPrimera(int temporadasEnPrimera) {
		this.temporadasEnPrimera = temporadasEnPrimera;
	}



	public String getLeyenda() {
		return leyenda;
	}



	public void setLeyenda(String leyenda) {
		this.leyenda = leyenda;
	}



	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", estadio=" + estadio + ", fundacion=" + fundacion + ", divisionActual="
				+ divisionActual + ", temporadasEnPrimera=" + temporadasEnPrimera + ", leyenda=" + leyenda + "]";
	}



	public static void introducirJugador(Jugador jugador) {
		plantilla.add(jugador);
	}
	
	public static void mostrarJugadores(List<Jugador> jugadores) {
		for(Jugador j : jugadores) {
			System.out.println(j + " ");
		}
	}
	
	public static void mostrarEntrenador(Entrenador entrenador) {
		System.out.println(entrenador.toString());
	}
	

}
