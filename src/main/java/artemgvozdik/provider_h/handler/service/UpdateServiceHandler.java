package artemgvozdik.provider_h.handler.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider_h.bean.Service;
import artemgvozdik.provider_h.dao.ServiceDAO;
import artemgvozdik.provider_h.handler.Handler;

public class UpdateServiceHandler implements Handler {
	static Logger logger = Logger.getLogger(UpdateServiceHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		Service service = new Service();
		ServiceDAO sdao = new ServiceDAO();
		service.setID(Integer.parseInt(req.getParameter("id")));
		service.setName(req.getParameter("name"));
		service.setDescription(req.getParameter("description"));
		service.setPrice(Double.parseDouble(req.getParameter("price")));
		sdao.updateService(service);
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
