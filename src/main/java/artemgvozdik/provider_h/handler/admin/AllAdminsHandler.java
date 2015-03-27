package artemgvozdik.provider_h.handler.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider_h.bean.Admin;
import artemgvozdik.provider_h.dao.AdminDAO;
import artemgvozdik.provider_h.handler.Handler;

public class AllAdminsHandler extends Handler {
	static Logger logger = Logger.getLogger(AllAdminsHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		List<Admin> alist = new ArrayList<Admin>();
		AdminDAO adao = new AdminDAO();
		alist = adao.getAll();
		req.setAttribute("alist", alist);
		RequestDispatcher rd = req
				.getRequestDispatcher("/jsp/admin/alladmins.jsp");
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
