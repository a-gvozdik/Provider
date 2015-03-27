package artemgvozdik.provider_h.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import artemgvozdik.provider_h.ConnectionFactory;
import artemgvozdik.provider_h.bean.Service;

public class ServiceDAO {
	static Logger logger = Logger.getLogger(ServiceDAO.class);

	@SuppressWarnings("unchecked")
	public List<Service> getAll() {
		List<Service> servicelist = new ArrayList<Service>();
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			servicelist = session.createCriteria(Service.class).list();
			trans.commit();

		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
		return servicelist;

	}

	public Service getService(int id) {
		Service service = new Service();
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			service = (Service) session.get(Service.class, id);
			trans.commit();

		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}
		return service;
	}

	public void createService(Service service) {
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			session.save(service);
			trans.commit();

			logger.info("Service created " + service.getName());
		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}

	}

	public void deleteService(int id) {
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			session.delete((Service) session.get(Service.class, id));
			trans.commit();

		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}

	}

	public void updateService(Service service) {
		Session session = ConnectionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			session.update(service);
			trans.commit();
		} catch (Exception e) {
			logger.error("Exception " + e);
		} finally {
			ConnectionFactory.closeSession(session);
		}

	}
}
