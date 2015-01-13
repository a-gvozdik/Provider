package artemgvozdik.provider.handler.user;

import java.io.IOException;
import java.io.PrintWriter;
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

public class AddUserHandler extends Handler {
	
	PrintWriter pw;
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		User user = new User();
		UserDAO udao = new UserDAO();
		user.setFirst_name(req.getParameter("firstname"));
		user.setLast_name(req.getParameter("lastname"));
		user.setAddress(req.getParameter("address"));
		user.setEmail(req.getParameter("email"));
		user.setLogin(req.getParameter("login"));
		user.setMac(req.getParameter("MAC"));
		user.setPassword(req.getParameter("password"));
		user.setPhone(req.getParameter("phone"));
		user.setBalans(Integer.valueOf(req.getParameter("balans")));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = req.getParameter("birthday");
		Date birthday=null;
		try {
		birthday = sdf.parse(dateInString);
		} catch (ParseException e) {
		e.printStackTrace();
		}
		user.setBirthday(birthday);
		udao.add(user);
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
