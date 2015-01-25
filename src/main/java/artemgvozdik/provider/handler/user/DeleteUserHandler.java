package artemgvozdik.provider.handler.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider.dao.UserDAO;
import artemgvozdik.provider.handler.Handler;

public class DeleteUserHandler extends Handler {
	static Logger logger = Logger.getLogger(DeleteUserHandler.class);

	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		Integer id = Integer.valueOf(req.getParameter("id"));
		UserDAO udao = new UserDAO();
		udao.delete(id);
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
