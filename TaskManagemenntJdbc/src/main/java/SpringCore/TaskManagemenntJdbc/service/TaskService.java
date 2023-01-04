package SpringCore.TaskManagemenntJdbc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringCore.TaskManagemenntJdbc.Repository.TaskDao;
import SpringCore.TaskManagemenntJdbc.bean.Task;

@Service
public class TaskService {
	
	@Autowired
	TaskDao taskDao ;
	
	public int saveTask(Task task) {
		int count = taskDao.saveTask(task);
		return count ;
	}
	
	public int updateTask(Task task) {
		int count = taskDao.updateTask(task);
		return count ;
	}
	
	public void viewAllTask() {
		taskDao.viewAllTask();
	}
	
	public void viewTaskById(int id) {
		taskDao.viewTaskById(id);
	}
	
	public void deleteTask(int id) {
		taskDao.deleteTask(id);
	}
}
