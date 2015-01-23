package cloud.sit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This is a Helper class requrired to establish database connection.
 * 
 * @author SridharR
 * 
 */
public class JDBCHelper {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(Constants.DRIVERNAME);
			String url = Constants.URL;
			String uid = Constants.UID;
			String pwd = Constants.PWD;

			con = DriverManager.getConnection(url, uid, pwd);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement s) {
		try {
			if (s != null)
				s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection con) {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
