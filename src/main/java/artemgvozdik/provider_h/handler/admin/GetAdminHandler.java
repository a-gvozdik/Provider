package artemgvozdik.provider_h.handler.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider_h.bean.Admin;
import artemgvozdik.provider_h.dao.AdminDAO;
import artemgvozdik.provider_h.handler.Handler;

public class GetAdminHandler implements Handler {
	static Logger logger = Logger.getLogger(GetAdminHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		Admin uadmin = new Admin();
		AdminDAO adao = new AdminDAO();
		int id = Integer.parseInt(req.getParameter("id"));
		uadmin = adao.getAdmin(id);
		req.setAttribute("uadmin", uadmin);
		RequestDispatcher rd = req
				.getRequestDispatcher("/jsp/admin/updateadmin.jsp");
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
