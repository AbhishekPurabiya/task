package SpringCore.TaskManagemenntJdbc.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import SpringCore.TaskManagemenntJdbc.bean.Task;

@Repository
public class TaskDao {

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

	public int saveTask(Task task) {
		String insertQuery = "insert into Task(tid,name,description) values(?,?,?)";
		int count = 0;
		
		try {
			Connection con = TaskDao.getConnection();
			PreparedStatement stm = con.prepareStatement(insertQuery);
			stm.setInt(1, task.getTaskId());
			stm.setString(2, task.getTaskName());
			stm.setString(3, task.getTaskDescription());
			count = stm.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateTask(Task task) {
		String updateQuery = "update Task set name= ? , description= ? where tid= ? ";
		int count = 0;
		
		try {
			Connection con = TaskDao.getConnection();
			PreparedStatement stm = con.prepareStatement(updateQuery);

			stm.setString(1, task.getTaskName());
			stm.setString(2, task.getTaskDescription());
			stm.setInt(3, task.getTaskId());
			count = stm.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public void viewAllTask() {
		String selectQuery = "select * from Task";
		
		try {
			Connection con = TaskDao.getConnection();
			Statement stm = con.createStatement();
			// execute the query
			ResultSet result = stm.executeQuery(selectQuery);

			// using prints for formatting the table
			System.out.println("--------------------------------------------------------------------");
			System.out.printf("|%10s | %20s | %20s |\n", "Task Id", "Task Name", "Description");
			while (result.next()) {
				System.out.printf("|%10s | %20s | %20s |\n", result.getInt("tid"), result.getString("name"),
						result.getString("description"));
				System.out.println("--------------------------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewTaskById(int id) {
		String selectByIdQuery = "select * from Task where tid= ?";
		
		try {
			Connection con = TaskDao.getConnection();
			PreparedStatement stm = con.prepareStatement(selectByIdQuery);
			stm.setInt(1, id);
			// execute the query
			ResultSet result = stm.executeQuery();

			// using prints for formatting the table
			System.out.println("------------------------------------------------------------------------");
			System.out.printf("|%10s | %20s | %20s |\n", "Task Id", "Task Name", "Description");
			while (result.next()) {
				System.out.printf("|%10s | %20s | %20s |\n", result.getInt("tid"), result.getString("name"),
						result.getString("description"));
				System.out.println("--------------------------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTask(int id) {
		String selectByIdQuery = "select * from Task where tid= ?";
		
		try {
			Connection con = TaskDao.getConnection();
			PreparedStatement stm = con.prepareStatement(selectByIdQuery);
			stm.setInt(1, id);
			// execute the query
			ResultSet result = stm.executeQuery();

			System.out.println(" Task is deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
