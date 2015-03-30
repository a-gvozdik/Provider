package artemgvozdik.provider_h.handler.tariff;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider_h.dao.TariffDAO;
import artemgvozdik.provider_h.handler.Handler;

public class DeleteTariffHandler implements Handler {
	static Logger logger = Logger.getLogger(DeleteTariffHandler.class);
	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		Integer id = Integer.valueOf(req.getParameter("id"));
		TariffDAO tdao = new TariffDAO();
		tdao.deleteTariff(id);
		RequestDispatcher rd = req.getRequestDispatcher("alltariffs");
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
