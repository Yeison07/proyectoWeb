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
import co.ufps.edu.webclothes.model.Categoria;



/**
 * Servlet implementation class CategoriaServlet
 */
@WebServlet(name="CategoriaServlet", urlPatterns= {"/Categoria.do"})
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CategoriaDAO categoriaD;
	
	public CategoriaServlet() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		this.categoriaD=new CategoriaDAO();
	}
	
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action= (request.getParameter("action") != null) ? request.getParameter("action"):"list";
		System.out.println(action);
		
		
		
		
		try {
			switch (action) {
			case "new":
				showNewForm(request,response);
				break;
			case "insert":
				insertarCategoria(request,response);
				break;
			case "delete":
				eliminarCategoria(request,response);
				break;
			case "edit":
				showEditForm(request,response);
				break;
			case "update":
				actualizarCategoria(request,response);
				break;
			default:
				listCategoria(request,response);
				break;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ServletException (e);
		}
		
		
			
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("vistaCategoria/registroCategoria.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertarCategoria(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		int id  = Integer.valueOf(request.getParameter("id"));
		String descripcion = request.getParameter("descripcion");
		String estado = request.getParameter("estado"); 
		
		Categoria categoria= new Categoria(id,descripcion,estado);
		categoriaD.insert(categoria);
		response.sendRedirect("listar"); 
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id =Integer.parseInt(request.getParameter("id"));
		
		Categoria categoria=categoriaD.select(id);
		
		request.setAttribute("categoria", categoria);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("vistaCategoria/registroCategoria.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void actualizarCategoria(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		
		int id =Integer.parseInt(request.getParameter("id"));
		String descripcion = request.getParameter("descripcion");
		String estado = request.getParameter("estado");
		
		Categoria categoria= new Categoria(id,descripcion,estado);
		
		categoriaD.update(categoria);
		response.sendRedirect(request.getContextPath()); 
	}

	private void eliminarCategoria(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		
		categoriaD.delete(id);
		
		response.sendRedirect("listar");
		
	}
	
	private void listCategoria(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		
		List <Categoria> listCategoria = categoriaD.selectAll();
		request.setAttribute("listCategoria", listCategoria);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("vistaCategoria/ListaCategoria.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	
	
	



	


}
