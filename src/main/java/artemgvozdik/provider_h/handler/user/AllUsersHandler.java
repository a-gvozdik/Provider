package artemgvozdik.provider_h.handler.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider_h.bean.User;
import artemgvozdik.provider_h.dao.UserDAO;
import artemgvozdik.provider_h.handler.Handler;

public class AllUsersHandler implements Handler {
	static Logger logger = Logger.getLogger(AllUsersHandler.class);

	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		List<User> ulist = new ArrayList<User>();
		UserDAO udao = new UserDAO();
		ulist = udao.getAll();
		req.setAttribute("ulist", ulist);
		RequestDispatcher rd = req
				.getRequestDispatcher("/jsp/admin/alluserslist.jsp");
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
