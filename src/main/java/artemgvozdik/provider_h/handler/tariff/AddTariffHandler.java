package artemgvozdik.provider_h.handler.tariff;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider_h.bean.Tariff;
import artemgvozdik.provider_h.dao.TariffDAO;
import artemgvozdik.provider_h.handler.Handler;

public class AddTariffHandler extends Handler {
	static Logger logger = Logger.getLogger(AddTariffHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		Tariff newtariff = new Tariff();
		TariffDAO tdao = new TariffDAO();
		newtariff.setName(req.getParameter("name"));
		newtariff.setDescription(req.getParameter("description"));
		newtariff.setPrice(Double.parseDouble(req.getParameter("price")));
		tdao.createTariff(newtariff);
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
