package artemgvozdik.provider.handler.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artemgvozdik.provider.bean.Admin;
import artemgvozdik.provider.dao.AdminDAO;
import artemgvozdik.provider.handler.Handler;

public class AddAdminHandler extends Handler {

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		Admin admin = new Admin();
		AdminDAO adao = new AdminDAO();
		admin.setFirst_name(req.getParameter("firstname"));
		admin.setLast_name(req.getParameter("lastname"));
		admin.setEmail(req.getParameter("email"));
		admin.setLogin(req.getParameter("login"));
		admin.setPassword(req.getParameter("password"));
		admin.setPhone(req.getParameter("phone"));
		adao.createAdmin(admin);
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/admin/mainadmin.jsp");
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