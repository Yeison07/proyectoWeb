package co.ufps.edu.webclothes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.ufps.edu.webclothes.conexion.Conexion;
import co.ufps.edu.webclothes.model.Imagen;


public class ImagenDAO {

	Conexion conexion;
	
	private static final String SELECT_IMAGE_BY_ID="SELECT * FROM imagen where idimagen=?;";
	private static final String SELECT_ALL_IMAGES="SELECT * FROM imagen;";
	
	public ImagenDAO() {
		this.conexion=Conexion.getConexion();
		
	}
	
	public List<Imagen> selectAll(){
		
		List<Imagen> list= new ArrayList<>();
		try {
			PreparedStatement preparedStatement= (PreparedStatement)conexion.setPreaparedStatement(SELECT_ALL_IMAGES);
			ResultSet rs= conexion.query();
			
			while (rs.next()) {
				int id=rs.getInt(1);
				
				String direccion=rs.getString(2);
				
				Imagen imagen = new Imagen(id,direccion);
				list.add(imagen);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Imagen select(int id){
		Imagen imagen=null;
		
		try {
			PreparedStatement preparedStatement= conexion.setPreaparedStatement(SELECT_IMAGE_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs= conexion.query();
			
			while(rs.next()) {
				String direccion = rs.getString("img");
				
				imagen= new Imagen(id,direccion);
				
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return imagen;
		
	}

}
