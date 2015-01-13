package artemgvozdik.provider.handler.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artemgvozdik.provider.bean.Admin;
import artemgvozdik.provider.dao.AdminDAO;
import artemgvozdik.provider.handler.Handler;

public class AllAdminsHandler extends Handler {

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		List <Admin> alist = new ArrayList<Admin>();
		AdminDAO adao = new AdminDAO();
		alist = adao.getAll();
		req.setAttribute("alist", alist);
	    RequestDispatcher rd = req.getRequestDispatcher("/jsp/admin/alladmins.jsp");
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
