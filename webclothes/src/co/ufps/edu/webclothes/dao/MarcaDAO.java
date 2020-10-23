package co.ufps.edu.webclothes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.ufps.edu.webclothes.conexion.Conexion;
import co.ufps.edu.webclothes.model.Marca;


public class MarcaDAO {

private Conexion conexion;
	
	private static final String INSERT_MARCA_SQL="INSERT INTO marca(id,nombre,descripcion) VALUES (?,?,?);";
	private static final String DELETE_MARCA_SQL="DELETE FROM marca WHERE id=?;";
	private static final String UPDATE_MARCA_SQL="UPDATE marca SET id=?,nombre=?,descripcion=? WHERE id=?;";
	private static final String SELECT_MARCA_BY_ID="SELECT * FROM marca where id=?;";
	private static final String SELECT_ALL_MARCAS="SELECT * FROM marca;";
	
	public MarcaDAO() {
		this.conexion=Conexion.getConexion();
	}
	
	public void insert(Marca marca) throws SQLException{
		try {
			PreparedStatement preparedStatement= conexion.setPreaparedStatement(INSERT_MARCA_SQL);
			preparedStatement.setInt(1, marca.getId());
			preparedStatement.setString(2, marca.getNombre());
			preparedStatement.setString(3, marca.getDescripcion());
			conexion.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void delete(int id) throws SQLException{
		try {
			PreparedStatement preparedStatement= (PreparedStatement)conexion.setPreaparedStatement(DELETE_MARCA_SQL);
			preparedStatement.setInt(1,id);
			conexion.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void update(Marca marca)throws SQLException {
		try {
			PreparedStatement preparedStatement= conexion.setPreaparedStatement(UPDATE_MARCA_SQL);
			preparedStatement.setInt(1, marca.getId());
			preparedStatement.setString(2, marca.getNombre());
			preparedStatement.setString(3, marca.getDescripcion());
			preparedStatement.setInt(4,marca.getId());
			conexion.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public List<Marca> selectAll(){
		List <Marca> marcas=new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement= (PreparedStatement)conexion.setPreaparedStatement(SELECT_ALL_MARCAS);
			ResultSet rs= conexion.query();
			
			while(rs.next()) {
				int id= rs.getInt("id");
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");
						
				marcas.add(new Marca(id,nombre,descripcion));
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return marcas;
		
	}

	public Marca select(int id){
		Marca marca=null;
		
		try {
			PreparedStatement preparedStatement= conexion.setPreaparedStatement(SELECT_MARCA_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs= conexion.query();
			
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");
				marca = new Marca(id,nombre,descripcion);
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return marca;
		
	}
}
