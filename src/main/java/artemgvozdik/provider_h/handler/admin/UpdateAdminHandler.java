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

public class UpdateAdminHandler extends Handler {
	static Logger logger = Logger.getLogger(UpdateAdminHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		AdminDAO adao = new AdminDAO();
		Admin admin = adao.getAdmin(Integer.parseInt(req.getParameter("id")));
		admin.setFirst_name(req.getParameter("firstname"));
		admin.setLast_name(req.getParameter("lastname"));
		admin.setEmail(req.getParameter("email"));
		admin.setLogin(req.getParameter("login"));
		admin.setPhone(req.getParameter("phone"));
		adao.update(admin);
		RequestDispatcher rd = req.getRequestDispatcher("alladmins");
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
