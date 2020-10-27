package co.ufps.edu.webclothes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.ufps.edu.webclothes.conexion.Conexion;
import co.ufps.edu.webclothes.model.Admin;

public class AdminDAO {
	
	private Conexion conexion;
	private static final String SELECT_ALL_ADMINS="SELECT * FROM categoria;";
	
	public AdminDAO() {
		this.conexion=Conexion.getConexion();
	}
	
	public List<Admin> selectAll(){
		List <Admin> admins=new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement= (PreparedStatement)conexion.setPreaparedStatement(SELECT_ALL_ADMINS);
			ResultSet rs= conexion.query();
			
			while(rs.next()) {
				
				String user = rs.getString("user");
				String contra = rs.getString("contra");
						
				admins.add(new Admin(user,contra));
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return admins;
		
	}

}
