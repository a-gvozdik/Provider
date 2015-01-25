package artemgvozdik.provider.handler.tariff;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider.bean.Tariff;
import artemgvozdik.provider.dao.TariffDAO;
import artemgvozdik.provider.handler.Handler;

public class UpdateTariffHandler extends Handler {
	static Logger logger = Logger.getLogger(UpdateTariffHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		Tariff tar = new Tariff();
		TariffDAO tdao = new TariffDAO();
		tar.setID(Integer.parseInt(req.getParameter("id")));
		tar.setName(req.getParameter("name"));
		tar.setDescription(req.getParameter("description"));
		tar.setPrice(Double.parseDouble(req.getParameter("price")));
		tdao.update(tar);
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
