package artemgvozdik.provider.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import artemgvozdik.provider.ConnectionFactory;
import artemgvozdik.provider.bean.Tariff;


public class TariffDAO {
	static Logger logger = Logger.getLogger(TariffDAO.class);
	
	public List<Tariff> getAll() {
		List<Tariff> tarifflist = new ArrayList<Tariff>();
		try (Connection con = ConnectionFactory.getConnection()) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM tariff");
			while (rs.next()) {
				Tariff tariff = new Tariff();
				tariff.setName(rs.getString("Name"));
				tariff.setDescription(rs.getString("Description"));
				tariff.setID(rs.getInt("ID"));
				tariff.setPrice(rs.getDouble("Price"));
				tarifflist.add(tariff);
			}

		} catch (SQLException e) {
			logger.error("Exception ", e);
		}
		return tarifflist;

	}
	
	public Tariff getTariff(int id) {
		Tariff tariff = new Tariff();
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM tariff WHERE ID = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				tariff.setName(rs.getString("Name"));
				tariff.setDescription(rs.getString("Description"));
				tariff.setID(rs.getInt("ID"));
				tariff.setPrice(rs.getDouble("Price"));
			}

		} catch (SQLException e) {
			logger.error("Exception ", e);
		}
		return tariff;
	}
	
	public void createTariff(Tariff tariff) {
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("insert into tariff (Name, Description, Price) values (?, ?, ?)");
			st.setString(1, tariff.getName());
			st.setString(2, tariff.getDescription());
			st.setDouble(3, tariff.getPrice());
			st.executeUpdate();

		} catch (SQLException e) {
			logger.error("Exception ", e);
		}

	}
	public void deleteTariff(int id) {
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("DELETE FROM tariff WHERE ID=?");
			st.setInt(1, id);
			st.executeUpdate();

		} catch (SQLException e) {
			logger.error("Exception ", e);
		}

	}
	
	public void update(Tariff tariff) {
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("update tariff set Name=?, Description=?, Price=? where ID=? ");
			st.setInt(4, tariff.getID());
			st.setString(1, tariff.getName());
			st.setString(2, tariff.getDescription());
			st.setDouble(3, tariff.getPrice());
			st.executeUpdate();

		} catch (SQLException e) {
			logger.error("Exception ", e);
		}

	}
}
