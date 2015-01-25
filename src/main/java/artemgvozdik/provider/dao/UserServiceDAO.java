package artemgvozdik.provider.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import artemgvozdik.provider.ConnectionFactory;
import artemgvozdik.provider.bean.Service;

public class UserServiceDAO {
	static Logger logger = Logger.getLogger(UserServiceDAO.class);

	public void makeUserOrder(int userid, int serviceid) {

		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("insert into user_service (ID_user, ID_service) values (?, ?)");
			st.setInt(1, userid);
			st.setInt(2, serviceid);
			st.executeUpdate();

		} catch (SQLException e) {
			logger.error("Exception ", e);
		}

	}

	public List<Service> selectByUser(int userid) {
		List<Service> uslist = new ArrayList<Service>();
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM service, user_service WHERE user_service.ID_user = ? and user_service.ID_service=service.ID");
			st.setInt(1, userid);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Service service = new Service();
				service.setID(rs.getInt("service.ID"));
				service.setDescription(rs.getString("service.Description"));
				service.setName(rs.getString("service.Name"));
				service.setPrice(rs.getDouble("service.Price"));
				service.setOrderstatus(rs.getString("user_service.Status"));
				uslist.add(service);
			}

		} catch (SQLException e) {
			logger.error("Exception ", e);
		}
		return uslist;

	}

}
