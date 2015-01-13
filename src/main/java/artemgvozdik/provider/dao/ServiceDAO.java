package artemgvozdik.provider.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import artemgvozdik.provider.ConnectionFactory;
import artemgvozdik.provider.bean.Service;

public class ServiceDAO {
	public List<Service> getAll() {
		List<Service> servicelist = new ArrayList<Service>();
		try (Connection con = ConnectionFactory.getConnection()) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM service");
			while (rs.next()) {
				Service service = new Service();
				service.setName(rs.getString("Name"));
				service.setDescription(rs.getString("Description"));
				service.setID(rs.getInt("ID"));
				service.setPrice(rs.getDouble("Price"));
				servicelist.add(service);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return servicelist;

	}
	
	public Service getService(int id) {
		Service service = new Service();
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM service WHERE ID = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				service.setName(rs.getString("Name"));
				service.setDescription(rs.getString("Description"));
				service.setID(rs.getInt("ID"));
				service.setPrice(rs.getDouble("Price"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return service;
	}
	
	public void createService(Service service) {
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("insert into service (Name, Description, Price) values (?, ?, ?)");
			st.setString(1, service.getName());
			st.setString(2, service.getDescription());
			st.setDouble(3, service.getPrice());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void deleteService(int id) {
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("DELETE FROM service WHERE id=?");
			st.setInt(1, id);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void updateService(Service service) {
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("update service set Name=?, Description=?, Price=? where ID=? ");
			st.setInt(4, service.getID());
			st.setString(1, service.getName());
			st.setString(2, service.getDescription());
			st.setDouble(3, service.getPrice());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
