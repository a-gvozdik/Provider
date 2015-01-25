package artemgvozdik.provider.handler.tariff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider.bean.Tariff;
import artemgvozdik.provider.dao.TariffDAO;
import artemgvozdik.provider.handler.Handler;

public class AllTariffsHandler extends Handler {
	static Logger logger = Logger.getLogger(AllTariffsHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		List<Tariff> tlist = new ArrayList<Tariff>();
		TariffDAO tdao = new TariffDAO();
		tlist = tdao.getAll();
		req.setAttribute("tlist", tlist);
		RequestDispatcher rd = req
				.getRequestDispatcher("/jsp/admin/alltariffs.jsp");
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
