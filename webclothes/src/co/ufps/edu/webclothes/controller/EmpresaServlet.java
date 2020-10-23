package co.ufps.edu.webclothes.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import co.ufps.edu.webclothes.dao.EmpresaDAO;
import co.ufps.edu.webclothes.model.Empresa;

/**
 * Servlet implementation class EmpresaServlet
 */
@WebServlet("/")
public class EmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpresaDAO empresaD;
	
  
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.empresaD=new EmpresaDAO();
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
				insertarEmpresa(request,response);
				break;
			case "/delete":
				eliminarEmpresa(request,response);
				break;
			case "/edit":
				showEditForm(request,response);
				break;
			case "/update":
				actualizarEmpresa(request,response);
				break;
			default:
				listEmpresa(request,response);
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
		RequestDispatcher dispatcher= request.getRequestDispatcher("vistaEmpresa/registroEmpresa.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertarEmpresa(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		String nombre = request.getParameter("nombre");
		String quienesS = request.getParameter("quienes");
		String emailC = request.getParameter("email");
		String direccion = request.getParameter("direccion");
		String telefonoC = request.getParameter("telefono");
		String face = request.getParameter("face");
		String twitt = request.getParameter("twitt");
		String insta = request.getParameter("insta");
	
		
		Empresa empresa= new Empresa(nombre,quienesS,emailC,direccion,telefonoC,face,twitt,insta);
		
		empresaD.insert(empresa);
		response.sendRedirect("vistaEmpresa/ListaEmpresa.jsp"); 
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id =Integer.parseInt(request.getParameter("id"));
		
		Empresa empresa=empresaD.select(id);
		
		request.setAttribute("empresa", empresa);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("vistaEmpresa/registroEmpresa.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void actualizarEmpresa(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		
		int id =Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String quienesS = request.getParameter("quienes");
		String emailC = request.getParameter("email");
		String direccion = request.getParameter("direccion");
		String telefonoC = request.getParameter("telefono");
		String face = request.getParameter("face");
		String twitt = request.getParameter("twitt");
		String insta = request.getParameter("insta");
		
		Empresa empresa= new Empresa(id,nombre,quienesS,emailC,direccion,telefonoC,face,twitt,insta);
		
		empresaD.update(empresa);
		response.sendRedirect("listar"); 
	}

	private void eliminarEmpresa(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		
		empresaD.delete(id);
		
		response.sendRedirect("listar");
		
	}
	
	private void listEmpresa(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		
		List <Empresa> listEmpresa = empresaD.selectAll();
		request.setAttribute("listEmpresa", listEmpresa);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("vistaEmpresa/ListaEmpresa.jsp");
		dispatcher.forward(request, response);
		
		
	}

	
	




}
