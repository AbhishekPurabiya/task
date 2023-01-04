package SpringCore.TaskManagemenntJdbc.bean;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Component
public class User {

	private int userID ;
	private String userName ;
	private String password ;
}
