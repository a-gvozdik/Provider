package artemgvozdik.provider.handler.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artemgvozdik.provider.bean.Service;
import artemgvozdik.provider.dao.UserServiceDAO;
import artemgvozdik.provider.handler.Handler;

public class GetUserOrdersHandler extends Handler {

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		List <Service> uslist = new ArrayList<Service>();
		int userid = Integer.parseInt(req.getParameter("userid"));
		UserServiceDAO usdao = new UserServiceDAO();
		uslist = usdao.selectByUser(userid);
		req.setAttribute("uslist", uslist);
	    RequestDispatcher rd = req.getRequestDispatcher("/jsp/user/userorders.jsp");
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
