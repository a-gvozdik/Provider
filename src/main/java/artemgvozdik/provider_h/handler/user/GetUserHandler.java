package artemgvozdik.provider_h.handler.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider_h.bean.User;
import artemgvozdik.provider_h.dao.UserDAO;
import artemgvozdik.provider_h.handler.Handler;

public class GetUserHandler implements Handler {
	static Logger logger = Logger.getLogger(GetUserHandler.class);
	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		User user = new User();
		UserDAO udao = new UserDAO ();
		int id = Integer.parseInt(req.getParameter("id"));
		user = udao.get(id);
		req.setAttribute("user", user);
	    RequestDispatcher rd = req.getRequestDispatcher("/jsp/admin/updateuser.jsp");
	    try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			logger.error("Exception ", e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Exception ", e);
		}
		
	}

}
