package cadiz;

public class Entrenador {
	private int codigo;
	private String nombre;
	private int edad;
	private String nacionalidad;
	
	public Entrenador() {
		
	}

	public Entrenador(int codigo, String nombre, int edad, String nacionalidad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.edad = edad;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return "Entrenador [nombre=" + nombre + ", edad=" + edad + ", nacionalidad=" + nacionalidad + "]";
	}
	
	
}
