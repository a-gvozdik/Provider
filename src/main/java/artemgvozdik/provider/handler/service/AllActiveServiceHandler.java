package artemgvozdik.provider.handler.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artemgvozdik.provider.bean.ActiveService;
import artemgvozdik.provider.dao.ActiveServiceDAO;
import artemgvozdik.provider.handler.Handler;

public class AllActiveServiceHandler extends Handler {

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		List<ActiveService> laservice = new ArrayList<ActiveService>();
		ActiveServiceDAO asdao = new ActiveServiceDAO();
		laservice = asdao.getAllActive();
		req.setAttribute("laservice", laservice);
	    RequestDispatcher rd = req.getRequestDispatcher("/jsp/admin/activeservice.jsp");
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
