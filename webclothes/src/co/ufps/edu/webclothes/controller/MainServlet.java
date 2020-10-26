package co.ufps.edu.webclothes.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.ufps.edu.webclothes.dao.CategoriaDAO;
import co.ufps.edu.webclothes.dao.EmpresaDAO;
import co.ufps.edu.webclothes.model.Categoria;
import co.ufps.edu.webclothes.model.Empresa;



/**
 * Servlet implementation class CategoriaServlet
 */
@WebServlet(name="MainServlet", urlPatterns= {"/Home"})

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EmpresaDAO empresaD;
	
	public MainServlet() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		this.empresaD=new EmpresaDAO();
	}
	
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			try {
				listCategoriaID(request,response);
			} catch (SQLException | IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	

	private void listCategoriaID(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		
		
		Empresa empresa = empresaD.select(1);
		empresaD.toString();
		request.setAttribute("empresa", empresa);
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
		
	}
	

	
	
	
	
	



	


}
