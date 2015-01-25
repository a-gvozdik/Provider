package artemgvozdik.provider.handler.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider.handler.Handler;

public class GetAdminPassHandler extends Handler {
	static Logger logger = Logger.getLogger(GetAdminPassHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		req.setAttribute("id", id);
		RequestDispatcher rd = req
				.getRequestDispatcher("/jsp/admin/adminpassrenew.jsp");
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
