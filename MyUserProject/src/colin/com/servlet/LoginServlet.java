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
			//���ж�cookie���Ƿ����ʺ�����
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
				//cookie���и��ʺ����룬����ֱ�ӽ��е�¼��
				UserService us = new UserServiceImpl();
				User user = us.nameAndPwd(username, password);
				//���û���Ϣ����session������
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				//�ж��ǲ��ǹ���Ա�����û���
				List<User> list = new ArrayList<User>();
				if(user.getPower() == 1){//�ǹ���Ա
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
				//�ж��ǲ��ǹ���Ա�����û���
				List<User> list = new ArrayList<User>();
				if(user.getPower() == 1){//�ǹ���Ա
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

		}else{//�����¼�������
			//������������
			//�ʺ�����
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//��ȡ�Ƿ��ס����
			boolean flag = false;
			String[] parameterValues = request.getParameterValues("remb");
			if(parameterValues != null){	
					flag = true;			
			}
			//�Ƿ��ǹ���Ա
			int power = 0;	//Ĭ������ͨ�û�
			String p = request.getParameter("power");
			if("1".equals(p)){
				power = 1;
			}
			
			//��ȡ��������������ݴ���
			UserService us = new UserServiceImpl();		
			User user = us.nameAndPwd(username, password);
			if(user!=null){	//�ʺ������Ƿ���ȷ		
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				//��ס����
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
				//�û�����				
				if(power==user.getPower() && user.getPower()==1){
					UserService us1 = new UserServiceImpl();
					List<User> list = us1.findAllUser();
					request.setAttribute("userList", list);
					request.getRequestDispatcher("/page/main.jsp").forward(request, response);			
				}else if(power==0 && user.getPower() == power){
					//��Ϊ����ͨ�û�������ֱ����ת����ʾ�Լ�ȫ����Ϣ��ҳ�档
					List<User> list = new ArrayList<User>();
					list.add(user);
					request.setAttribute("userList", list);
					request.getRequestDispatcher("/page/main.jsp").forward(request, response);
					
				}else if(power == 1 && user.getPower() == 0 ){//����ļ����ʵ�ʼ��𲻷���
					String msg = "�㲻�ǹ���Ա��������ѡ����ȷ�ļ���";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("/page/login.jsp").forward(request, response);
				}else if(power == 0 && user.getPower() ==1){
					String msg = "�㲻����ְͨԱ��������ѡ����ȷ�ļ���";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("/page/login.jsp").forward(request, response);
				}

			}else{//�ʺ����벻��ȷ
				String msg = "�ʺ����벻ƥ��";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/page/login.jsp").forward(request, response);
			}
		}
		


	}

	

	

}
