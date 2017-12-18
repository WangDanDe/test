package colin.com.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import colin.com.util.UserService;
import colin.com.util.UserServiceImpl;
@WebServlet(urlPatterns="/DeleteInfoServlet",loadOnStartup=1)
public class DeleteInfoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String id = request.getParameter("id");
			UserService us = new UserServiceImpl();
			us.deleteUser(Integer.valueOf(id));
			
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}

}
