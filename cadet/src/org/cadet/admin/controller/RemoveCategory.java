package org.cadet.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cadet.admin.model.CategoryManagement;

/**
 * @author KIRAN
 * 
 * Servlet implementation class RemoveCategory
 *
 *@WebServlet("/RemoveCategory")
 *
 */
public class RemoveCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean status=false;
		PrintWriter out = response.getWriter();
        CategoryManagement objCategoryManagement = new CategoryManagement();
        String categoryId = request.getParameter("categoryId").toString();

        try{
            objCategoryManagement.removeCategory(categoryId);
            status = true;
        }
        catch(Exception e){
            status = false;
        }
        if(status){
        	out.print("Category Removed");
            request.setAttribute("status", "Done");
        }
        else{
        	out.print("Category Not Removed");
        	request.setAttribute("status", "Fail");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
