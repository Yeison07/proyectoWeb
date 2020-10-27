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

import co.ufps.edu.webclothes.dao.AdminDAO;
import co.ufps.edu.webclothes.model.Admin;


/**
 * Servlet implementation class Admin
 */
@WebServlet(name="AdminServlet", urlPatterns= {"/Admin.do"})
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminDAO adminD;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        this.adminD=new AdminDAO();
        // TODO Auto-generated constructor stub
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
			case "login":
				verificar(request,response);
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

	private void volver(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getContextPath()+"/Admin.do"); 
	}
	
	

	private void verificar(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher= request.getRequestDispatcher("vistaCuerpo/AdminPanel.jsp");
		dispatcher.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
