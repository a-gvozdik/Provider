package artemgvozdik.provider.handler.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artemgvozdik.provider.bean.User;
import artemgvozdik.provider.dao.UserDAO;
import artemgvozdik.provider.handler.Handler;

public class AllUsersHandler extends Handler {

	
	public void doAction (HttpServletRequest req, HttpServletResponse resp) {
		List <User> ulist = new ArrayList <User> ();
		UserDAO udao = new UserDAO ();
		ulist = udao.getAll();
		req.setAttribute("ulist", ulist);
	    RequestDispatcher rd = req.getRequestDispatcher("/jsp/admin/alluserslist.jsp");
	    try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
