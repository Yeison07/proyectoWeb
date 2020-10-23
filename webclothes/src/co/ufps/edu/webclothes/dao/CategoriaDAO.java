package co.ufps.edu.webclothes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.ufps.edu.webclothes.conexion.Conexion;
import co.ufps.edu.webclothes.model.Categoria;


public class CategoriaDAO {
	
private Conexion conexion;
	
	private static final String INSERT_CATEGORIA_SQL="INSERT INTO categoria(id,descripcion,estado) VALUES (?,?,?);";
	private static final String DELETE_CATEGORIA_SQL="DELETE FROM categoria WHERE id=?;";
	private static final String UPDATE_CATEGORIA_SQL="UPDATE categoria SET id=?,descripcion=?,estado=? WHERE id=?;";
	private static final String SELECT_CATEGORIA_BY_ID="SELECT * FROM categoria where id=?;";
	private static final String SELECT_ALL_CATEGORIAS="SELECT * FROM categoria;";
	
	public CategoriaDAO() {
		this.conexion=Conexion.getConexion();
	}
	
	public void insert(Categoria categoria) throws SQLException{
		try {
			PreparedStatement preparedStatement= conexion.setPreaparedStatement(INSERT_CATEGORIA_SQL);
			preparedStatement.setInt(1, categoria.getId());
			preparedStatement.setString(2, categoria.getDescripcion());
			preparedStatement.setString(3, categoria.getEstado());
			conexion.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void delete(int id) throws SQLException{
		try {
			PreparedStatement preparedStatement= (PreparedStatement)conexion.setPreaparedStatement(DELETE_CATEGORIA_SQL);
			preparedStatement.setInt(1,id);
			conexion.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void update(Categoria categoria)throws SQLException {
		try {
			PreparedStatement preparedStatement= conexion.setPreaparedStatement(UPDATE_CATEGORIA_SQL);
			preparedStatement.setInt(1, categoria.getId());
			preparedStatement.setString(3, categoria.getDescripcion());
			preparedStatement.setString(2, categoria.getEstado());
			preparedStatement.setInt(4,categoria.getId());
			conexion.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public List<Categoria> selectAll(){
		List <Categoria> categorias=new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement= (PreparedStatement)conexion.setPreaparedStatement(SELECT_ALL_CATEGORIAS);
			ResultSet rs= conexion.query();
			
			while(rs.next()) {
				int id= rs.getInt("id");
				String descripcion = rs.getString("nombre");
				String estado = rs.getString("descripcion");
						
				categorias.add(new Categoria(id,descripcion,estado));
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return categorias;
		
	}

	public Categoria select(int id){
		Categoria categoria=null;
		
		try {
			PreparedStatement preparedStatement= conexion.setPreaparedStatement(SELECT_CATEGORIA_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs= conexion.query();
			
			while(rs.next()) {
				String descripcion = rs.getString("descripcion");
				String estado = rs.getString("estado");
				categoria = new Categoria(id,descripcion,estado);
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return categoria;
		
	}
	
	
	
	
	}
	
	
	
	
	
	
	
	
	

