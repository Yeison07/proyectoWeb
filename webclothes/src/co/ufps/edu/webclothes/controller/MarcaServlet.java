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


import co.ufps.edu.webclothes.dao.MarcaDAO;
import co.ufps.edu.webclothes.model.Marca;

/**
 * Servlet implementation class MarcaServlet
 */
@WebServlet(name="MarcaServlet", urlPatterns= {"/Marca.do"})
public class MarcaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MarcaDAO marcaD;
       
	public MarcaServlet() {
		super();
	}
	
	public void init(ServletConfig config ) throws ServletException {
		// TODO Auto-generated method stub
		
		this.marcaD=new MarcaDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request,response);
				break;
			case "/insert":
				insertarMarca(request,response);
				break;
			case "/delete":
				eliminarMarca(request,response);
				break;
			case "/edit":
				showEditForm(request,response);
				break;
			case "/update":
				actualizarMarca(request,response);
				break;
			default:
				listMarca(request,response);
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
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("vistaMarca/registroMarca.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertarMarca(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		int id  = Integer.valueOf(request.getParameter("id"));
		String nombre = request.getParameter("nombre"); 
		String descripcion = request.getParameter("descripcion");
		
		Marca marca= new Marca(id,nombre,descripcion);
		
		marcaD.insert(marca);
		response.sendRedirect("vistaMarca/ListaMarca.jsp"); 
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id =Integer.parseInt(request.getParameter("id"));
		
		Marca marca=marcaD.select(id);
		
		request.setAttribute("marca", marca);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("vistaMarca/registroMarca.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void actualizarMarca(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		
		int id =Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		
		Marca marca= new Marca(id,nombre,descripcion);
		
		marcaD.update(marca);
		response.sendRedirect("listar"); 
	}

	private void eliminarMarca(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		
		marcaD.delete(id);
		
		response.sendRedirect("listar");
		
	}
	
	private void listMarca(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		
		List <Marca> listMarca = marcaD.selectAll();
		request.setAttribute("listMarca", listMarca);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("vistaMarca/ListaMarca.jsp");
		dispatcher.forward(request, response);
		
		
	}




}
