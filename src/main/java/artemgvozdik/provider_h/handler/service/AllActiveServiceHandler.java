package artemgvozdik.provider_h.handler.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider_h.bean.ActiveService;
import artemgvozdik.provider_h.dao.ActiveServiceDAO;
import artemgvozdik.provider_h.handler.Handler;

public class AllActiveServiceHandler implements Handler {
	static Logger logger = Logger.getLogger(AllActiveServiceHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		List<ActiveService> laservice = new ArrayList<ActiveService>();
		ActiveServiceDAO asdao = new ActiveServiceDAO();
		laservice = asdao.getAllActive();
		req.setAttribute("laservice", laservice);
		RequestDispatcher rd = req
				.getRequestDispatcher("/jsp/admin/activeservice.jsp");
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
