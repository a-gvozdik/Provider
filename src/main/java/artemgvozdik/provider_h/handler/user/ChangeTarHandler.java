package artemgvozdik.provider_h.handler.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import artemgvozdik.provider_h.bean.User;
import artemgvozdik.provider_h.dao.UserDAO;
import artemgvozdik.provider_h.handler.Handler;

public class ChangeTarHandler extends Handler {
	static Logger logger = Logger.getLogger(ChangeTarHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		User olduser = (User)session.getAttribute("user");
		int id_tariff = Integer.parseInt(req.getParameter("tarchange"));
		UserDAO udao = new UserDAO();
		User user = udao.changeTar(olduser, id_tariff);
		session.setAttribute("user", user);
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
