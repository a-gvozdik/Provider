package artemgvozdik.provider_h.handler.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import artemgvozdik.provider_h.bean.Admin;
import artemgvozdik.provider_h.dao.AdminDAO;
import artemgvozdik.provider_h.handler.Handler;

public class AddAdminHandler extends Handler {
	static Logger logger = Logger.getLogger(AddAdminHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		Admin admin = new Admin();
		AdminDAO adao = new AdminDAO();
		admin.setFirst_name(req.getParameter("firstname"));
		admin.setLast_name(req.getParameter("lastname"));
		admin.setEmail(req.getParameter("email"));
		admin.setLogin(req.getParameter("login"));
		String pass = req.getParameter("password");
		String passmd5 = DigestUtils.md5Hex(pass);
		admin.setPassword(passmd5);
		admin.setPhone(req.getParameter("phone"));
		adao.createAdmin(admin);
		RequestDispatcher rd = req
				.getRequestDispatcher("/jsp/admin/mainadmin.jsp");
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
