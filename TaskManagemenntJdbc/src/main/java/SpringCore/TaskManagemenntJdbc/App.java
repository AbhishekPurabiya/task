package SpringCore.TaskManagemenntJdbc;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import SpringCore.TaskManagemenntJdbc.bean.Task;
import SpringCore.TaskManagemenntJdbc.bean.User;
import SpringCore.TaskManagemenntJdbc.service.TaskService;
import SpringCore.TaskManagemenntJdbc.service.UserService;

@Configuration
@ComponentScan(basePackages = "SpringCore.TaskManagemenntJdbc")
public class App {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		TaskService taskService = context.getBean(TaskService.class);
		Task task = context.getBean(Task.class);
		UserService userService = context.getBean(UserService.class);
		User user = context.getBean(User.class);

		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		String flag1 = "start";
		while (flag1.equals("start")) {

			System.out.println("******Wellcome******");
			System.out.println("1. Login");
			System.out.println("2. Register");

			int n = input.nextInt();
			switch (n) {
				case 1: {
					System.out.println("Enter Username :");
					String username = input.next();
					System.out.println("Enter Password : ");
					String password = input.next();
					boolean isValid = userService.checkUser(username, password);
					if (isValid == true) {
						boolean flag = true;
						while (flag == true) {
							System.out.println("Please Select your Option....");
							System.out.println("1. Add New Task");
							System.out.println("2. Update Task");
							System.out.println("3. View All Task");
							System.out.println("4. View Task By Id");
							System.out.println("5. Delete Task");
							System.out.println("6. Exit/Logout");

							int n1 = input.nextInt();

							switch (n1) {
								
								case 1: {
									System.out.println("Enter Task Id : ");
									int id = input.nextInt();
									System.out.println("Enter Task Name : ");
									String taskName = input1.nextLine();
									System.out.println();
									System.out.println("Enter Task Description : ");
									String description = input1.nextLine();
									System.out.println();
									task.setTaskId(id);
									task.setTaskName(taskName);
									task.setTaskDescription(description);
									taskService.saveTask(task);
									System.out.println("Task Added Successfully.....");
									break;
								}
								case 2: {
									System.out.println("Enter Task Id : ");
									int id = input.nextInt();
									System.out.println("Enter Task Name : ");
									String taskName = input1.nextLine();
									System.out.println();
									System.out.println("Enter Task Description : ");
									String description = input1.nextLine();
									System.out.println();
									task.setTaskId(id);
									task.setTaskName(taskName);
									task.setTaskDescription(description);
									taskService.updateTask(task);
									System.out.println("Task Updated Successfully.....");
									break;
								}
								case 3: {
									taskService.viewAllTask();
									break;
								}
								case 4: {
									System.out.println("Enter Task Id : ");
									int id = input.nextInt();
									taskService.viewTaskById(id);
									break;
								}
								case 5: {
									System.out.println("Enter Task Id : ");
									int id = input.nextInt();
									taskService.deleteTask(id);
									System.out.println("Task Deleted Successfully.....");
									break;
								}
								case 6: {
									System.out.println("ThankYou");
									flag = false;
									break;
								}
								default:
									System.err.println("Please Select Proper Option....");
									break;
							}
						}

					} else {
						System.err.println("In-Valid Username/Password...");
						System.err.println("try again...");
						flag1 = "start";
					}

					break;
				}
				case 2: {
					System.out.println("Enter User Id: ");
					int id = input.nextInt();
					System.out.println("Set Username :");
					String username = input.next();
					System.out.println("Set Password : ");
					String password = input.next();
					user.setUserID(id);
					user.setUserName(username);
					user.setPassword(password);
					try {
					int count = userService.saveUser(user);
					if(count > 0) {
						System.out.println("User Details Save Succeffully.....");
					}else {
						flag1 = "start";
					}
					}catch(Exception e) {
						e.printStackTrace();
					}

					
					break;
				}
				default:
					System.err.println("Please Select Proper Option....");
					return;
			}

		}
	}
}
