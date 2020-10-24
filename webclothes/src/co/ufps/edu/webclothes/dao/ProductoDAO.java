package co.ufps.edu.webclothes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.ufps.edu.webclothes.conexion.Conexion;
import co.ufps.edu.webclothes.model.Producto;


public class ProductoDAO {

private Conexion conexion;
	
	private static final String INSERT_PRODUCTO_SQL="INSERT INTO producto(referencia,nombre,descripcioncorta,detalle,valor,palabrasclave,estado,categoria_id,marca_id) VALUES (?,?,?,?,?,?,?,?,?);";
	private static final String DELETE_PRODUCTO_SQL="DELETE FROM producto WHERE id=?;";
	private static final String UPDATE_PRODUCTO_SQL="UPDATE producto SET referencia=?,nombre=?,descripcioncorta=?,detalle=?,valor=?,palabrasclave=?,estado=?,categoria_id=?,marca_id=? WHERE id=?;";
	private static final String SELECT_PRODUCTO_BY_ID="SELECT * FROM producto where id=?;";
	private static final String SELECT_ALL_PRODUCTOS="SELECT * FROM producto;";
	
	public ProductoDAO() {
		this.conexion=Conexion.getConexion();
	}
	
	public void insert(Producto producto) throws SQLException{
		try {
			PreparedStatement preparedStatement= conexion.setPreaparedStatement(INSERT_PRODUCTO_SQL);
			preparedStatement.setString(1, producto.getReferencia());
			preparedStatement.setString(2, producto.getNombre());
			preparedStatement.setString(3, producto.getDescripcion());
			preparedStatement.setString(4, producto.getDetalle());
			preparedStatement.setDouble(5, producto.getValor());
			preparedStatement.setString(6, producto.getPalabrasC()); 
			preparedStatement.setString(7, producto.getEstado());
			preparedStatement.setInt(8, producto.getCategoria_id());
			preparedStatement.setInt(9, producto.getMarca_id());
			conexion.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void delete(int id) throws SQLException{
		try {
			PreparedStatement preparedStatement= (PreparedStatement)conexion.setPreaparedStatement(DELETE_PRODUCTO_SQL);
			preparedStatement.setInt(1,id);
			conexion.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void update(Producto producto)throws SQLException {
		try {
			PreparedStatement preparedStatement= conexion.setPreaparedStatement(UPDATE_PRODUCTO_SQL);
			preparedStatement.setString(1, producto.getReferencia());
			preparedStatement.setString(2, producto.getNombre());
			preparedStatement.setString(3, producto.getDescripcion());
			preparedStatement.setString(4, producto.getDetalle());
			preparedStatement.setDouble(5, producto.getValor());
			preparedStatement.setString(6, producto.getPalabrasC()); 
			preparedStatement.setString(7, producto.getEstado());
			preparedStatement.setInt(8, producto.getCategoria_id());
			preparedStatement.setInt(9, producto.getMarca_id());
			preparedStatement.setInt(10,producto.getId());
			conexion.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public List<Producto> selectAll(){
		List <Producto> productos=new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement= (PreparedStatement)conexion.setPreaparedStatement(SELECT_ALL_PRODUCTOS);
			ResultSet rs= conexion.query();
			
			while(rs.next()) {
				int id= rs.getInt("id");
				String referencia = rs.getString("referencia");
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcioncorta");
				String detalle = rs.getString("detalle");
				Double valor = rs.getDouble("valor");
				String palabras = rs.getString("palabrasclave");
				String estado = rs.getString("estado");
				int cat = rs.getInt("categoria_id");
				int marc = rs.getInt("marca_id"); 
						
				productos.add(new Producto(id,referencia,nombre,descripcion,detalle,palabras,estado,valor,cat,marc));
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return productos;
		
	}

	public Producto select(int id){
		Producto producto=null;
		
		try {
			PreparedStatement preparedStatement= conexion.setPreaparedStatement(SELECT_PRODUCTO_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs= conexion.query();
			
			while(rs.next()) {
				String referencia = rs.getString("referencia");
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcioncorta");
				String detalle = rs.getString("detalle");
				Double valor = rs.getDouble("valor");
				String palabras = rs.getString("palabrasclave");
				String estado = rs.getString("estado");
				int cat = rs.getInt("categoria_id");
				int marc = rs.getInt("marca_id");
				
				producto=new Producto(id,referencia,nombre,descripcion,detalle,palabras,estado,valor,cat,marc);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return producto;
		
	}
}
