package artemgvozdik.provider_h.handler.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider_h.bean.Service;
import artemgvozdik.provider_h.dao.ServiceDAO;
import artemgvozdik.provider_h.handler.Handler;

public class AllServiceHandler extends Handler {
	static Logger logger = Logger.getLogger(AllServiceHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		List<Service> slist = new ArrayList<Service>();
		ServiceDAO sdao = new ServiceDAO();
		slist = sdao.getAll();
		req.setAttribute("slist", slist);
		RequestDispatcher rd = req
				.getRequestDispatcher("/jsp/admin/allservice.jsp");
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
