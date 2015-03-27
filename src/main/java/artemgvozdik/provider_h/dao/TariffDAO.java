package artemgvozdik.provider_h.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import artemgvozdik.provider_h.ConnectionFactory;
import artemgvozdik.provider_h.bean.Tariff;

public class TariffDAO {
	static Logger logger = Logger.getLogger(TariffDAO.class);

	@SuppressWarnings("unchecked")
	public List<Tariff> getAll() {
		List<Tariff> tarifflist = new ArrayList<Tariff>();
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			tarifflist = session.createCriteria(Tariff.class).list();
			trans.commit();

		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
		return tarifflist;

	}

	public Tariff getTariff(int id) {
		Tariff tariff = new Tariff();
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			tariff = (Tariff) session.get(Tariff.class, id);
			trans.commit();

		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
		return tariff;
	}

	public void createTariff(Tariff tariff) {
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			session.save(tariff);
			trans.commit();

			logger.info("Tariff created " + tariff.getName());
		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}

	}

	public void deleteTariff(int id) {
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			session.delete((Tariff) session.get(Tariff.class, id));
			trans.commit();

		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}

	}

	public void update(Tariff tariff) {
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			session.update(tariff);
			trans.commit();

		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}

	}
}
