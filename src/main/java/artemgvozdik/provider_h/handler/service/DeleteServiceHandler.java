package artemgvozdik.provider_h.handler.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider_h.dao.ServiceDAO;
import artemgvozdik.provider_h.handler.Handler;

public class DeleteServiceHandler implements Handler {
	static Logger logger = Logger.getLogger(DeleteServiceHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		Integer id = Integer.valueOf(req.getParameter("id"));
		ServiceDAO sdao = new ServiceDAO();
		sdao.deleteService(id);
		RequestDispatcher rd = req.getRequestDispatcher("allservice");
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
