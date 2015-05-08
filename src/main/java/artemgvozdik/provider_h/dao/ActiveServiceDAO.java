package artemgvozdik.provider_h.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import artemgvozdik.provider_h.ConnectionFactory;
import artemgvozdik.provider_h.bean.ActiveService;

public class ActiveServiceDAO {
	static Logger logger = Logger.getLogger(ActiveServiceDAO.class);

	@SuppressWarnings("unchecked")
	public List<ActiveService> getAllActive() {
		List<ActiveService> laservice = new ArrayList<ActiveService>();
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			laservice = session.createCriteria(ActiveService.class).list();
			trans.commit();

		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
		Collections.sort(laservice, new StatusSort());
		return laservice;
	}

	public void changeStatus(int ID_order, String status) {
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			ActiveService acse = (ActiveService) session.get(
					ActiveService.class, ID_order);
			if (status.equals("not done")) {
				acse.setStatus("done");
			} else {
				acse.setStatus("not done");
			}
			session.update(acse);
			trans.commit();

		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}

	}

	public void deleteOrder(int ID_order) {
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			session.delete((ActiveService) session.get(ActiveService.class,
					ID_order));
			trans.commit();

		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
	}

	class StatusSort implements Comparator<ActiveService> {

		@Override
		public int compare(ActiveService as1, ActiveService as2) {
			Integer a = new Integer(as1.getUser().getId());
			Integer b = new Integer(as2.getUser().getId());
			return a.compareTo(b);
		}

	}

}
