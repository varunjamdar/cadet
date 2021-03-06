package org.cadet.client.controller.adaptive;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cadet.client.bean.CategoryAdaptiveTest;
import org.cadet.client.model.adaptive.AdaptiveTest;
import org.cadet.util.Exceptions.TestFinishException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class GetCategories
 */
@WebServlet("/client/Test/Adaptive/GetCategories")
public class GetCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCategories() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JSONObject data = null;
		JSONArray array = null;
		JSONArray element;		
		PrintWriter out;
		
			data = new JSONObject();
			array = new JSONArray();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			out = response.getWriter();
		
		
			HttpSession session = request.getSession(false);
			

			if (session == null) {
				// response.sendRedirect("");// send to dashboard
				try {
					data.put("result", "invalidSession");
					out.println(data);
					return;
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
			}
			AdaptiveTest test = (AdaptiveTest) session.getAttribute("test");

				Collection<CategoryAdaptiveTest> categories;
				try {
					categories = test.getUnattemptedCategories().values();
					try {
						for (CategoryAdaptiveTest cat : categories) {
							element = new JSONArray();
							element.put(0, cat.getCategoryId());
							element.put(1, cat.getCategoryName());
							element.put(2, new Long(cat.getTimePerCategory()*60*1000));
							array.put(element);
						}
					
						data.put("result", true);
						data.put("categoryList", array);
						out.println(data);
						return;
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					try {
						data.put("result", "databaseError");
						out.println(data);
						return;
					} catch (JSONException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
						return;
					}
					
				} catch (TestFinishException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					try {
						data.put("result", "testFinished");
						out.println(data);
						return;
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return;
					}
				}

				
	}

}
