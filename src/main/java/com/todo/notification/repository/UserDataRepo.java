package com.todo.notification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todo.notification.model.Todo;
import com.todo.notification.model.User;

@Repository
public interface UserDataRepo extends JpaRepository<User, Long> {

	@Query("select u from User u, Todo t where t.completed = true and t.subscribed = true and u.userId = t.userId")
	List<User> findCompletedTask();

//	SELECT u.user_id,t.user_id ,u.email, t.task, t.due_date, t.subscribed, t.priority
//	FROM user u, todo t
//	WHERE t.subscribed = true and 
//	u.user_id = t.user_id and
//	DATEDIFF(t.due_date,CURDATE()) <= 2;
	@Query("SELECT u\r\n" + "FROM User u, Todo t\r\n" + "WHERE t.subscribed = true and \r\n"
			+ "u.userId = t.userId and\r\n" + "DATEDIFF(t.dueDate,CURDATE()) <= 2")
	List<User> getTaskDueDateDetails();

}
