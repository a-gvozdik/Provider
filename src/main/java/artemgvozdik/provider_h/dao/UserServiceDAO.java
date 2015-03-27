package artemgvozdik.provider_h.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import artemgvozdik.provider_h.ConnectionFactory;
import artemgvozdik.provider_h.bean.ActiveService;
import artemgvozdik.provider_h.bean.Service;
import artemgvozdik.provider_h.bean.User;

public class UserServiceDAO {
	static Logger logger = Logger.getLogger(UserServiceDAO.class);

	public void makeUserOrder(int userid, int serviceid) {
		ActiveService acse = new ActiveService();
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			User user = (User) session.get(User.class, userid);
			acse.setUser(user);
			Service service = (Service) session.get(Service.class, serviceid);
			acse.setService(service);
			acse.setStatus("not done");
			session.save(acse);
			trans.commit();
		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}

	}

	@SuppressWarnings("unchecked")
	public List<ActiveService> selectByUser(int userid) {
		List<ActiveService> uslist = new ArrayList<ActiveService>();
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			User user = (User) session.get(User.class, userid);
			Criteria cr = session.createCriteria(ActiveService.class);
			cr.add(Restrictions.eq("user", user));
			uslist = cr.list();
			trans.commit();
		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
		return uslist;

	}

}
