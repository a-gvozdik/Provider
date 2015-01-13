package artemgvozdik.provider.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import artemgvozdik.provider.ConnectionFactory;
import artemgvozdik.provider.bean.User;

public class UserDAO {

	public List<User> getAll() {
		List<User> userlist = new ArrayList<User>();
		try (Connection con = ConnectionFactory.getConnection()) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM users");
			while (rs.next()) {
				User user = new User();
				user.setFirst_name(rs.getString("First_name"));
				user.setLast_name(rs.getString("Last_name"));
				user.setAddress(rs.getString("address"));
				user.setBalans(rs.getInt("balans"));
				user.setBirthday(rs.getDate("birthday"));
				user.setEmail(rs.getString("email"));
				user.setId(rs.getInt("ID"));
				user.setLogin(rs.getString("login"));
				user.setMac(rs.getString("MAC"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone_number"));
				user.setStatus(rs.getString("status"));
				user.setId_tariff(rs.getInt("id_tariff"));
				userlist.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userlist;

	}

	public User get(int id) {
		User user = new User();
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM users WHERE ID = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("ID"));
				user.setFirst_name(rs.getString("First_name"));
				user.setLast_name(rs.getString("Last_name"));
				user.setAddress(rs.getString("address"));
				user.setBalans(rs.getInt("balans"));
				user.setBirthday(rs.getDate("birthday"));
				user.setEmail(rs.getString("email"));
				user.setLogin(rs.getString("login"));
				user.setMac(rs.getString("MAC"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone_number"));
				user.setStatus(rs.getString("status"));
				user.setId_tariff(rs.getInt("id_tariff"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public void add(User user) {
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("insert into users (First_name, Last_name, address, balans, birthday, email, login, MAC, password, phone_number) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			String pass = user.getPassword();
			String passmd5 = DigestUtils.md5Hex (pass); 
			st.setString(1, user.getFirst_name());
			st.setString(2, user.getLast_name());
			st.setString(3, user.getAddress());
			st.setInt(4, user.getBalans());
			st.setDate(5, new Date(user.getBirthday().getTime()));
			st.setString(6, user.getEmail());
			st.setString(7, user.getLogin());
			st.setString(8, user.getMac());
			st.setString(9, passmd5);
			st.setString(10, user.getPhone());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(int id) {
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("DELETE FROM users WHERE id=?");
			st.setInt(1, id);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void passRenew(int id, String newpass) {
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("update users set password=? WHERE id=?");
			st.setInt(2, id);
			String pass = newpass;
			String passmd5 = DigestUtils.md5Hex (pass);
			st.setString(1, passmd5);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(User user) {
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("update users set First_name=?, Last_name=?, address=?, balans=?, birthday=?, email=?, login=?, MAC=?, status=?, phone_number=? where ID=? ");
			st.setInt(11, user.getId());
			st.setString(1, user.getFirst_name());
			st.setString(2, user.getLast_name());
			st.setString(3, user.getAddress());
			st.setInt(4, user.getBalans());
			st.setDate(5, new Date(user.getBirthday().getTime()));
			st.setString(6, user.getEmail());
			st.setString(7, user.getLogin());
			st.setString(8, user.getMac());
			st.setString(9, user.getStatus());
			st.setString(10, user.getPhone());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void changeTar(int id, int id_tariff) {
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("update users set id_tariff=? where ID=? ");
			st.setInt(1, id_tariff);
			st.setInt(2, id);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public User getLName(String lastname) {
		User user = new User();
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM users WHERE Last_name = ?");
			st.setString(1, lastname);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("ID"));
				user.setFirst_name(rs.getString("First_name"));
				user.setLast_name(rs.getString("Last_name"));
				user.setAddress(rs.getString("address"));
				user.setBalans(rs.getInt("balans"));
				user.setBirthday(rs.getDate("birthday"));
				user.setEmail(rs.getString("email"));
				user.setLogin(rs.getString("login"));
				user.setMac(rs.getString("MAC"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone_number"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public User getFNameLName(String firstname, String lastname) {
		User user = new User();
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM users WHERE First_name = ? AND Last_name = ?");
			st.setString(1, firstname);
			st.setString(2, lastname);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("ID"));
				user.setFirst_name(rs.getString("First_name"));
				user.setLast_name(rs.getString("Last_name"));
				user.setAddress(rs.getString("address"));
				user.setBalans(rs.getInt("balans"));
				user.setBirthday(rs.getDate("birthday"));
				user.setEmail(rs.getString("email"));
				user.setLogin(rs.getString("login"));
				user.setMac(rs.getString("MAC"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone_number"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public User login(String login, String password) {
		User user = null;
		try (Connection con = ConnectionFactory.getConnection()) {
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?");
			st.setString(1, login);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("ID"));
				user.setFirst_name(rs.getString("First_name"));
				user.setLast_name(rs.getString("Last_name"));
				user.setAddress(rs.getString("address"));
				user.setBalans(rs.getInt("balans"));
				user.setBirthday(rs.getDate("birthday"));
				user.setEmail(rs.getString("email"));
				user.setLogin(rs.getString("login"));
				user.setMac(rs.getString("MAC"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone_number"));
				user.setId_tariff(rs.getInt("id_tariff"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}
}
