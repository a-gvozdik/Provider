package artemgvozdik.provider_h.handler.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider_h.dao.UserDAO;
import artemgvozdik.provider_h.handler.Handler;

public class UserPassReHandler implements Handler {
	static Logger logger = Logger.getLogger(UserPassReHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		String newpass = req.getParameter("newpass");
		UserDAO udao = new UserDAO();
		udao.passRenew(id, newpass);
		RequestDispatcher rd = req.getRequestDispatcher("alluserlist");
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
