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
import artemgvozdik.provider_h.bean.Admin;

public class AdminDAO {
	static Logger logger = Logger.getLogger(AdminDAO.class);

	@SuppressWarnings("unchecked")
	public List<Admin> getAll() {
		List<Admin> adminlist = new ArrayList<Admin>();
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			adminlist = session.createCriteria(Admin.class).list();
			trans.commit();

		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
		Collections.sort(adminlist, new AdminSort());
		return adminlist;

	}

	public Admin getAdmin(int id) {
		Admin admin = new Admin();
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			admin = (Admin) session.get(Admin.class, id);
			trans.commit();

		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
		return admin;
	}

	public void passRenew(int id, String newpass) {
		logger.info("Admin passRenew method started");
		Session session = ConnectionFactory.openSession();
		try {
			String pass = newpass;
			String passmd5 = DigestUtils.md5Hex(pass);
			Transaction trans = session.beginTransaction();
			Admin admin = (Admin) session.get(Admin.class, id);
			admin.setPassword(passmd5);
			session.update(admin);
			trans.commit();
			logger.info("Admin passRenew method finished");
		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
	}

	public void createAdmin(Admin admin) {
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			session.save(admin);
			trans.commit();
			
		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
	}

	public void deleteAdmin(int id) {
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			session.delete((Admin) session.get(Admin.class, id));
			trans.commit();
			
		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
	}

	public void update(Admin admin) {
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			session.update(admin);
			trans.commit();
			
		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}

	}

	@SuppressWarnings("unchecked")
	public Admin login(String login, String password) {
		logger.info("Admin login method started");
		Admin admin = null;
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			Criteria cr = session.createCriteria(Admin.class);
			cr.add(Restrictions.eq("login", login));
			cr.add(Restrictions.eq("password", password));
			List<Admin> lst = cr.list();
			trans.commit();
			if (lst.size() > 0) {
				admin = (Admin) lst.get(0);
			}
			logger.info("Admin login method finished" + " Admin = "
					+ admin.getLogin());
		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
		return admin;

	}
	
	class AdminSort implements Comparator<Admin> {

		@Override
		public int compare(Admin us1, Admin us2) {
			Integer a = new Integer(us1.getId());
			Integer b = new Integer(us2.getId());
			return a.compareTo(b);
		}

	}
}
