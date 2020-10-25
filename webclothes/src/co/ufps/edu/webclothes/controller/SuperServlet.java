package co.ufps.edu.webclothes.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ufps.edu.webclothes.dao.CategoriaDAO;
import co.ufps.edu.webclothes.dao.MarcaDAO;
import co.ufps.edu.webclothes.dao.ProductoDAO;
import co.ufps.edu.webclothes.model.Categoria;
import co.ufps.edu.webclothes.model.Producto;

/**
 * Servlet implementation class SuperServlet
 */
@WebServlet(name="SuperServlet", urlPatterns= {"/Super.do"})
public class SuperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductoDAO productoD;
	private CategoriaDAO categoriaD;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		this.categoriaD=new CategoriaDAO();
		this.productoD=new ProductoDAO();
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
			case "info":
				listCategoriaXProducto(request,response);
				break;
			default:
				volver(request,response);
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
	
	private void listCategoriaXProducto(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		int id =Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Categoria categoria = categoriaD.select(id);
		Producto producto = productoD.select(id);
		request.setAttribute("categoria", categoria);
		request.setAttribute("producto", producto);
		
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	public void volver(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException{
		response.sendRedirect(request.getContextPath()); 
		
	}
	
	


}
