package cadiz;

public class Jugador {
	private int codigo;
	private String nombre;
	private String posicion;
	private int edad;
	private int dorsal;
	private String nacionalidad;
	
	public Jugador() {
		
	}
	
	

	public Jugador(int codigo, String nombre, String posicion, int edad, int dorsal, String nacionalidad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.posicion = posicion;
		this.edad = edad;
		this.dorsal = dorsal;
		this.nacionalidad = nacionalidad;
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

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", posicion=" + posicion + ", edad=" + edad + ", dorsal=" + dorsal
				+ ", nacionalidad=" + nacionalidad + "]";
	}
	
	
}
