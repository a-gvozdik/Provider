package artemgvozdik.provider_h.handler.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider_h.bean.ActiveService;
import artemgvozdik.provider_h.dao.UserServiceDAO;
import artemgvozdik.provider_h.handler.Handler;

public class GetUserOrdersHandler implements Handler {
	static Logger logger = Logger.getLogger(GetUserOrdersHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		List<ActiveService> uslist = new ArrayList<ActiveService>();
		int userid = Integer.parseInt(req.getParameter("userid"));
		UserServiceDAO usdao = new UserServiceDAO();
		uslist = usdao.selectByUser(userid);
		req.setAttribute("uslist", uslist);
		RequestDispatcher rd = req
				.getRequestDispatcher("/jsp/user/userorders.jsp");
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
