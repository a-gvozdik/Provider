package artemgvozdik.provider.handler.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider.dao.ActiveServiceDAO;
import artemgvozdik.provider.handler.Handler;

public class ActiveServiceChangeStatusHandler extends Handler {
	static Logger logger = Logger
			.getLogger(ActiveServiceChangeStatusHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		ActiveServiceDAO asdao = new ActiveServiceDAO();
		int ID_order = Integer.parseInt(req.getParameter("ID_order"));
		String status = req.getParameter("status");
		asdao.changeStatus(ID_order, status);
		RequestDispatcher rd = req.getRequestDispatcher("/activeservice");
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
