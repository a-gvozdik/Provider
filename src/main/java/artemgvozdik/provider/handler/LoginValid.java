package artemgvozdik.provider.handler;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import artemgvozdik.provider.ConnectionFactory;

public class LoginValid extends Handler {
	static Logger logger = Logger.getLogger(LoginValid.class);

	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html;charset=UTF-8");
		try (Connection con = ConnectionFactory.getConnection();
				PrintWriter out = resp.getWriter()) {

			String login = req.getParameter("uname");
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM users WHERE login = ?");
			st.setString(1, login);
			ResultSet rs = st.executeQuery();

			if (!rs.next()) {
				out.println("<font color=\"green\"><b>" + login
						+ "</b> is avaliable</font>");
			} else {
				out.println("<font color=\"red\"><b>" + login
						+ "</b> is already in use</font>");
			}
			out.println();

		} catch (Exception e) {
			logger.error("Exception ", e);
		}
	}

}
