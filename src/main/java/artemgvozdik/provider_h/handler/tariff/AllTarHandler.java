package artemgvozdik.provider_h.handler.tariff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider_h.bean.Tariff;
import artemgvozdik.provider_h.dao.TariffDAO;
import artemgvozdik.provider_h.handler.Handler;

public class AllTarHandler implements Handler {
	static Logger logger = Logger.getLogger(AllTarHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		List<Tariff> tlist = new ArrayList<Tariff>();
		TariffDAO tdao = new TariffDAO();
		tlist = tdao.getAll();
		req.setAttribute("tlist", tlist);
		RequestDispatcher rd = req
				.getRequestDispatcher("/jsp/user/alltariffs.jsp");
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
