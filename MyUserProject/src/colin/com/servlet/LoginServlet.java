package colin.com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import colin.com.bean.User;
import colin.com.util.UserService;
import colin.com.util.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns={"/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if("0".equals(request.getParameter("login"))){
			String username = null;
			String password = null;
			//先判断cookie中是否有帐号密码
			Cookie[] cookie = request.getCookies();
			if(cookie != null){
				for (Cookie c : cookie) {
					if("username".equals(c.getName())){
						username = c.getValue();
					}else if("password".equals(c.getName())){
						password = c.getValue();										
					}
				}
			}
			if(username!=null && password != null){
				//cookie中有该帐号密码，所以直接进行登录，
				UserService us = new UserServiceImpl();
				User user = us.nameAndPwd(username, password);
				//将用户信息存入session作用域
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				//判断是不是管理员还是用户。
				List<User> list = new ArrayList<User>();
				if(user.getPower() == 1){//是管理员
					UserService us1 = new UserServiceImpl();
					list = us1.findAllUser();
					
				}else{
					list.add(user);
				}
				request.setAttribute("userList", list);
				request.getRequestDispatcher("/page/main.jsp").forward(request, response);
				return;
			}	
			if(request.getSession().getAttribute("user") != null){
				User user = (User) request.getSession().getAttribute("user");
				//判断是不是管理员还是用户。
				List<User> list = new ArrayList<User>();
				if(user.getPower() == 1){//是管理员
					UserService us1 = new UserServiceImpl();
					list = us1.findAllUser();
					
				}else{
					list.add(user);
				}
				request.setAttribute("userList", list);
				request.getRequestDispatcher("/page/main.jsp").forward(request, response);
				
			}else{
				response.sendRedirect(request.getContextPath()+"/page/main.jsp");
			}

		}else{//点击登录后过来的
			//获得请求参数，
			//帐号密码
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//获取是否记住密码
			boolean flag = false;
			String[] parameterValues = request.getParameterValues("remb");
			if(parameterValues != null){	
					flag = true;			
			}
			//是否是管理员
			int power = 0;	//默认是普通用户
			String p = request.getParameter("power");
			if("1".equals(p)){
				power = 1;
			}
			
			//获取请求参数后，做数据处理
			UserService us = new UserServiceImpl();		
			User user = us.nameAndPwd(username, password);
			if(user!=null){	//帐号密码是否正确		
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				//记住密码
				if(flag){
					Cookie cookie = new Cookie("username",user.getUsername());
					Cookie cookie1 = new Cookie("password",user.getPassword());
					cookie.setPath("/");
					cookie.setMaxAge(5000000);
					cookie1.setPath("/");
					cookie1.setMaxAge(5000000);
					response.addCookie(cookie);
					response.addCookie(cookie1);					
				}else{
					Cookie[] cookie = request.getCookies();
					if(cookie != null){
						for (Cookie c : cookie) {
							if("username".equals(c.getName())){
								c.setMaxAge(0);
								c.setPath("/");
								response.addCookie(c);
							}else if("password".equals(c.getName())){
								c.setMaxAge(0);		
								c.setPath("/");
								response.addCookie(c);
							}
						}
					}
				}
				//用户级别				
				if(power==user.getPower() && user.getPower()==1){
					UserService us1 = new UserServiceImpl();
					List<User> list = us1.findAllUser();
					request.setAttribute("userList", list);
					request.getRequestDispatcher("/page/main.jsp").forward(request, response);			
				}else if(power==0 && user.getPower() == power){
					//因为是普通用户，所以直接跳转到显示自己全部信息的页面。
					List<User> list = new ArrayList<User>();
					list.add(user);
					request.setAttribute("userList", list);
					request.getRequestDispatcher("/page/main.jsp").forward(request, response);
					
				}else if(power == 1 && user.getPower() == 0 ){//点击的级别跟实际级别不符合
					String msg = "你不是管理员，请重新选择正确的级别";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("/page/login.jsp").forward(request, response);
				}else if(power == 0 && user.getPower() ==1){
					String msg = "你不是普通职员，请重新选择正确的级别";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("/page/login.jsp").forward(request, response);
				}

			}else{//帐号密码不正确
				String msg = "帐号密码不匹配";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/page/login.jsp").forward(request, response);
			}
		}
		


	}

	

	

}
