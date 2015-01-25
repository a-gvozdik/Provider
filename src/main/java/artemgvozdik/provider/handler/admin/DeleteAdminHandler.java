package artemgvozdik.provider.handler.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider.dao.AdminDAO;
import artemgvozdik.provider.handler.Handler;

public class DeleteAdminHandler extends Handler {
	static Logger logger = Logger.getLogger(DeleteAdminHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		Integer id = Integer.valueOf(req.getParameter("id"));
		AdminDAO adao = new AdminDAO();
		adao.deleteAdmin(id);
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
