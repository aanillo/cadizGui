package bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cadiz.Jugador;


public class JugadorService {
	private final String tabla = "jugador";
	
	public void guardarJugador(Connection conexion, Jugador jugador) throws SQLException {
		try {
			PreparedStatement consulta;
			consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(codigo, nombre, posicion, edad, dorsal, nacionalidad) VALUES(?, ?, ?, ?, ?, ?)");
			consulta.setInt(1, jugador.getCodigo());
			consulta.setString(2, jugador.getNombre());
			consulta.setString(3, jugador.getPosicion());
			consulta.setInt(4, jugador.getEdad());
			consulta.setInt(5, jugador.getDorsal());
			consulta.setString(6, jugador.getNacionalidad());
		consulta.executeUpdate();
		} catch(SQLException ex) {
			throw new SQLException(ex);
		}
	}
	
	public Jugador getJugador(Connection conexion, int codigo) throws SQLException {
		Jugador jugador = null;
		try {
			PreparedStatement consulta = conexion.prepareStatement("SELECT nombre, posicion, edad, dorsal, nacionalidad " + " FROM " + 
					this.tabla + " WHERE codigo = ?");
			consulta.setInt(1, codigo);
			ResultSet resultado = consulta.executeQuery();
			while(resultado.next()) {
				jugador = new Jugador(codigo, 
							resultado.getString("nombre"), 
							resultado.getString("posicion"), 
							resultado.getInt("edad"), 
							resultado.getInt("dorsal"), 
							resultado.getString("nacionalidad"));
			}
		} catch(SQLException ex) {
			throw new SQLException(ex);
		}
		return jugador;
	}
	
	public void remove(Connection conexion, Jugador jugador) throws SQLException {
		try {
			PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE codigo = ? ");
			consulta.setInt(1, jugador.getCodigo());
			consulta.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}
	
	public List<Jugador> getJugadores(Connection conexion) throws SQLException {
		List<Jugador> jugadores = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion.prepareStatement("SELECT codigo, nombre, posicion, edad, dorsal, nacionalidad " + " FROM " + this.tabla);
			ResultSet resultado = consulta.executeQuery();
			while(resultado.next()) {
				jugadores.add(new Jugador(resultado.getInt("codigo"),
						resultado.getString("nombre"),
						resultado.getString("posicion"),
						resultado.getInt("edad"),
						resultado.getInt("dorsal"),
						resultado.getString("nacionalidad")));
			}
		} catch(SQLException ex) {
			throw new SQLException(ex);
		}
		return jugadores;
	}
}
