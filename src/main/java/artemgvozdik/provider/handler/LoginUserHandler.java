package artemgvozdik.provider.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import artemgvozdik.provider.bean.Admin;
import artemgvozdik.provider.bean.Tariff;
import artemgvozdik.provider.bean.User;
import artemgvozdik.provider.dao.AdminDAO;
import artemgvozdik.provider.dao.TariffDAO;
import artemgvozdik.provider.dao.UserDAO;

public class LoginUserHandler extends Handler {

	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		User user = null;
		UserDAO udao = new UserDAO();
		Admin admin = null;
		AdminDAO adao = new AdminDAO();
		String pass = req.getParameter("password");
		String passmd5 = DigestUtils.md5Hex(pass);
		user = udao.login(req.getParameter("login"), passmd5);
		admin = adao.login(req.getParameter("login"), passmd5);
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		if (user != null) {
			Tariff tariff = new Tariff();
			TariffDAO tdao = new TariffDAO();
			tariff = tdao.getTariff(user.getId_tariff());
			session.setMaxInactiveInterval(1800);
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
		if (admin != null) {
			session.setMaxInactiveInterval(1800);
			session.setAttribute("admin", admin);
			RequestDispatcher rd = req
					.getRequestDispatcher("/jsp/admin/mainadmin.jsp");
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
		if (admin == null && user == null) {
			String auth = "Wrong login or password";
			req.setAttribute("auth", auth);
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
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
}
