package artemgvozdik.provider.handler.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider.dao.UserServiceDAO;
import artemgvozdik.provider.handler.Handler;

public class AddUserServiceHandler extends Handler {
	static Logger logger = Logger.getLogger(AddUserServiceHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		UserServiceDAO usdao = new UserServiceDAO();
		int userid = Integer.parseInt(req.getParameter("userid"));
		String select[] = req.getParameterValues("orderservice");
		if (select != null && select.length != 0) {
			for (int i = 0; i < select.length; i++) {
				int serviceid = Integer.parseInt(select[i]);
				usdao.makeUserOrder(userid, serviceid);
			}
		}
		RequestDispatcher rd = req
				.getRequestDispatcher("/jsp/user/mainuser.jsp");
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
