package artemgvozdik.provider_h.handler.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider_h.dao.ActiveServiceDAO;
import artemgvozdik.provider_h.handler.Handler;

public class DeleteActiveServiceHandler implements Handler {
	static Logger logger = Logger.getLogger(DeleteActiveServiceHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		ActiveServiceDAO asdao = new ActiveServiceDAO();
		int ID_order = Integer.parseInt(req.getParameter("ID_order"));
		asdao.deleteOrder(ID_order);
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
