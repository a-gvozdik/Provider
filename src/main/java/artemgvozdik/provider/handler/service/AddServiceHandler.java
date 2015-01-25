package artemgvozdik.provider.handler.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider.bean.Service;
import artemgvozdik.provider.dao.ServiceDAO;
import artemgvozdik.provider.handler.Handler;

public class AddServiceHandler extends Handler {
	static Logger logger = Logger.getLogger(AddServiceHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		Service service = new Service();
		ServiceDAO sdao = new ServiceDAO();
		service.setName(req.getParameter("name"));
		service.setDescription(req.getParameter("description"));
		service.setPrice(Double.parseDouble(req.getParameter("price")));
		sdao.createService(service);
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
