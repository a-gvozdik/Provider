package artemgvozdik.provider.handler.user;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artemgvozdik.provider.bean.User;
import artemgvozdik.provider.dao.UserDAO;
import artemgvozdik.provider.handler.Handler;

public class UpdateUserHandler extends Handler {

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		User user = new User();
		UserDAO udao = new UserDAO();
		String status = req.getParameter("status");
		user.setId(Integer.parseInt(req.getParameter("id")));
		user.setFirst_name(req.getParameter("firstname"));
		user.setLast_name(req.getParameter("lastname"));
		user.setAddress(req.getParameter("address"));
		user.setEmail(req.getParameter("email"));
		user.setLogin(req.getParameter("login"));
		user.setMac(req.getParameter("MAC"));
		if ("enabled".equals(status)) {
			user.setStatus("enabled");
		}
		if ("disabled".equals(status)) {
			user.setStatus("disabled");
		}
		user.setPhone(req.getParameter("phone"));
		user.setBalans(Integer.parseInt(req.getParameter("balans")));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = req.getParameter("birthday");
		Date birthday = null;
		try {
			birthday = sdf.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setBirthday(birthday);
		udao.update(user);
		RequestDispatcher rd = req.getRequestDispatcher("alluserlist");
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
