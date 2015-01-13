package artemgvozdik.provider.handler.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artemgvozdik.provider.dao.ActiveServiceDAO;
import artemgvozdik.provider.handler.Handler;

public class DeleteActiveServiceHandler extends Handler {

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		ActiveServiceDAO asdao = new ActiveServiceDAO();
		int ID_order = Integer.parseInt(req.getParameter("ID_order"));
		asdao.deleteOrder(ID_order);
		RequestDispatcher rd = req.getRequestDispatcher("/activeservice");
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
