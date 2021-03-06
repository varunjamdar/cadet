package org.cadet.client.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cadet.util.model.DatabaseConnection;
import org.json.JSONException;
import org.json.JSONObject;
import org.cadet.client.model.CandidateCategory;
import org.cadet.client.model.DashboardModel;;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/client/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendError(403, "No Get Request Allowed for this Page");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		JSONObject data = null;
		
		HttpSession cadetsession = request.getSession();
		String username= (String) cadetsession.getAttribute("user"); 
//		System.out.println("DashboardServlet : "  + username);
	    DatabaseConnection dbConn = DatabaseConnection.getInstance();
	    Connection dbConnection = dbConn.getDbConnection();
	    
	    
	    try {
			data = DashboardModel.getTests(dbConnection, username);
			data.put("result", true);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			//System.out.println(data);
			out.println(data);
		} catch (SQLException se) {
			se.printStackTrace();
			
			data = new JSONObject();
			
			try {
			    data.put("result", "DatabaseError");
			} catch (JSONException e1) {
			    e1.printStackTrace();
			}
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.println(data);
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
			data = new JSONObject();
			try {
			    data.put("result", "ServerException");
			} catch (JSONException e1) {
			    e1.printStackTrace();
			}
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.println(data);
		}
		
		
	}

}
