package co.ufps.edu.webclothes.dao;

import java.util.*;
import java.sql.*;

import co.ufps.edu.webclothes.conexion.Conexion;
import co.ufps.edu.webclothes.model.Empresa;

public class EmpresaDAO {

private Conexion conexion;
	
	private static final String INSERT_EMPRESA_SQL="INSERT INTO empresa(nombre,quienessomos,emailcontacto,direccion,telefonocontacto,facebook,twitter,instagram) VALUES (?,?,?,?,?,?,?,?);";
	private static final String DELETE_EMPRESA_SQL="DELETE FROM empresa WHERE id=?;";
	private static final String UPDATE_EMPRESA_SQL="UPDATE empresa SET nombre=?,quienessomos=?,emailcontacto=?,direccion=?,telefonocontacto=?,facebook=?,twitter=?,instagram=? WHERE id=?;";
	private static final String SELECT_EMPRESA_BY_ID="SELECT * FROM empresa where id=?;";
	private static final String SELECT_ALL_EMPRESAS="SELECT * FROM empresa;";
	
	public EmpresaDAO() {
		this.conexion=Conexion.getConexion();
	}
	
	public void insert(Empresa empresa) throws SQLException{
		try {
			PreparedStatement preparedStatement= conexion.setPreaparedStatement(INSERT_EMPRESA_SQL);
			preparedStatement.setString(1, empresa.getNombre());
			preparedStatement.setString(2, empresa.getQuienesS());
			preparedStatement.setString(3, empresa.getEmailC());
			preparedStatement.setString(4, empresa.getDireccion());
			preparedStatement.setString(5, empresa.getTelefonoC());
			preparedStatement.setString(6, empresa.getFace());
			preparedStatement.setString(7, empresa.getTwitt());
			preparedStatement.setString(8, empresa.getInsta());
			conexion.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void delete(int id) throws SQLException{
		try {
			PreparedStatement preparedStatement= (PreparedStatement)conexion.setPreaparedStatement(DELETE_EMPRESA_SQL);
			preparedStatement.setInt(1,id);
			conexion.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void update(Empresa empresa)throws SQLException {
		try {
			PreparedStatement preparedStatement= conexion.setPreaparedStatement(UPDATE_EMPRESA_SQL);
			preparedStatement.setString(1, empresa.getNombre());
			preparedStatement.setString(2, empresa.getQuienesS());
			preparedStatement.setString(3, empresa.getEmailC());
			preparedStatement.setString(4, empresa.getDireccion());
			preparedStatement.setString(5, empresa.getTelefonoC());
			preparedStatement.setString(6, empresa.getFace());
			preparedStatement.setString(7, empresa.getTwitt());
			preparedStatement.setString(8, empresa.getInsta());
			preparedStatement.setInt(9,empresa.getId());
			conexion.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public List<Empresa> selectAll(){
		List <Empresa> empresas=new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement= (PreparedStatement)conexion.setPreaparedStatement(SELECT_ALL_EMPRESAS);
			ResultSet rs= conexion.query();
			
			while(rs.next()) {
				int id= rs.getInt("id");
				String nombre = rs.getString("nombre");
				String quienesS = rs.getString("quienessomos");
				String emailC = rs.getString("emailcontacto");
				String direccion = rs.getString("direccion");
				String telefonoC = rs.getString("telefonocontacto");
				String face = rs.getString("facebook");
				String twitt =rs.getString ("twitter");
				String insta =rs.getString ("instagram");
				
				
				empresas.add(new Empresa(id,nombre,quienesS,emailC,direccion,telefonoC,face,twitt,insta));
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return empresas;
		
	}

	public Empresa select(int id){
		Empresa empresa=null;
		
		try {
			PreparedStatement preparedStatement= conexion.setPreaparedStatement(SELECT_EMPRESA_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs= conexion.query();
			
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				String quienesS = rs.getString("quienessomos");
				String emailC = rs.getString("emailcontacto");
				String direccion = rs.getString("direccion");
				String telefonoC = rs.getString("telefonocontacto");
				String face = rs.getString("facebook");
				String twitt =rs.getString ("twitter");
				String insta =rs.getString ("instagram");
				empresa = new Empresa(nombre,quienesS,emailC,direccion,telefonoC,face,twitt,insta);
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return empresa;
		
	}

	
	

	
	
	
	
	
}
