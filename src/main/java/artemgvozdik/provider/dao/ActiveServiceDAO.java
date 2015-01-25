package artemgvozdik.provider.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

import artemgvozdik.provider.ConnectionFactory;
import artemgvozdik.provider.bean.ActiveService;
import artemgvozdik.provider.bean.Service;
import artemgvozdik.provider.bean.User;

public class ActiveServiceDAO {
	static Logger logger = Logger.getLogger(ActiveServiceDAO.class);

	public List<ActiveService> getAllActive() {
		List<ActiveService> laservice = new ArrayList<ActiveService>();
		try (Connection con = ConnectionFactory.getConnection()) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM user_service");
			while (rs.next()) {
				ActiveService as = new ActiveService();
				as.setID_order(rs.getInt("ID_order"));
				User user = new User();
				UserDAO udao = new UserDAO();
				user = udao.get(rs.getInt("ID_user"));
				as.setUser(user);
				Service service = new Service();
				ServiceDAO sdao = new ServiceDAO();
				service = sdao.getService(rs.getInt("ID_service"));
				as.setService(service);
				as.setStatus(rs.getString("Status"));
				laservice.add(as);
			}

		} catch (SQLException e) {
			logger.error("Exception ", e);
		}
		laservice.sort(new StatusSort());
		return laservice;
	}

	public void changeStatus(int ID_order, String status) {
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("update user_service set Status=? where ID_order=?");
			st.setInt(2, ID_order);
			if (status.equals("not done")) {
				st.setString(1, "done");
			} else {
				st.setString(1, "not done");
			}

			st.executeUpdate();

		} catch (SQLException e) {
			logger.error("Exception ", e);
		}
	}

	public void deleteOrder(int ID_order) {
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("DELETE FROM user_service where ID_order=?");
			st.setInt(1, ID_order);
			st.executeUpdate();

		} catch (SQLException e) {
			logger.error("Exception ", e);
		}
	}

	class StatusSort implements Comparator<ActiveService> {

		@Override
		public int compare(ActiveService as1, ActiveService as2) {
			return as2.getStatus().compareTo(as1.getStatus());
		}

	}

}
