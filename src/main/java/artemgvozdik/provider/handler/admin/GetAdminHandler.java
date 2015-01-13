package artemgvozdik.provider.handler.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artemgvozdik.provider.bean.Admin;
import artemgvozdik.provider.dao.AdminDAO;
import artemgvozdik.provider.handler.Handler;

public class GetAdminHandler extends Handler {

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		Admin uadmin = new Admin ();
		AdminDAO adao = new AdminDAO();
		int id = Integer.parseInt(req.getParameter("id"));
		uadmin = adao.getAdmin(id);
		req.setAttribute("uadmin", uadmin);
	    RequestDispatcher rd = req.getRequestDispatcher("/jsp/admin/updateadmin.jsp");
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