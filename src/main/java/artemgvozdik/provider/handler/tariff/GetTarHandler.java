package artemgvozdik.provider.handler.tariff;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artemgvozdik.provider.bean.Tariff;
import artemgvozdik.provider.dao.TariffDAO;
import artemgvozdik.provider.handler.Handler;

public class GetTarHandler extends Handler {

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		Tariff tar = new Tariff();
		TariffDAO tdao = new TariffDAO();
		int id = Integer.parseInt(req.getParameter("id"));
		tar = tdao.getTariff(id);
		req.setAttribute("tariff", tar);
	    RequestDispatcher rd = req.getRequestDispatcher("/jsp/admin/updatetariff.jsp");
	    try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
