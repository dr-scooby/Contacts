 * Database connection
 * ContactsTest
 */
package Database;

/**
 * MySQL driver version:
 * <artifactId>mysql-connector-java</artifactId>
 *  <version>8.0.28</version>
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author J. Ismail
 *
 */
public class DB {
	
	private String url = "jdbc:mysql://194.168.2.69:3306/Skyhawk";
	private String user = "nurali";
	private String pass = "java1973";
	
	private Connection con;
	
	// `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'.
	
	public DB() {
		try {
			System.out.println("DB init, loading MySQL..");
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con = DriverManager.getConnection(url, user, pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}catch(ClassNotFoundException c) {
			System.err.println(c);
		}
	}

	/**
	 * Get a Database Connection
	 * @return Connection
	 */
	public Connection getConnection() {
		return con;
	}
	
	public void open() {
		try {
			System.out.println("DB open, starting MySQL connection..");
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con = DriverManager.getConnection(url, user, pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}catch(ClassNotFoundException c) {
			System.err.println(c);
		}
	}
	
	/**
	 * close the DB connection
	 */
	public void close() {
		try {
			con.close();
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	/**
	 * Add Contact
	 * @param name String
	 * @param email String
	 */
	public boolean addContact(String name, String email) {
		String sql = "insert into contacts(name, email) value(?, ?)";
		boolean ok = false;
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, email);
			
			ok = pst.executeUpdate() > 0;
			
		} catch (SQLException e) {
			System.err.println("Failed to add Contact");
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ok;
	}
}
