package artemgvozdik.provider_h.handler;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import artemgvozdik.provider_h.ConnectionFactory;
import artemgvozdik.provider_h.bean.User;

public class LoginValid extends Handler {
	static Logger logger = Logger.getLogger(LoginValid.class);

	@SuppressWarnings("unchecked")
	public void doAction(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html;charset=UTF-8");
		Session session = ConnectionFactory.openSession();
		try (PrintWriter out = resp.getWriter()) {
			String login = req.getParameter("uname");
			Transaction trans = session.beginTransaction();
			Criteria cr = session.createCriteria(User.class);
			cr.add(Restrictions.eq("login", login));
			List<User> lst = cr.list();
			trans.commit();
			
			if (lst.size()==0) {
				out.println("<font color=\"green\"><b>" + login
						+ "</b> is avaliable</font>");
			} else {
				out.println("<font color=\"red\"><b>" + login
						+ "</b> is already in use</font>");
			}
			out.println();

		} catch (Exception e) {
			logger.error("Exception ", e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
	}

}
