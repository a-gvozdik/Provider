package artemgvozdik.provider_h.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import artemgvozdik.provider_h.ConnectionFactory;
import artemgvozdik.provider_h.bean.Tariff;
import artemgvozdik.provider_h.bean.User;

public class UserDAO {
	static Logger logger = Logger.getLogger(UserDAO.class);

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		List<User> userlist = new ArrayList<User>();
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			userlist = session.createCriteria(User.class).list();
			trans.commit();

		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
		Collections.sort(userlist, new UserSort());
		return userlist;

	}

	public User get(int id) {
		User user = new User();
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			user = (User) session.get(User.class, id);
			trans.commit();

		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
		return user;
	}

	public void add(User user) {
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			Tariff tariff = (Tariff) session.get(Tariff.class, 1);
			user.setTariff(tariff);
			session.save(user);
			trans.commit();

		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}

	}

	public void delete(int id) {
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			session.delete((User)session.get(User.class, id));
			trans.commit();

		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}

	}

	public void passRenew(int id, String newpass) {
		Session session = ConnectionFactory.openSession();
		try {
			logger.info("User passRenew method started");
			String pass = newpass;
			String passmd5 = DigestUtils.md5Hex(pass);
			Transaction trans = session.beginTransaction();
			User user = (User) session.get(User.class, id);
			user.setPassword(passmd5);
			session.update(user);
			trans.commit();

			logger.info("User passRenew method finished");
		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
	}

	public void update(User user) {
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			session.update(user);
			trans.commit();
		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}

	}

	public User changeTar(User user, int id_tariff) {
		Session session = ConnectionFactory.openSession();
		try {
			logger.info("User changeTar method started");
			Transaction trans = session.beginTransaction();
			Tariff tariff = (Tariff) session.get(Tariff.class, id_tariff);
			user.setTariff(tariff);
			session.update(user);
			trans.commit();

			logger.info("User changeTar method finished");
		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
		return user;

	}

	@SuppressWarnings("unchecked")
	public User login(String login, String password) {
		logger.info("User login method started");
		User user = null;
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			Criteria cr = session.createCriteria(User.class);
			cr.add(Restrictions.eq("login", login));
			cr.add(Restrictions.eq("password", password));
			List<User> lst = cr.list();
			trans.commit();
			if (lst.size() > 0) {
				user = (User) lst.get(0);
			}
			logger.info("User login method finished" + " User = "
					+ user.getLogin());
		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
		return user;

	}
	
	class UserSort implements Comparator<User> {

		@Override
		public int compare(User us1, User us2) {
			Integer a = new Integer(us1.getId());
			Integer b = new Integer(us2.getId());
			return a.compareTo(b);
		}

	}
}
