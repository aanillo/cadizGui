package bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cadiz.Entrenador;
import cadiz.Equipo;

public class EquipoService {
private final String tabla = "equipo";
	
	public void guardarEquipo(Connection conexion, Equipo equipo) throws SQLException {
		try {
			PreparedStatement consulta;
			consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(codigo, nombre, estadio, fundacion, divisionActual, temporadasEnPrimera, leyenda) VALUES(?, ?, ?, ?, ?, ?, ?)");
			consulta.setInt(1, equipo.getCodigo());
			consulta.setString(2, equipo.getNombre());
			consulta.setString(3, equipo.getEstadio());
			consulta.setInt(4, equipo.getFundacion());
			consulta.setString(5, equipo.getDivisionActual());
			consulta.setInt(6,equipo.getTemporadasEnPrimera());
			consulta.setString(7, equipo.getLeyenda());
		consulta.executeUpdate();
		} catch(SQLException ex) {
			throw new SQLException(ex);
		}
	}
	
	public Equipo getEquipo(Connection conexion, int codigo) throws SQLException {
		Equipo equipo = null;
		try {
			PreparedStatement consulta = conexion.prepareStatement("SELECT nombre, estadio, fundacion, divisionActual, temporadasEnPrimera, leyenda " + " FROM " + 
					this.tabla + " WHERE codigo = ?");
			consulta.setInt(1, codigo);
			ResultSet resultado = consulta.executeQuery();
			while(resultado.next()) {
				equipo = new Equipo(codigo, 
							resultado.getString("nombre"), 
							resultado.getString("estadio"),
							resultado.getInt("fundacion"),
							resultado.getString("divisionActual"),
							resultado.getInt("temporadasEnPrimera"),
							resultado.getString("leyenda"));
			}
		} catch(SQLException ex) {
			throw new SQLException(ex);
		}
		return equipo;
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
