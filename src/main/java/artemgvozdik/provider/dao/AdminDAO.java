package artemgvozdik.provider.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import artemgvozdik.provider.ConnectionFactory;
import artemgvozdik.provider.bean.Admin;

public class AdminDAO {

	public List<Admin> getAll() {
		List<Admin> adminlist = new ArrayList<Admin>();
		try (Connection con = ConnectionFactory.getConnection()) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM admins");
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setFirst_name(rs.getString("First_name"));
				admin.setLast_name(rs.getString("Last_name"));
				admin.setEmail(rs.getString("email"));
				admin.setId(rs.getInt("ID"));
				admin.setLogin(rs.getString("login"));
				admin.setPassword(rs.getString("password"));
				admin.setPhone(rs.getString("phone_number"));
				adminlist.add(admin);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adminlist;

	}

	public Admin getAdmin(int id) {
		Admin admin = new Admin();
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM admins WHERE ID = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				admin.setFirst_name(rs.getString("First_name"));
				admin.setLast_name(rs.getString("Last_name"));
				admin.setEmail(rs.getString("email"));
				admin.setId(rs.getInt("ID"));
				admin.setLogin(rs.getString("login"));
				admin.setPassword(rs.getString("password"));
				admin.setPhone(rs.getString("phone_number"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}
	
	public void passRenew(int id, String newpass) {
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("update admins set password=? WHERE id=?");
			st.setInt(2, id);
			String pass = newpass;
			String passmd5 = DigestUtils.md5Hex (pass);
			st.setString(1, passmd5);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void createAdmin(Admin admin) {
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("insert into admins (First_name, Last_name, email, login, password, phone_number) values (?, ?, ?, ?, ?, ?)");
			String pass = admin.getPassword();
			String passmd5 = DigestUtils.md5Hex (pass);
			st.setString(1, admin.getFirst_name());
			st.setString(2, admin.getLast_name());
			st.setString(3, admin.getEmail());
			st.setString(4, admin.getLogin());
			st.setString(5, passmd5);
			st.setString(6, admin.getPhone());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteAdmin(int id) {
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("DELETE FROM admins WHERE id=?");
			st.setInt(1, id);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(Admin admin) {
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("update admins set First_name=?, Last_name=?, email=?, login=?, phone_number=? where ID=? ");
			st.setInt(6, admin.getId());
			st.setString(1, admin.getFirst_name());
			st.setString(2, admin.getLast_name());
			st.setString(3, admin.getEmail());
			st.setString(4, admin.getLogin());
			st.setString(5, admin.getPhone());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public Admin login(String login, String password) {
		Admin admin = null;
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM admins WHERE login = ? AND password = ?");
			st.setString(1, login);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				admin = new Admin();
				admin.setFirst_name(rs.getString("First_name"));
				admin.setLast_name(rs.getString("Last_name"));
				admin.setEmail(rs.getString("email"));
				admin.setId(rs.getInt("ID"));
				admin.setLogin(rs.getString("login"));
				admin.setPassword(rs.getString("password"));
				admin.setPhone(rs.getString("phone_number"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;

	}
}
