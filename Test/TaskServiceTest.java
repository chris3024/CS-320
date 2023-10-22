package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import modules.TaskService;

class TaskServiceTest {

	@DisplayName("Adding Task to ArrayList")
	@Test
	void testAddTask() {
		TaskService taskService = new TaskService();
		
		TaskService.taskList.clear();
		taskService.addTask("Clean Room", "Clean bedroom spotless");
		taskService.addTask("Mow Yard", "Mow entire yard and weedeat");
		
		assertEquals("Clean Room", TaskService.taskList.get(0).getTaskName());
		assertEquals("Mow Yard", TaskService.taskList.get(1).getTaskName());
		
		taskService.displayTasks();
	}
	
	@DisplayName("Testing Unique ID")
	@Test
	void testUniqueId() {
		TaskService taskService = new TaskService();
		
		TaskService.taskList.clear();
		taskService.addTask("Clean Room", "Clean bedroom spotless");
		taskService.addTask("Mow Yard", "Mow entire yard and weedeat");
		
		assertTrue(TaskService.taskList.get(0).getTaskId() != TaskService.taskList.get(1).getTaskId());
		assertTrue(TaskService.taskList.get(0).getTaskId() == TaskService.taskList.get(0).getTaskId());
		
	}
	
	@DisplayName("Test Task Deletion")
	@Test
	void testTaskDelete() {
		TaskService taskService = new TaskService();
		
		TaskService.taskList.clear();
		taskService.addTask("Clean Room", "Clean bedroom spotless");
		taskService.addTask("Mow Yard", "Mow entire yard and weedeat");
		
		assertEquals(2, TaskService.taskList.size());
		
		String taskId = TaskService.taskList.get(0).getTaskId();
		taskService.deleteTask(taskId);
		
		taskService.displayTasks();
		
	}
	
	@DisplayName("Update Task Name")
	@Test
	void testUpdateTaskName() {
		TaskService taskService = new TaskService();
		
		TaskService.taskList.clear();
		taskService.addTask("Clean Room", "Clean bedroom spotless");
		taskService.addTask("Mow Yard", "Mow entire yard and weedeat");
		
		String taskId = TaskService.taskList.get(0).getTaskId();
		
		assertEquals("Clean Room", TaskService.taskList.get(0).getTaskName());
		taskService.updateTaskName(taskId, "Do the Dishes");
		
		assertEquals("Do the Dishes", TaskService.taskList.get(0).getTaskName());
	}
	
	@DisplayName("Update Task Description")
	@Test
	void testUpdateTaskDescription() {
		TaskService taskService = new TaskService();
		
		TaskService.taskList.clear();
		taskService.addTask("Clean Room", "Clean bedroom spotless");
		taskService.addTask("Mow Yard", "Mow entire yard and weedeat");
		
		String taskId = TaskService.taskList.get(0).getTaskId();
		assertEquals("Clean bedroom spotless", TaskService.taskList.get(0).getTaskDescription());
		taskService.updateTaskDecription(taskId, "Clean Floors and Make Bed");
		
		assertEquals("Clean Floors and Make Bed", TaskService.taskList.get(0).getTaskDescription());
	}
}
