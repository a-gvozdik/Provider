package artemgvozdik.provider_h.handler.user;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider_h.bean.User;
import artemgvozdik.provider_h.dao.UserDAO;
import artemgvozdik.provider_h.handler.Handler;

public class UpdateUserHandler extends Handler {
	static Logger logger = Logger.getLogger(UpdateUserHandler.class);

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		UserDAO udao = new UserDAO();
		User user = udao.get(Integer.parseInt(req.getParameter("id")));
		user.setFirst_name(req.getParameter("firstname"));
		user.setLast_name(req.getParameter("lastname"));
		user.setAddress(req.getParameter("address"));
		user.setEmail(req.getParameter("email"));
		user.setLogin(req.getParameter("login"));
		user.setMac(req.getParameter("MAC"));
		String status = req.getParameter("status");
		if ("enabled".equals(status)) {
			user.setStatus("enabled");
		}
		if ("disabled".equals(status)) {
			user.setStatus("disabled");
		}
		user.setPhone(req.getParameter("phone"));
		user.setBalans(Double.valueOf(req.getParameter("balans")));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = req.getParameter("birthday");
		Date birthday = null;
		try {
			birthday = sdf.parse(dateInString);
		} catch (ParseException e) {
			logger.error("Exception ", e);
		}
		user.setBirthday(birthday);
		udao.update(user);
		RequestDispatcher rd = req.getRequestDispatcher("alluserlist");
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
