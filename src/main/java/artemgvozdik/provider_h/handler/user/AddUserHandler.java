package artemgvozdik.provider_h.handler.user;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import artemgvozdik.provider_h.bean.User;
import artemgvozdik.provider_h.dao.UserDAO;
import artemgvozdik.provider_h.handler.Handler;

public class AddUserHandler implements Handler {
	static Logger logger = Logger.getLogger(AddUserHandler.class);
	

	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		User user = new User();
		UserDAO udao = new UserDAO();
		user.setFirst_name(req.getParameter("firstname"));
		user.setLast_name(req.getParameter("lastname"));
		user.setAddress(req.getParameter("address"));
		user.setEmail(req.getParameter("email"));
		user.setLogin(req.getParameter("login"));
		user.setMac(req.getParameter("MAC"));
		String pass = req.getParameter("password");
		String passmd5 = DigestUtils.md5Hex(pass);
		user.setPassword(passmd5);
		user.setPhone(req.getParameter("phone"));
		double balans = Double.valueOf(req.getParameter("balans"));
		if (balans==0) {
		user.setBalans(0);
		} else {
			user.setBalans(balans);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = req.getParameter("birthday");
		Date birthday = null;
		try {
			birthday = sdf.parse(dateInString);
		} catch (ParseException e) {
			logger.error("Exception ", e);
		}
		user.setBirthday(birthday);
		user.setStatus("disabled");
		udao.add(user);
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
