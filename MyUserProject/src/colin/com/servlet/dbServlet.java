package colin.com.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;





/**
 * Servlet implementation class dbServlet
 */
@WebServlet("/dbServlet")
public class dbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO �Զ����ɵķ������
    	super.init();
    	
    }

	
}
