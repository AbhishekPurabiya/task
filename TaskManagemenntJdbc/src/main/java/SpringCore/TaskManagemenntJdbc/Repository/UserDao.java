package SpringCore.TaskManagemenntJdbc.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import SpringCore.TaskManagemenntJdbc.bean.User;

@Repository
public class UserDao {

	
	public static Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userName = "system";
		String passward = "Abhi1234";
		Connection con = null;
		try {
			// register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// make the connection
			con = DriverManager.getConnection(url, userName, passward);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public int saveUser(User user) {
		String insertQuery = "insert into userdetail(USERID , USERNAME, PASS) values(?, ?, ?)";
		int count = 0;
		
		try {
			Connection con = TaskDao.getConnection();
			PreparedStatement stm = con.prepareStatement(insertQuery);
			stm.setInt(1, user.getUserID());
			stm.setString(2, user.getUserName());
			stm.setString(3, user.getPassword());
			count = stm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public boolean checkUser(String username, String password) {
		String query = "select * from userdetail where username= ? And pass= ?";
		
		boolean isValid = false;
		try {
			Connection con = TaskDao.getConnection();
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, username);
			stm.setString(2, password);
			ResultSet result = stm.executeQuery();
			while(result.next()) {
				isValid = true ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}
}
