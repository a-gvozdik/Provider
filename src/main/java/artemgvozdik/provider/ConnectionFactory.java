package artemgvozdik.provider;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionFactory {
	static Logger logger = Logger.getLogger(ConnectionFactory.class);
	private static String DB_HOST;
	private static String DB_DATABASE;
	private static String LOGIN;
	private static String PASSWORD;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			logger.error("Exception static block ", e);
		}
	}

	public static Connection getConnection() throws SQLException {
		Properties property = new Properties();
		try {
			property.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("config.properties"));
			DB_HOST = property.getProperty("DB_HOST");
			DB_DATABASE = property.getProperty("DB_DATABASE");
			LOGIN = property.getProperty("LOGIN");
			PASSWORD = property.getProperty("PASSWORD");

		} catch (IOException e) {
			logger.error("Exception. getConnection method ", e);
		}
		String url = "jdbc:mysql://" + DB_HOST + "/" + DB_DATABASE;
		return DriverManager.getConnection(url, LOGIN, PASSWORD);
	}



/*public class ConnectionFactory {
	private static final String DB_HOST="localhost:3306";
	private static final String DB_DATABASE="provider";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://" + DB_HOST + "/" + DB_DATABASE;
		return DriverManager.getConnection(url, "root", "root");
	}*/
}
