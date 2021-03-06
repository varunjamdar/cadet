package org.cadet.client.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cadet.client.model.CandidateProfileModel;
import org.cadet.util.model.DatabaseConnection;

/**
 * Servlet implementation class UpdateCandidateProfileServlet
 */
@WebServlet("/client/profile/UpdateCandidateProfileServlet")
public class UpdateCandidateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCandidateProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DatabaseConnection dbConn = DatabaseConnection.getInstance();
		Connection dbConnection = dbConn.getDbConnection();
		response.setContentType("text/html;charset=UTF-8");
		
		int success=0;
		HttpSession cadetsession = request.getSession();
		String CUserName = (String) cadetsession.getAttribute("user");
//		System.out.println("UpdateCandidateProfileServlet : " + CUserName);
		CandidateProfileModel cpm = new CandidateProfileModel(dbConnection);
		try {
			String candidatename = request.getParameter("name");
			String candidatecontact = request.getParameter("contact");
			String ccandidatecategoryname = request
					.getParameter("usercategory");

			success = cpm.updateCandidateProfileData(CUserName,
					candidatename, candidatecontact, ccandidatecategoryname);

			if (success != 0) {
				request.setAttribute("result", true);
			} else {
				request.setAttribute("result", false);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("GetCandidateProfileServlet");
		    rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.getRequestDispatcher("/client/DatabaseError.html").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/client/ServerException.html").forward(request, response);
		}

	}

}
