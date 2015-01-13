package artemgvozdik.provider.handler.tariff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artemgvozdik.provider.bean.Tariff;
import artemgvozdik.provider.dao.TariffDAO;
import artemgvozdik.provider.handler.Handler;

public class AllTarHandler extends Handler {

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		List <Tariff> tlist = new ArrayList<Tariff>();
		TariffDAO tdao = new TariffDAO();
		tlist = tdao.getAll();
		req.setAttribute("tlist", tlist);
	    RequestDispatcher rd = req.getRequestDispatcher("/jsp/user/alltariffs.jsp");
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
