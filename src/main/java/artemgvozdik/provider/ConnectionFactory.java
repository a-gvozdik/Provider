package artemgvozdik.provider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
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
	}
}
