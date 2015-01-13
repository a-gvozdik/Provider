package artemgvozdik.provider.handler.tariff;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import artemgvozdik.provider.bean.Tariff;
import artemgvozdik.provider.bean.User;
import artemgvozdik.provider.dao.TariffDAO;
import artemgvozdik.provider.dao.UserDAO;
import artemgvozdik.provider.handler.Handler;

public class ChangeTarHandler extends Handler {

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("userid"));
		int id_tariff = Integer.parseInt(req.getParameter("tarchange"));
		UserDAO udao = new UserDAO();
		udao.changeTar(id, id_tariff);
		HttpSession session = req.getSession();
		User olduser = (User)session.getAttribute("user");
		User user = udao.get(olduser.getId());
		Tariff tariff = new Tariff();
		TariffDAO tdao = new TariffDAO();
		tariff = tdao.getTariff(user.getId_tariff());
		session.setAttribute("user", user);
		session.setAttribute("tariff", tariff);
		RequestDispatcher rd = req
				.getRequestDispatcher("/jsp/user/mainuser.jsp");
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
