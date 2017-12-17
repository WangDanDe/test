package colin.com.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */

@WebServlet(urlPatterns={"/a.do","/b.do"},name="testServlet",asyncSupported=true)
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() 
    {
        System.out.println("============TestServlet()");
    }
    @Override
    public void init() throws ServletException {
    	// TODO �Զ����ɵķ������
    	super.init();
    	System.out.println("============init()");
    }
    @Override
    public void destroy() {
    	// TODO �Զ����ɵķ������
    	super.destroy();
    	System.out.println("============destroy()");
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	// TODO �Զ����ɵķ������
    	
    }
    

	
}
