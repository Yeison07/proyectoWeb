package co.ufps.edu.webclothes.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import co.ufps.edu.webclothes.dao.CategoriaDAO;
import co.ufps.edu.webclothes.model.Categoria;
import co.ufps.edu.webclothes.model.Empresa;


/**
 * Servlet implementation class CategoriaServlet
 */
@WebServlet("/CategoriaServlet")
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CategoriaDAO categoriaD;
	@Resource (name="jdbc/ropas")
	private DataSource pool;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
	}
	
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}



	


}
