package bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cadiz.Entrenador;
import cadiz.Jugador;

public class EntrenadorService {
	private final String tabla = "entrenador";
	
	public void guardarEntrenador(Connection conexion, Entrenador entrenador) throws SQLException {
		try {
			PreparedStatement consulta;
			consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(codigo, nombre, edad, nacionalidad) VALUES(?, ?, ?, ?)");
			consulta.setInt(1, entrenador.getCodigo());
			consulta.setString(2, entrenador.getNombre());
			consulta.setInt(3, entrenador.getEdad());
			consulta.setString(4, entrenador.getNacionalidad());
		consulta.executeUpdate();
		} catch(SQLException ex) {
			throw new SQLException(ex);
		}
	}
	
	public Entrenador getEntrenador(Connection conexion, int codigo) throws SQLException {
		Entrenador entrenador = null;
		try {
			PreparedStatement consulta = conexion.prepareStatement("SELECT nombre, edad, nacionalidad " + " FROM " + 
					this.tabla + " WHERE codigo = ?");
			consulta.setInt(1, codigo);
			ResultSet resultado = consulta.executeQuery();
			while(resultado.next()) {
				entrenador = new Entrenador(codigo, 
							resultado.getString("nombre"), 
							resultado.getInt("edad"), 
							resultado.getString("nacionalidad"));
			}
		} catch(SQLException ex) {
			throw new SQLException(ex);
		}
		return entrenador;
	}
	
	public void remove(Connection conexion, Entrenador entrenador) throws SQLException {
		try {
			PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE codigo = ? ");
			consulta.setInt(1, entrenador.getCodigo());
			consulta.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}
	
}
